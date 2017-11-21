package GUI;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.UserCredential;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class CreateNewUser extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnInstructor;
	private JTextField usernameField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JCheckBox privateCheck;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action Register = new SwingAction_2();
	private JLabel passwordLabel;
	private JPasswordField passwordField;

	private NotezzaClient client;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewUser frame = new CreateNewUser(null);
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
	public CreateNewUser(NotezzaClient client) {
		setResizable(false);
		setTitle("Register");
		this.client = client;
		
		
		setBounds(100, 100, 320, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(52, 61, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnStudent.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnStudent.setForeground(new java.awt.Color(204, 204, 204));
		rdbtnStudent.setSelected(true);
		rdbtnStudent.setAction(action_1);
		buttonGroup.add(rdbtnStudent);
		rdbtnStudent.setBounds(175, 169, 99, 23);
		contentPane.add(rdbtnStudent);
		
		rdbtnInstructor = new JRadioButton("Instructor");
		rdbtnInstructor.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnInstructor.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnInstructor.setForeground(new java.awt.Color(204, 204, 204));
		rdbtnInstructor.setAction(action);
		buttonGroup.add(rdbtnInstructor);
		rdbtnInstructor.setBounds(175, 192, 120, 23);
		contentPane.add(rdbtnInstructor);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(20, 20, 99, 16);
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		usernameLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(usernameLabel);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(20, 74, 99, 16);
		firstNameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		firstNameLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(20, 101, 99, 16);
		lastNameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lastNameLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(lastNameLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(20, 128, 80, 16);
		emailLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		emailLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(emailLabel);
		
		JButton registerButton = new JButton("Register");
		registerButton.setAction(Register);
		registerButton.setBounds(101, 236, 117, 34);
		registerButton.setFont(new Font("Dialog", Font.BOLD, 15));
		registerButton.setForeground(new java.awt.Color(52, 61, 70));
		contentPane.add(registerButton);
		
		privateCheck = new JCheckBox("Private");
		privateCheck.setBounds(45, 182, 128, 23);
		privateCheck.setFont(new Font("Dialog", Font.BOLD, 15));
		privateCheck.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(privateCheck);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(20, 47, 80, 16);
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		passwordLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(passwordLabel);
		
		separator = new JSeparator();
		separator.setBounds(116, 32, 184, 16);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(116, 59, 184, 16);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(116, 86, 184, 16);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(116, 113, 184, 16);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(116, 140, 184, 16);
		contentPane.add(separator_4);
		
		usernameField = new JTextField();
		usernameField.setBounds(116, 15, 184, 26);
		usernameField.setBackground(new java.awt.Color(52, 61, 70));
		usernameField.setForeground(new java.awt.Color(204, 204, 204));
		usernameField.setBorder(null);
		usernameField.setCaretColor(new java.awt.Color(204, 204, 204));
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 42, 184, 26);
		passwordField.setBackground(new java.awt.Color(52, 61, 70));
		passwordField.setForeground(new java.awt.Color(204, 204, 204));
		passwordField.setBorder(null);
		passwordField.setCaretColor(new java.awt.Color(204, 204, 204));
		contentPane.add(passwordField);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(116, 69, 184, 26);
		firstNameField.setBackground(new java.awt.Color(52, 61, 70));
		firstNameField.setForeground(new java.awt.Color(204, 204, 204));
		firstNameField.setBorder(null);
		firstNameField.setCaretColor(new java.awt.Color(204, 204, 204));
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(116, 96, 184, 26);
		lastNameField.setBackground(new java.awt.Color(52, 61, 70));
		lastNameField.setForeground(new java.awt.Color(204, 204, 204));
		lastNameField.setBorder(null);
		lastNameField.setCaretColor(new java.awt.Color(204, 204, 204));
		contentPane.add(lastNameField);
		lastNameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(116, 123, 184, 26);
		emailField.setBackground(new java.awt.Color(52, 61, 70));
		emailField.setForeground(new java.awt.Color(204, 204, 204));
		emailField.setBorder(null);
		emailField.setCaretColor(new java.awt.Color(204, 204, 204));
		contentPane.add(emailField);
		emailField.setColumns(10);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Instructor");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			privateCheck.setSelected(false);
			privateCheck.setEnabled(false);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Student");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			privateCheck.setEnabled(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (usernameField.getText().equals("")
				|| firstNameField.getText().equals("") 
				|| lastNameField.getText().equals("")
				|| emailField.getText().equals("")
				|| passwordField.getPassword().length == 0)
			{
				JOptionPane.showMessageDialog(contentPane, "ERROR: One or more of these fields are empty!", "ERROR",  JOptionPane.ERROR_MESSAGE);
				//have an error message pop out
			} else {
				// A new User got created
				String fname = firstNameField.getText();
				String lname = lastNameField.getText();
				String userName = usernameField.getText();
				String email = emailField.getText();
				String passWord = String.copyValueOf(passwordField.getPassword());

				UserCredential user;
				if (rdbtnStudent.isSelected()) { //first, check to see if the User wishes to be a student
					//User(String fname, String lname, String username, String email, long password, boolean isInstructor, boolean isVisible)
					user = new UserCredential(fname, lname, userName, email, passWord , false, privateCheck.isSelected());
				}
				else //if the user wants to be an instructor
				{
					user = new UserCredential(fname, lname, userName, email, passWord, true, true);
				}

				setVisible(false);
				client.sendCommand(new Command(CommandType.REGISTER,user));
			}
		}
	}
}
