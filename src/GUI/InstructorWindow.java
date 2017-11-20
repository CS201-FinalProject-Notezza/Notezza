package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.DefaultComboBoxModel;


public class InstructorWindow extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField commentText;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	
	private JComboBox<String> allClasses;
	private List noteList;
	private List commentList;
	private final Action action_5 = new SwingAction_5();
	
	private JTextField searchField;
	private final Action action_6 = new SwingAction_6();

	private CourseList courseList;
	private NotezzaClient client;
	private Course currentCourse;
	private Note currentNote;
	private TextArea noteArea;


	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorWindow frame = new InstructorWindow(null,null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public InstructorWindow(NotezzaClient client, CourseList courseList, Set<User> userSet) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		
		this.client = client;
		this.courseList = courseList;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUserProfile = new JButton("User Profile");
		btnUserProfile.setAction(action);
		btnUserProfile.setBounds(877, 6, 117, 29);
		contentPane.add(btnUserProfile);
		
		/*Button button = new Button("Add Note");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(772, 627, 117, 29);
		contentPane.add(button);*/
		noteList = new List();
		noteList.setBounds(46, 156, 290, 500);
		
		//first, get all Notes for the current Class. before you do, make sure courseList is not null
		if(courseList!=null)
		{
			currentCourse = courseList.getCourses().get(0);
			
			Vector<Note> allNotes = currentCourse.getAllNotes();
			
			//update the list
			
			for(int i = 0; i<allNotes.size(); i++)
			{
				noteList.add(allNotes.get(i).getTitle());
			}
			
		}
		
		//noteList.add(String)
		contentPane.add(noteList);

		searchField = new JTextField();
		searchField.setBounds(34, 61, 130, 26);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		commentText = new JTextField();
		commentText.setBounds(437, 617, 361, 26);
		contentPane.add(commentText);
		commentText.setColumns(10);
		
		
		if(courseList!=null)
		{
			java.util.List<Course> allCourses = courseList.getCourses();
			
			java.util.List<String> allCourseNames = (java.util.List<String>) new List();
			
			for(int i = 0; i<allCourses.size(); i++)
			{
				allCourseNames.add(allCourses.get(i).getCourseName());
			}
			
			if(allCourses.size()!=0)
			{
				allClasses = new JComboBox<String>(new DefaultComboBoxModel(allCourseNames.toArray())); //for the Classes
			}
		}
		
		
		else
		{
			allClasses = new JComboBox<String>(); //for the Classes
		}
		
		allClasses.setBounds(24, 7, 141, 27);
		contentPane.add(allClasses);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setAction(action_6);
		btnSearch.setBounds(177, 61, 117, 29);
		contentPane.add(btnSearch);
		
		JButton btnNewClass = new JButton("New Class");
		btnNewClass.setAction(action_4);
		btnNewClass.setBounds(177, 6, 117, 29);
		contentPane.add(btnNewClass);
		
		//String[] sortOptions = {"Date Uploaded", "Number of Comments", "Number of Likes", "Number of Ratings"};
		JComboBox<String> sortComboBox = new JComboBox<String>(); //this is for the search options for the List
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Date Uploaded", "Most Likes", "Highest Rating", "Number of Comments"}));
		sortComboBox.setBounds(34, 91, 212, 27);
		contentPane.add(sortComboBox);
		
		JButton btnAddNote = new JButton("Add Note");
		btnAddNote.setBounds(47, 123, 117, 29);
		contentPane.add(btnAddNote);
		
		JButton btnAddPresentation = new JButton("View Presentation");
		btnAddPresentation.setAction(action_1);
		btnAddPresentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddPresentation.setBounds(377, 6, 158, 29);
		contentPane.add(btnAddPresentation);
		
		JButton btnViewMembers = new JButton("View Members");
		btnViewMembers.setAction(action_3);
		btnViewMembers.setBounds(618, 6, 117, 29);
		contentPane.add(btnViewMembers);
		
		//might need a button to list all the classes
		
		//and for the window that lists classes and students taking that class, open a new window when adding new classes/students into class, with the classWindow pointing into that new window or something similar
		//and when submitted, a function is called to update the listing
		
		commentList = new List();
		
		if(courseList!=null)
		{
			currentNote = courseList.getCourses().get(0).getAllNotes().get(0);
			
			for(int i = 0; i<currentNote.getComments().size(); i++)
			{
				commentList.add(currentNote.getComments().get(i).getUser().getUsername() + ": " + currentNote.getComments().get(i).getContent());
			}
		}
		commentList.setBounds(389, 407, 579, 188);
		
		
		contentPane.add(commentList);
		
		noteArea = new TextArea();
		noteArea.setEditable(false);
		if(courseList!=null)
		{
			currentCourse = courseList.getCourses().get(0);
			currentNote = currentCourse.getAllNotes().get(0);
			
			noteArea.setText(currentNote.getTextContent());

		}
		noteArea.setBounds(369, 123, 625, 231);
		contentPane.add(noteArea);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(437, 617, 361, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnComment = new JButton("Comment");
		btnComment.setAction(action_5);
		btnComment.setBounds(824, 617, 117, 29);
		contentPane.add(btnComment);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "User Profile");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		    User user = client.getUser();
			InstructorProfile profile = new InstructorProfile(user);
			profile.setVisible(true);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "View Presentation");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			InstructorPresentation presentation = new InstructorPresentation(client, currentCourse);
			presentation.setVisible(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Add Comment");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) { //this is for adding comments
			//AddComment addComment = new AddComment();
			//addComment.setVisible(true);
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "View Members");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ViewStudentsInClass viewMembers = new ViewStudentsInClass(client.getUser(), currentCourse.getStudents(), currentCourse.getInstructor());
			viewMembers.setVisible(true);
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "New Class");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			NewCourse newClass = new NewCourse(client);
			newClass.setVisible(true);
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Comment");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(commentText.getText().equals("")) {
				//open a dialogue to warn the user
				JOptionPane.showMessageDialog(contentPane, "ERROR: Please enter a comment!", "ERROR",  JOptionPane.ERROR_MESSAGE);
			
			} else {
                // LINK
                String commentContent = commentText.getText();
                DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
                Date d = new Date();
                df.format(d);
                User user = client.getUser();
                Comment comment = new Comment(user,commentContent,d,currentNote);
                client.sendCommand(new Command(CommandType.ADD_COMMENT,comment));
            }
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(searchField.getText().equals("")) 
			{
				//open a dialogue to warn the user
				JOptionPane.showMessageDialog(contentPane, "ERROR: Search Field Cannot be Empty!", "ERROR",  JOptionPane.ERROR_MESSAGE);
			
			}
		}
	}
}
