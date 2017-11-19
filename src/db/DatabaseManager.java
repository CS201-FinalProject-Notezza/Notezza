package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import objects.Comment;
import objects.Course;
import objects.Note;
import objects.Presentation;
import objects.Quiz;
import objects.User;

public class DatabaseManager {
	
	private Map<String, User> allUsers;
	private Map<String, Course> allCourses;
	private DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
	
	public DatabaseManager() {
		allUsers = new HashMap<String, User>();
		allCourses = new HashMap<String, Course>();
		initializeObjectTree();
	}
	
	public Map<String, User> getAllUsers() {
		return allUsers;
	}
	
	public Map<String, Course> getAllCourses() {
		return allCourses;
	}
	
	public void initializeObjectTree() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			Vector<User> userObjects = new Vector<User>();
			Vector<Course> courseObjects = new Vector<Course>();
						
			HashMap<Integer, User> userIDToObject = new HashMap<Integer, User>();
			HashMap<Integer, Course> courseIDToObject = new HashMap<Integer, Course>();
			HashMap<Integer, Vector<User>> courseIDToUsers = new HashMap<Integer, Vector<User>>();
			
			rs = st.executeQuery("SELECT * FROM UserTable");
			while (rs.next()) {
				int userID = rs.getInt("userID");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String username = rs.getString("username");
				String email = rs.getString("email");
				long pword = rs.getLong("pword");
				Boolean isInstructor = Boolean.parseBoolean(rs.getString("isInstructor"));
				Boolean isVisible = Boolean.parseBoolean(rs.getString("isVisible"));
				
				User createdUser = new User(fname, lname, username, email, pword, isInstructor, isVisible);
				
				userObjects.add(createdUser);
				userIDToObject.put(userID, createdUser);
			}
			
			rs = st.executeQuery("SELECT * FROM UserCourse");
			while (rs.next()) {
				int userID = rs.getInt("userID");
				int courseID = rs.getInt("courseID");
				
				if (!courseIDToUsers.containsKey(courseID)) {
					Vector<User> newUserVector = new Vector<User>();
					newUserVector.add(userIDToObject.get(userID));
					courseIDToUsers.put(courseID, newUserVector);
				} else {
					// Add the user object with ID userID to the vector of users with the given courseID
					courseIDToUsers.get(courseID).add(userIDToObject.get(userID));
				}
				
			}
			
			rs = st.executeQuery("SELECT * FROM Course");
			while (rs.next()) {
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int instructorID = rs.getInt("instructorID");
				
				Course createdCourse = new Course(courseName, userIDToObject.get(instructorID), courseIDToUsers.get(courseID));
				courseObjects.add(createdCourse);
				courseIDToObject.put(courseID, createdCourse);
			}
			
			HashMap<Integer, Vector<String>> courseIDToLinks = new HashMap<Integer, Vector<String>>();
			
			rs = st.executeQuery("SELECT * FROM PresentationLink");
			while (rs.next()) {
				String link = rs.getString("link");
				int courseID = rs.getInt("courseID");
				
				if (!courseIDToLinks.containsKey(courseID)) {
					Vector<String> newLinkVector = new Vector<String>();
					newLinkVector.add(link);
					courseIDToLinks.put(courseID, newLinkVector);
				} else {
					courseIDToLinks.get(courseID).add(link);
				}
			}
			
			HashMap<Integer, String> questionIDToContent = new HashMap<Integer, String>();
			HashMap<Integer, Vector<Integer>> courseIDToQuestionIDs = new HashMap<Integer, Vector<Integer>>();
			
			rs = st.executeQuery("SELECT * FROM PresentationQuestion");
			while (rs.next()) {
				int questionID = rs.getInt("questionID");
				String content = rs.getString("content");
				int courseID = rs.getInt("courseID");
				
				questionIDToContent.put(questionID, content);
				
				if (!courseIDToQuestionIDs.containsKey(courseID)) {
					Vector<Integer> newIntVector = new Vector<Integer>();
					newIntVector.add(questionID);
					courseIDToQuestionIDs.put(courseID, newIntVector);
				} else {
					courseIDToQuestionIDs.get(courseID).add(questionID);
				}
			}
			
			HashMap<Integer, Vector<String>> questionIDToChoices = new HashMap<Integer, Vector<String>>();
			HashMap<Integer, Set<Integer>> questionIDToAnswers = new HashMap<Integer, Set<Integer>>();
			
			rs = st.executeQuery("SELECT * FROM QuestionChoice");
			while (rs.next()) {
				String content = rs.getString("content");
				Boolean correctBool = Boolean.parseBoolean(rs.getString("correctBool"));
				int questionID = rs.getInt("questionID");
				
				if (!questionIDToChoices.containsKey(questionID)) {
					Vector<String> newChoiceVector = new Vector<String>();
					newChoiceVector.add(content);
					questionIDToChoices.put(questionID, newChoiceVector);
				} else {
					questionIDToChoices.get(questionID).add(content);
				}
				
				// If the parsed answer is a correct one, add its index in the vector of strings to
				// the set of indices of correct answers
				if (!questionIDToAnswers.containsKey(questionID) && correctBool) {
					HashSet<Integer> newCorrectIndexSet = new HashSet<Integer>();
					newCorrectIndexSet.add(questionIDToChoices.get(questionID).size() - 1);
					questionIDToAnswers.put(questionID, newCorrectIndexSet);
				} else if (correctBool) {
					questionIDToAnswers.get(questionID).add(questionIDToChoices.get(questionID).size() - 1);
				}
			}
			
			HashMap<Integer, Vector<Quiz>> courseIDToQuizObjects = new HashMap<Integer, Vector<Quiz>>();
			
			// For the vector of question IDs for each course, create a quiz object and place in map
			for (int courseID : courseIDToQuestionIDs.keySet()) {
				Vector<Integer> questionIDs = courseIDToQuestionIDs.get(courseID);
				for (int questionID : questionIDs) {
					Quiz newQuiz = new Quiz(questionIDToContent.get(questionID), questionIDToChoices.get(questionID), questionIDToAnswers.get(questionID));
					
					if (!courseIDToQuizObjects.containsKey(courseID)) {
						Vector<Quiz> newQuizVector = new Vector<Quiz>();
						newQuizVector.add(newQuiz);
						courseIDToQuizObjects.put(courseID, newQuizVector);
					} else {
						courseIDToQuizObjects.get(courseID).add(newQuiz);
					}
				}
			}
			
			for (int courseID : courseIDToLinks.keySet()) {
				Presentation newPresentation = new Presentation(courseIDToLinks.get(courseID), courseIDToQuizObjects.get(courseID));
				courseIDToObject.get(courseID).setCurrentLecture(newPresentation);
			}
			
			HashMap<Integer, Vector<String>> noteIDToTags = new HashMap<Integer, Vector<String>>();
			
			rs = st.executeQuery("SELECT * FROM Tag");
			while (rs.next()) {
				String tag = rs.getString("tag");
				int noteID = rs.getInt("noteID");
				
				if (!noteIDToTags.containsKey(noteID)) {
					Vector<String> newTagVector = new Vector<String>();
					newTagVector.add(tag);
					noteIDToTags.put(noteID, newTagVector);
				} else {
					noteIDToTags.get(noteID).add(tag);
				}
			}
			
			HashMap<Integer, Vector<Note>> courseIDToNoteObjects = new HashMap<Integer, Vector<Note>>();
			HashMap<Integer, Note> noteIDToObject = new HashMap<Integer, Note>();
			
			rs = st.executeQuery("SELECT * FROM Note");
			while (rs.next()) {
				int noteID = rs.getInt("noteID");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String postedDate = rs.getString("postedDate");
				int courseID = rs.getInt("courseID");
				int userID = rs.getInt("userID");
				
				Date created = null;
				try {
					created = df.parse(postedDate);
				} catch (ParseException pe) {
					System.out.println("Exception parsing date: " + pe.getMessage());
				}
				
				Note newNote = new Note(userIDToObject.get(userID), title, noteIDToTags.get(noteID), created, content);
				if (!courseIDToNoteObjects.containsKey(courseID)) {
					Vector<Note> newNoteVector = new Vector<Note>();
					newNoteVector.add(newNote);
					courseIDToNoteObjects.put(courseID, newNoteVector);
				} else {
					courseIDToNoteObjects.get(courseID).add(newNote);
				}
				
				noteIDToObject.put(noteID, newNote);
			}
			
			for (int courseID : courseIDToNoteObjects.keySet()) {
				courseIDToObject.get(courseID).setAllNotes(courseIDToNoteObjects.get(courseID));
			}

			rs = st.executeQuery("SELECT * FROM NoteVote");
			while (rs.next()) {
				Boolean likeBool = Boolean.parseBoolean(rs.getString("likeBool"));
				int userID = rs.getInt("userID");
				int noteID = rs.getInt("noteID");
				
				if (likeBool) {
					noteIDToObject.get(noteID).addLike(userIDToObject.get(userID));
				} else {
					noteIDToObject.get(noteID).addDislike(userIDToObject.get(userID));
				}
			}
			
			HashMap<Integer, Comment> commentIDToObject = new HashMap<Integer, Comment>();
			
			rs = st.executeQuery("SELECT * FROM NoteComment");
			while (rs.next()) {
				int commentID = rs.getInt("commentID");
				String content = rs.getString("content");
				String postedDate = rs.getString("postedDate");
				int noteID = rs.getInt("noteID");
				int userID = rs.getInt("userID");
				
				Date created = null;
				try {
					created = df.parse(postedDate);
				} catch (ParseException pe) {
					System.out.println("Exception parsing date: " + pe.getMessage());
				}
				
				Comment newComment = new Comment(userIDToObject.get(userID), content, created, noteIDToObject.get(noteID));
				commentIDToObject.put(commentID, newComment);
				noteIDToObject.get(noteID).addComment(newComment);
			}
			
			rs = st.executeQuery("SELECT * FROM CommentVote");
			while (rs.next()) {
				Boolean likeBool = Boolean.parseBoolean(rs.getString("likeBool"));
				int userID = rs.getInt("userID");
				int commentID = rs.getInt("commentID");
				
				if (likeBool) {
					commentIDToObject.get(commentID).addLike(userIDToObject.get(userID));
				} else {
					commentIDToObject.get(commentID).addDislike(userIDToObject.get(userID));
				}
			}
			
			System.out.println("All Users:");
			for (User u : userObjects) {
				System.out.println("\t" + u.getFname() + " " + u.getLname() + " " + u.getEmail() + " " + u.getUsername() + " " + u.getPassword() + " " + Boolean.toString(u.isInstructor()) + " " + Boolean.toString(u.isVisible()));
			}
			
			System.out.println("\nAll Courses:");
			for (Course c : courseObjects) {
				System.out.println("\t" + c.getCourseName());
				User instr = c.getInstructor();
				System.out.println("\t\tInstructor: " + instr.getUsername());
				Vector<User> students = c.getStudents();
				for (User stu : students) {
					if (stu != instr) { System.out.println("\t\tStudent: " + stu.getUsername()); }
				}
				
				for (Note no : c.getAllNotes()) {
					System.out.println("\t\tNote: " + no.getUser().getUsername() + " posted " + no.getTitle() + " on " + df.format(no.getDateCreated()).toString());
					System.out.println("\t\t\tScore: " + no.getRating());
					System.out.print("\t\t\tTags: | ");
					for (String tag : no.getTags()) {
						System.out.print(tag + " | ");
					}
					System.out.println("");
					for (Comment co : no.getComments())
					System.out.println("\t\t\tComment: " + co.getUser().getUsername() + " commented " + co.getContent() + " on " + df.format(co.getDateCreated()).toString() + " with score " + co.getScore());
					
				}
				
				Presentation p = c.getCurrentLecture();
				System.out.println("\t\tPresentation:");
				if (p != null) {
					for (String link : p.getLinks()) {
						System.out.println("\t\t\tLink: " + link);
					}
					for (Quiz qu : p.getQuizzes()) {
						System.out.println("\t\t\tQuestion: " + qu.getQuestion());
						Vector<String> choices = qu.getChoices();
						Set<Integer> answers = qu.getAnswers();
						for (int i = 0; i < choices.size(); i++) {
							System.out.print("\t\t\t\tChoice: " + choices.get(i));
							if (answers.contains(i)) { System.out.print(" CORRECT"); }
							System.out.println("");
						}
					}
				}
			}
			
			for (User u : userObjects) {
				allUsers.put(u.getUsername(), u);
			}
			for (Course c : courseObjects) {
				allCourses.put(c.getCourseName(), c);
			}
			
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public void addUser(User u) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			String updateString = "INSERT INTO UserTable (fname, lname, username, email, pword, isInstructor, isVisible) VALUES (";
			updateString += "'" + u.getFname() + "', '" + u.getLname() + "', '" + u.getUsername() + "', '" + u.getEmail() + "', '" + u.getPassword() + "', '" + Boolean.toString(u.isInstructor()) + "', '" + Boolean.toString(u.isVisible()) + "');";
			
			st.executeUpdate(updateString);
			
			allUsers.put(u.getUsername(), u);
			
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public void addComment(Comment c) {
						
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			String updateString = "INSERT INTO NoteComment (content, postedDate, noteID, userID) VALUES (";
			updateString += "'" + c.getContent() + "', '" + df.format(c.getDateCreated()) + "', "; 
			
			rs = st.executeQuery("SELECT * FROM Note WHERE title='" + c.getNote().getTitle() + "' AND content='" + c.getNote().getTextContent() + "' AND postedDate='" + df.format(c.getNote().getDateCreated()) + "'");
			int noteID = -1;
			int courseID = -1;
			while (rs.next()) {
				noteID = rs.getInt("noteID");
				courseID = rs.getInt("courseID");
			}
			updateString += noteID + ", ";
			
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + c.getUser().getUsername() + "'");
			int userID = -1;
			while (rs.next()) {
				userID = rs.getInt("userID");
			}
			updateString += userID + ")";
			
			st.executeUpdate(updateString);
			
			// Get the course name of the note associated with the comment the note is posted on
			rs = st.executeQuery("SELECT * FROM Course WHERE courseID=" + courseID);
			String courseName = "";
			while (rs.next()) {
				courseName = rs.getString("courseName");
			}
			
			for (Note n : allCourses.get(courseName).getAllNotes()) {
				if (n.equals(c.getNote())) {
					n.addComment(c);
				}
			}
			
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public void addCourse(Course c) {
						
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			String updateCourseString = "INSERT INTO Course (courseName, instructorID) VALUES (";
			updateCourseString += "'" + c.getCourseName() + "', "; 
			
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + c.getInstructor().getUsername() + "'");
			int instructorID = -1;
			while (rs.next()) {
				instructorID = rs.getInt("userID");
			}
			updateCourseString += instructorID + ")";
			
			st.executeUpdate(updateCourseString);
			
			// Get the courseID of the newly added course
			rs = st.executeQuery("SELECT * FROM Course WHERE courseName='" + c.getCourseName() + "' AND instructorID=" + instructorID);
			int courseID = -1;
			while (rs.next()) {
				courseID = rs.getInt("courseID");
			}
			
			Vector<User> usersToAdd = c.getStudents();
			usersToAdd.add(c.getInstructor());
			String updateUserCourseString = "INSERT INTO UserCourse (userID, courseID) VALUES ";
			Boolean first = true;
			
			for (User u : usersToAdd) {
				
				rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + u.getUsername() + "'");
				int userID = -1;
				while (rs.next()) {
					userID = rs.getInt("userID");
				}
				
				if (userID != -1) {
					if (!first) { updateUserCourseString += ", "; }
					updateUserCourseString += "(" + userID + ", " + courseID + ")";
					first = false;
				}
			}
			
			st.executeUpdate(updateUserCourseString);
			
			allCourses.put(c.getCourseName(), c);
			Vector<User> usersInCourse = c.getStudents();
			usersInCourse.add(c.getInstructor());
			
			for (User u : usersInCourse) {
				if (!u.getCourses().contains(c)) {
					u.addCourse(c);
				}
				if (!allUsers.get(u.getUsername()).getCourses().contains(c)) {
					allUsers.get(u.getUsername()).addCourse(c);
				}
			}
			
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public void addNote(Note n, Course c) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			String updateNoteString = "INSERT INTO Note (title, content, postedDate, courseID, userID) VALUES (";
			updateNoteString += "'" + n.getTitle() + "', '" + n.getTextContent() + "', '" + df.format(n.getDateCreated()) + "', "; 
			
			// Get the courseID of the course by first getting the id of the instructor
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + c.getInstructor().getUsername() + "'");
			int instructorID = -1;
			while (rs.next()) {
				instructorID = rs.getInt("userID");
			}
			rs = st.executeQuery("SELECT * FROM Course WHERE courseName='" + c.getCourseName() + "' AND instructorID=" + instructorID);
			int courseID = -1;
			while (rs.next()) {
				courseID = rs.getInt("courseID");
			}
			updateNoteString += courseID + ", ";
			
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + n.getUser().getUsername() + "'");
			int userID = -1;
			while (rs.next()) {
				userID = rs.getInt("userID");
			}
			updateNoteString += userID + ")";
			
			st.executeUpdate(updateNoteString);
			
			// Get the noteID of the newly added note
			rs = st.executeQuery("SELECT * FROM Note WHERE title='" + n.getTitle() + "' AND content='" + n.getTextContent() + "' AND postedDate='" + df.format(n.getDateCreated()) + "' AND courseID=" + courseID + " AND userID=" + userID);
			int noteID = -1;
			while (rs.next()) {
				noteID = rs.getInt("noteID");
			}
			
			Vector<String> tagsToAdd = n.getTags();
			String updateTagString = "INSERT INTO Tag (tag, noteID) VALUES ";
			Boolean first = true;
			
			for (String t : tagsToAdd) {
				
				if (!first) { updateTagString += ", "; }
				updateTagString += "('" + t + "', " + noteID + ")";
				first = false;
			}
			
			st.executeUpdate(updateTagString);
			
			allCourses.get(c.getCourseName()).addNote(n);
			
			
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public void addPresentation(Presentation p, Course c) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			// Get the courseID of the course by first getting the id of the instructor
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + c.getInstructor().getUsername() + "'");
			int instructorID = -1;
			while (rs.next()) {
				instructorID = rs.getInt("userID");
			}
			rs = st.executeQuery("SELECT * FROM Course WHERE courseName='" + c.getCourseName() + "' AND instructorID=" + instructorID);
			int courseID = -1;
			while (rs.next()) {
				courseID = rs.getInt("courseID");
			}
			
			// Delete old links from PresentationLink table
			st.executeUpdate("DELETE FROM PresentationLink WHERE courseID=" + courseID);
			
			// Add new links to PresentationLink
			Vector<String> linksToAdd = p.getLinks();
			String updatePresentationLinkString = "INSERT INTO PresentationLink (link, courseID) VALUES ";
			Boolean first = true;
			
			for (String l : linksToAdd) {
				
					if (!first) { updatePresentationLinkString += ", "; }
					updatePresentationLinkString += "('" + l + "', " + courseID + ")";
					first = false;
			}
			
			st.executeUpdate(updatePresentationLinkString);
			
			// Get questionIDs to be deleted, delete choices first then delete all questionIDs corresponding to given course
			String deleteQuestionChoiceString = "DELETE FROM QuestionChoice WHERE ";
			
			// Iterate over questions associated with courseID and add their ID to deletion statement for QuestionChoice table
			rs = st.executeQuery("SELECT * FROM PresentationQuestion WHERE courseID=" + courseID);
			Boolean first1 = true;
			while (rs.next()) {
				int questionID = rs.getInt("questionID");
				
				if (!first1) { deleteQuestionChoiceString += " OR "; }
				deleteQuestionChoiceString += "questionID=" + questionID;
				first1 = false;
			}
			
			// Delete all the choices associated with questions in this course then delete all questions associated with course
			st.executeUpdate(deleteQuestionChoiceString);
			st.executeUpdate("DELETE FROM PresentationQuestion WHERE courseID=" + courseID);
			
			Vector<Quiz> quizzes = p.getQuizzes();
			for (Quiz q : quizzes) {
				
				String updatePresentationQuestionString = "INSERT INTO PresentationQuestion (content, courseID) VALUES ('" + q.getQuestion() + "', " + courseID + ")";
				st.executeUpdate(updatePresentationQuestionString);
				
				// Get questionID of the question just added
				rs = st.executeQuery("SELECT * FROM PresentationQuestion WHERE content='" + q.getQuestion() + "' AND courseID=" + courseID);
				int questionID = -1;
				while (rs.next()) {
					questionID = rs.getInt("questionID");
				}
				
				Vector<String> choices = q.getChoices();
				Set<Integer> correctIndices = q.getAnswers();
				String updateQuestionChoiceString = "INSERT INTO QuestionChoice (content, correctBool, questionID) VALUES ";
				Boolean first2 = true;
				
				for (String ch : choices) {
					
					if (!first2) { updateQuestionChoiceString += ", "; }
					updateQuestionChoiceString += "('" + ch + "', '";
					updateQuestionChoiceString += Boolean.toString(correctIndices.contains(choices.indexOf(ch)));
					updateQuestionChoiceString += "', " + questionID + ")";
					first2 = false;

				}
				
				st.executeUpdate(updateQuestionChoiceString);
				
				allCourses.get(c.getCourseName()).setCurrentLecture(p);
				
			}
			
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public void addNoteVote(Note n, User u, Boolean isLike) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			// Get the userID of the course by first getting the id of the instructor
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + u.getUsername() + "'");
			int userID = -1;
			while (rs.next()) {
				userID = rs.getInt("userID");
			}
			
			// Get the noteID and courseID of the note
			rs = st.executeQuery("SELECT * FROM Note WHERE title='" + n.getTitle() + "' AND content='" + n.getTextContent() + "' AND postedDate='" + df.format(n.getDateCreated()) + "'");
			int noteID = -1;
			int courseID = -1;
			while (rs.next()) {
				noteID = rs.getInt("noteID");
				courseID = rs.getInt("courseID");
			}
			
			rs = st.executeQuery("SELECT * From NoteVote WHERE userID=" + userID + " AND noteID=" + noteID);
			Boolean exists = false;
			while (rs.next()) {
				exists = true;
			}
			
			// If the user has already voted on the post, update their vote
			if (exists) {
				st.executeUpdate("UPDATE NoteVote SET likeBool='" + Boolean.toString(isLike) + "' WHERE userID=" + userID + " AND noteID=" + noteID);
			}
			
			// If they haven't already voted on the post, add a row with their vote
			else {
				st.executeUpdate("INSERT INTO NoteVote (likeBool, userID, noteID) VALUES ('" + Boolean.toString(isLike) + "', " + userID + ", " + noteID + ")");
			}
			
			// Get the course name of the note associated with the vote we are adding
			rs = st.executeQuery("SELECT * FROM Course WHERE courseID=" + courseID);
			String courseName = "";
			while (rs.next()) {
				courseName = rs.getString("courseName");
			}
			
			for (Note no : allCourses.get(courseName).getAllNotes()) {
				if (no.equals(n)) {
					if (isLike) { no.addLike(u); }
					else { no.addDislike(u); }
				}
			}
		
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public void addCommentVote(Comment c, User u, Boolean isLike) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connect to RDS database!
			conn = DriverManager.getConnection("jdbc:mysql://notezzadb.cieln92o8pbt.us-east-2.rds.amazonaws.com:3306/Notezza?user=notezza&password=professormiller&useSSL=false");
			st = conn.createStatement();
			
			// Get the userID of the course by first getting the id of the instructor
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + u.getUsername() + "'");
			int userID = -1;
			while (rs.next()) {
				userID = rs.getInt("userID");
			}
			
			// Get the commentID of the comment by first getting the noteID of the note it is posted on and the userID of the user who posted it
			rs = st.executeQuery("SELECT * FROM Note WHERE title='" + c.getNote().getTitle() + "' AND content='" + c.getNote().getTextContent() + "' AND postedDate='" + df.format(c.getNote().getDateCreated()) + "'");
			int noteID = -1;
			int courseID = -1;
			while (rs.next()) {
				noteID = rs.getInt("noteID");
				courseID = rs.getInt("courseID");
			}
			rs = st.executeQuery("SELECT * FROM UserTable WHERE username='" + c.getUser().getUsername() + "'");
			int posterID = -1;
			while (rs.next()) {
				posterID = rs.getInt("userID");
			}
			rs = st.executeQuery("SELECT * FROM NoteComment WHERE content='" + c.getContent() + "' AND postedDate='" + df.format(c.getDateCreated()) + "' AND noteID=" + noteID + " AND userID=" + posterID);
			int commentID = -1;
			while (rs.next()) {
				commentID = rs.getInt("commentID");
			}
			
			rs = st.executeQuery("SELECT * From CommentVote WHERE userID=" + userID + " AND commentID=" + commentID);
			Boolean exists = false;
			while (rs.next()) {
				exists = true;
			}
			
			// If the user has already voted on the comment, update their vote
			if (exists) {
				st.executeUpdate("UPDATE CommentVote SET likeBool='" + Boolean.toString(isLike) + "' WHERE userID=" + userID + " AND commentID=" + commentID);
			}
			
			// If they haven't already voted on the comment, add a row with their vote
			else {
				st.executeUpdate("INSERT INTO CommentVote (likeBool, userID, commentID) VALUES ('" + Boolean.toString(isLike) + "', " + userID + ", " + commentID + ")");
			}
			
			// Get the course name of the note the comment is attached to
			rs = st.executeQuery("SELECT * FROM Course WHERE courseID=" + courseID);
			String courseName = "";
			while (rs.next()) {
				courseName = rs.getString("courseName");
			}
			
			// Loop through all the notes to find the right comment, then add like or dislike to that comment
			for (Note no : allCourses.get(courseName).getAllNotes()) {
				for (Comment co : no.getComments()) {
					if (co.equals(c)) {
						if (isLike) { co.addLike(u); }
						else { co.addDislike(u); }
					}
				}
			}
		
			
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			// Close in opposite order as opened
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	
	public Vector<Course> findUserCourses(String name){
        Vector<Course> courses= new Vector<>();
        for(Course course : allCourses.values()) {
            if(course.containStudent(name)){
                courses.add(course);
            }
        }
        return courses;
    }
	
	public List<Course> findInstructorCourses(String name) {
        List<Course> courses= new ArrayList<>();
        for(Course course : allCourses.values()) {
            if(course.getInstructor().getUsername().equals(name)){
                courses.add(course);
            }
        }
        return courses;
    }
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Course course : allCourses.values()) {
            sb.append(course.getCourseName()).append("\n");
        }
        for(User user : allUsers.values()) {
            sb.append(user.getUsername()).append("\n");
        }
        return sb.toString();
    }
	
	public static void main(String [] args) {
		DatabaseManager dm = new DatabaseManager();
		
	}
}
