package GUI;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import javafx.util.Pair;
import objects.Course;
import objects.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.Vector;
import javax.swing.Action;

import static NotezzaServer.CommandType.CREATE_CLASS;

public class NewClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private final Action action = new SwingAction();
	private final Action addClass = new AddClass();

	private Set<User> userSet;
	private NotezzaClient client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewClass frame = new NewClass(null,null);
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
	public NewClass(NotezzaClient client, Set<User> userSet) {
		
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
		
		this.userSet = userSet;
		this.client = client;
		setTitle("New Class");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassName = new JLabel("Class Name");
		lblClassName.setBounds(47, 27, 94, 16);
		contentPane.add(lblClassName);
		
		textField = new JTextField();
		textField.setBounds(173, 22, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmailsOfStudents = new JLabel("Emails of Students (Separated By Commas)");
		lblEmailsOfStudents.setBounds(57, 65, 295, 16);
		contentPane.add(lblEmailsOfStudents);
		
		textPane = new JTextPane();
		textPane.setBounds(61, 93, 295, 122);
		contentPane.add(textPane);
		
		JButton btnOk = new JButton("OK");
		btnOk.setAction(addClass);
		btnOk.setBounds(47, 230, 117, 29);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action);
		btnCancel.setBounds(207, 230, 117, 29);
		contentPane.add(btnCancel);
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
	private class AddClass extends AbstractAction {
		public AddClass() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String courseName = textField.getText();
			String studentEmailStrings = textPane.getText();
			String[] studentEmailArrays = studentEmailStrings.split(",");
			Vector<User> studentVector = new Vector<>();
			for (String email : studentEmailArrays) {
				for (User user : userSet) {
					if (user.getEmail().equals(email)) {
						studentVector.add(user);
					}
				}
			}

			User instructor = client.getUser();
			Course course = new Course(courseName,instructor,studentVector);
			client.sendCommand(new Command(CREATE_CLASS,course));
		}

	}

}
