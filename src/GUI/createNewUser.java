package GUI;

import objects.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPasswordField;

public class createNewUser extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnInstructor;
	private JTextField UserNameField;
	private JTextField FirstNameField;
	private JTextField LastNameField;
	private JTextField EmailField;
	private JCheckBox chckbxVisible;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action Register = new SwingAction_2();
	private JLabel lblPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createNewUser frame = new createNewUser();
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
	public createNewUser() {
		
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
		
		
		setBounds(100, 100, 575, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setSelected(true);
		rdbtnStudent.setAction(action_1);
		buttonGroup.add(rdbtnStudent);
		rdbtnStudent.setBounds(55, 25, 90, 23);
		contentPane.add(rdbtnStudent);
		
		rdbtnInstructor = new JRadioButton("Instructor");
		rdbtnInstructor.setAction(action);
		buttonGroup.add(rdbtnInstructor);
		rdbtnInstructor.setBounds(235, 25, 99, 23);
		contentPane.add(rdbtnInstructor);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(112, 65, 80, 16);
		contentPane.add(lblNewLabel);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(204, 60, 130, 26);
		contentPane.add(UserNameField);
		UserNameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(111, 98, 81, 16);
		contentPane.add(lblNewLabel_1);
		
		FirstNameField = new JTextField();
		FirstNameField.setBounds(204, 93, 130, 26);
		contentPane.add(FirstNameField);
		FirstNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(112, 136, 66, 16);
		contentPane.add(lblLastName);
		
		LastNameField = new JTextField();
		LastNameField.setBounds(204, 131, 130, 26);
		contentPane.add(LastNameField);
		LastNameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(112, 171, 61, 16);
		contentPane.add(lblEmail);
		
		EmailField = new JTextField();
		EmailField.setBounds(204, 169, 130, 26);
		contentPane.add(EmailField);
		EmailField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setAction(Register);
		btnRegister.setBounds(150, 281, 117, 29);
		contentPane.add(btnRegister);
		
		chckbxVisible = new JCheckBox("Visible");
		chckbxVisible.setBounds(139, 246, 128, 23);
		contentPane.add(chckbxVisible);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(112, 211, 80, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 208, 130, 26);
		contentPane.add(passwordField);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Instructor");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			chckbxVisible.setEnabled(false);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Student");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			chckbxVisible.setEnabled(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (UserNameField.getText().equals("")
				|| FirstNameField.getText().equals("") 
				|| LastNameField.getText().equals("")
				|| EmailField.getText().equals("")
				|| passwordField.getText().length()==0) 
			{
				JOptionPane.showMessageDialog(contentPane, "ERROR: One or more of these fields are empty!", "ERROR",  JOptionPane.ERROR_MESSAGE);
			
			
				//have an error message pop out
			} else {
				// A new User got created
				String fname = FirstNameField.getText();
				String lname = LastNameField.getText();
				String userName = UserNameField.getText();
				String email = EmailField.getText();
				User user;
				if (rdbtnStudent.isSelected()) { //first, check to see if the User wishes to be a student
					//user = new User(fname,lname,);
					//User(String fname, String lname, String username, String email, long password, boolean isInstructor, boolean isVisible)
					if(chckbxVisible.isSelected()) //if the user wants to be visible
					{
						user = new User(fname, lname, userName, email, /*hashed password goes here */ , false, true);
					}
					
					else
					{
						user = new User(fname, lname, userName, email, /*hashed password goes here */ , false, false);
					}
				}
				else //if the user wants to be an instructor
				{
					user = new User(fname, lname, userName, email, /*hashed password goes here */, true, true);
				}

			}
		}
	}
}
