package GUI;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.Course;
import objects.CourseANDNote;
import objects.Note;
import objects.User;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AddNote extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextField tagsField;
	private JTextPane descriptionText;
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
		setResizable(false);
		this.client = client;
		this.course = course;
		
		setTitle("New Note");
		setBounds(100, 100, 500, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(52, 61, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setBounds(21, 22, 65, 16);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		titleLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(titleLabel);
		
		JLabel tagsLabel = new JLabel("Tags:");
		tagsLabel.setBounds(21, 47, 49, 21);
		tagsLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		tagsLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(tagsLabel);
		
		JLabel noteLabel = new JLabel("Note Content:");
		noteLabel.setBounds(21, 78, 139, 16);
		noteLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		noteLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(noteLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 106, 458, 233);
		contentPane.add(scrollPane);
		
		descriptionText = new JTextPane();
		scrollPane.setViewportView(descriptionText);
		descriptionText.setBackground(new java.awt.Color(204, 204, 204));
		descriptionText.setForeground(new java.awt.Color(52, 61, 70));
		descriptionText.setBorder(null);
		descriptionText.setCaretColor(new java.awt.Color(52, 61, 70));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSubmit.setAction(action_1);
		btnSubmit.setBounds(170, 354, 160, 34);
		btnSubmit.setForeground(new java.awt.Color(52, 61, 70));
		contentPane.add(btnSubmit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(68, 34, 411, 16);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(68, 62, 411, 16);
		contentPane.add(separator_1);
		
		titleField = new JTextField();
		titleField.setBounds(68, 17, 411, 26);
		titleField.setBackground(new java.awt.Color(52, 61, 70));
		titleField.setForeground(new java.awt.Color(204, 204, 204));
		titleField.setBorder(null);
		titleField.setCaretColor(new java.awt.Color(204, 204, 204));
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		tagsField = new JTextField();
		tagsField.setBounds(68, 45, 411, 26);
		tagsField.setBackground(new java.awt.Color(52, 61, 70));
		tagsField.setForeground(new java.awt.Color(204, 204, 204));
		tagsField.setBorder(null);
		tagsField.setCaretColor(new java.awt.Color(204, 204, 204));
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
