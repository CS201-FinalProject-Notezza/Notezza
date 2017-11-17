package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;

import java.awt.TextField;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.List;
import javax.swing.JComboBox;

public class GuestWindow extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField textField;

	private List noteList; 
	private List commentList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestWindow frame = new GuestWindow();
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
	public GuestWindow() {
		
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
		
		
		setTitle("Guest Notezza");
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
		
		textField = new JTextField();
		textField.setBounds(34, 61, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> allClasses = new JComboBox<String>(); //for the Classes
		allClasses.setEnabled(false);
		allClasses.setBounds(24, 7, 141, 27);
		contentPane.add(allClasses);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(177, 61, 117, 29);
		contentPane.add(btnSearch);
		
		//String[] sortOptions = {"Date Uploaded", "Number of Comments", "Number of Likes", "Number of Ratings"};
		JComboBox<String> sortComboBox = new JComboBox<String>(); //this is for the search options for the List
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Date Uploaded", "Most Likes", "Highest Rating", "Number of Comments"}));
		sortComboBox.setBounds(34, 91, 212, 27);
		contentPane.add(sortComboBox);
		
		JButton btnAddNote = new JButton("Add Note");
		btnAddNote.setEnabled(false);
		btnAddNote.setBounds(47, 123, 117, 29);
		contentPane.add(btnAddNote);
		
		JButton btnViewMembers = new JButton("View Members");
		btnViewMembers.setEnabled(false);
		btnViewMembers.setBounds(618, 6, 117, 29);
		contentPane.add(btnViewMembers);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(369, 123, 625, 231);
		contentPane.add(textArea);
		
	    commentList = new List();
		commentList.setBounds(389, 407, 579, 188);
		contentPane.add(commentList);
		
		JButton btnAddPresentation = new JButton("View Presentation");
		btnAddPresentation.setEnabled(false);
		/*btnAddPresentation.setAction(action_1);
		btnAddPresentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});*/
		btnAddPresentation.setBounds(377, 6, 158, 29);
		contentPane.add(btnAddPresentation);
		
		JTextField textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(437, 617, 361, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnComment = new JButton("Comment");
		btnComment.setEnabled(false);
		btnComment.setBounds(824, 617, 117, 29);
		contentPane.add(btnComment);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "User Profile");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			GuestProfile profile = new GuestProfile();
			profile.setVisible(true);
		}
	}
}
