package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.*;

public class UserWindow extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField searchField;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private JTextField commentText;
	private List noteList;
	private List commentList;
	
	private JComboBox<String> allClasses;
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();

	private NotezzaClient client;
	// Need to populate later
	private CourseList courseList;
	private Course currentCourse;
	private Note currentNote;


	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow frame = new UserWindow(null,null);
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
	public UserWindow(NotezzaClient client, CourseList courseList) {
		
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
		
		
		setTitle("Notezza");
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
		contentPane.add(noteList);
		
		searchField = new JTextField();
		searchField.setBounds(34, 61, 130, 26);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		allClasses = new JComboBox<String>(); //for the Classes
		allClasses.setBounds(24, 7, 141, 27);
		contentPane.add(allClasses);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setAction(action_6);
		btnSearch.setBounds(177, 61, 117, 29);
		contentPane.add(btnSearch);
		
		//String[] sortOptions = {"Date Uploaded", "Number of Comments", "Number of Likes", "Number of Ratings"};
		JComboBox<String> sortComboBox = new JComboBox<String>(); //this is for the search options for the List
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Date Uploaded", "Most Likes", "Highest Rating", "Number of Comments"}));
		sortComboBox.setBounds(34, 91, 212, 27);
		contentPane.add(sortComboBox);
		
		JButton btnAddNote = new JButton("Add Note");
		btnAddNote.setAction(action_2);
		btnAddNote.setBounds(47, 123, 117, 29);
		contentPane.add(btnAddNote);
		
		JButton btnViewMembers = new JButton("View Members");
		btnViewMembers.setAction(action_4);
		btnViewMembers.setBounds(618, 6, 117, 29);
		contentPane.add(btnViewMembers);
		
		
		JButton btnAddPresentation = new JButton("View Presentation");
		btnAddPresentation.setAction(action_1);
		btnAddPresentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddPresentation.setBounds(377, 6, 158, 29);
		contentPane.add(btnAddPresentation);
		
		commentList = new List();
		commentList.setBounds(389, 407, 579, 188);
		contentPane.add(commentList);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(369, 123, 625, 231);
		contentPane.add(textArea);
		
		commentText = new JTextField();
		commentText.setBounds(437, 617, 361, 26);
		contentPane.add(commentText);
		commentText.setColumns(10);
		
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
			
		
			UserProfile profile = new UserProfile();
			profile.setVisible(true);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "View Presentation");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			UserPresentation presentation = new UserPresentation();
			presentation.setVisible(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Add Note");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			//open up the AddNote Window
			AddNote newNote = new AddNote(client); //want to pass in a constructor of the user window to update the list of posts
			newNote.setVisible(true);

		}
	}
	private class SwingAction_3 extends AbstractAction { //This function is for adding comments
		public SwingAction_3() {
			putValue(NAME, "Add Comment");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			AddComment addComment = new AddComment();
			addComment.setVisible(true);


		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "View Members");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ViewStudentsInClass viewMembers = new ViewStudentsInClass();
			viewMembers.setVisible(true);
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Comment");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(commentText.getText().equals("")) 
			{
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
