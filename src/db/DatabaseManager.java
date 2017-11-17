import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import objects.Comment;
import objects.Course;
import objects.DataContainer;
import objects.Note;
import objects.Presentation;
import objects.Quiz;
import objects.User;

public class DatabaseManager {
	
	private DataContainer dc;
	private DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
	
	public DatabaseManager() {
		dc = new DataContainer();
		initializeObjectTree();
	}
	
	public DataContainer getDataContainer() {
		return dc;
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
					courseIDToNoteObjects.put(noteID, newNoteVector);
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
			
			HashMap<String, User> usernameToUserObject = new HashMap<String, User>();
			HashMap<String, Course> courseNameToCourseObject = new HashMap<String, Course>();
			
			for (User u : userObjects) {
				usernameToUserObject.put(u.getUsername(), u);
			}
			for (Course c : courseObjects) {
				courseNameToCourseObject.put(c.getCourseName(), c);
			}
			
			dc.setAllUsers(usernameToUserObject);
			dc.setAllCourses(courseNameToCourseObject);
			
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
	
	public static void main(String [] args) {
		DatabaseManager dm = new DatabaseManager();
		
	}
}
