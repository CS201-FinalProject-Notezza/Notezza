package GUI;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.Course;
import objects.CourseANDNote;
import objects.Note;
import objects.User;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class AddNote extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField tagsField;
	private JTextArea descriptionText;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private NotezzaClient client;
    private Course course;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNote frame = new AddNote(null,null);
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
	public AddNote(NotezzaClient client, Course course) {
		this.client = client;
		this.course = course;

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
		
		
		setTitle("New Note");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleField = new JTextField();
		titleField.setBounds(153, 45, 270, 26);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(107, 50, 61, 16);
		contentPane.add(lblTitle);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setBounds(107, 83, 61, 16);
		contentPane.add(lblTags);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(107, 119, 94, 16);
		contentPane.add(lblDescription);
		
		descriptionText = new JTextArea();
		descriptionText.setBounds(107, 147, 425, 173);
		contentPane.add(descriptionText);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setAction(action_1);
		btnSubmit.setBounds(21, 340, 94, 26);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action);
		btnCancel.setBounds(117, 339, 117, 29);
		contentPane.add(btnCancel);
		
		tagsField = new JTextField();
		tagsField.setBounds(153, 83, 270, 26);
		contentPane.add(tagsField);
		tagsField.setColumns(10);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
	private class SwingAction_1 extends AbstractAction { //The action here first checks if the fields are blank, and if they are, then we will open an error dialoge to alert user that fields cannot be blank
		public SwingAction_1() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(descriptionText.getText().equals("")
					|| titleField.getText().equals("") 
					|| tagsField.getText().equals("")) 
				{
					//open a dialogue to warn the user
					JOptionPane.showMessageDialog(contentPane, "ERROR: One of more of these fields cannot be empty!", "ERROR",  JOptionPane.ERROR_MESSAGE);
				} else {
			    // Add the note
                //Note(User user, String title, Vector<String> tags, Date date, String textContent)
                User user = client.getUser();
                String title = titleField.getText();
                String tagsString = tagsField.getText();
                String[] tagsArray = tagsString.split(",");
                String textContent = descriptionText.getText();

                Vector<String> tags = new Vector<>(Arrays.asList(tagsArray));

                DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
                Date d = new Date();
                df.format(d);

                Note note = new Note(user,title,tags,d,textContent);
                CourseANDNote cn = new CourseANDNote(course,note);
                client.sendCommand(new Command(CommandType.ADD_NOTE,cn));
            }
		}
	}
}
