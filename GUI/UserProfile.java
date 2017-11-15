package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class UserProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile frame = new UserProfile();
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
	public UserProfile() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(100, 75, 89, 16);
		contentPane.add(lblUsername);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(100, 93, 89, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(100, 111, 70, 16);
		contentPane.add(lblLastName);
		
		JCheckBox chckbxPrivate = new JCheckBox("Private");
		chckbxPrivate.setBounds(147, 177, 128, 23);
		contentPane.add(chckbxPrivate);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(100, 131, 61, 16);
		contentPane.add(lblEmail);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(68, 212, 117, 29);
		contentPane.add(btnApply);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(214, 212, 117, 29);
		contentPane.add(btnCancel);
	}

}
