package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.Frame;
import javax.swing.JPanel;

public class LoginScreen {

	private JFrame frame;
	private JFrame frame2;
	private JTextField textField;
	private JLabel lblPassword;
	private JButton btnLogIn;
	private JButton btnCreateAccount;
	private JButton btnGuest;
	
	private JFrame createAccountFrame;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 * we might want to have a constructor that accepts the database of the program when moving to the user windows
	 * from those windows, we might want to pass in the user object and print out each components
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 458, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNotezza = new JLabel("Notezza", SwingConstants.CENTER);
		lblNotezza.setBackground(new Color(255, 51, 0));
		lblNotezza.setBounds(126, 27, 201, 60);
		frame.getContentPane().add(lblNotezza);
		
		textField = new JTextField();
		textField.setBounds(126, 99, 150, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 104, 86, 16);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 144, 73, 16);
		frame.getContentPane().add(lblPassword);
		
		btnLogIn = new JButton("Log In");
		
		btnLogIn.setAction(action);
		btnLogIn.setBounds(41, 206, 117, 29);
		frame.getContentPane().add(btnLogIn);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewUser newWindow = new createNewUser(); 
				newWindow.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(159, 206, 150, 29);
		frame.getContentPane().add(btnCreateAccount);
		
		btnGuest = new JButton("Guest");
		btnGuest.setBounds(309, 206, 117, 29);
		frame.getContentPane().add(btnGuest);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 139, 150, 26);
		frame.getContentPane().add(passwordField);
		
		
		
	}
	public JButton getBtnCreateAccount() {
		return btnCreateAccount;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Log In");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println(passwordField.getPassword());
			System.out.println(textField.getText());
		}
	}
}
