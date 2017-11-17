package GUI;

import NotezzaClient.NotezzaClient;
import objects.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class InstructorProfile extends JFrame {

	private JPanel contentPane;

	User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorProfile frame = new InstructorProfile(null);
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
	public InstructorProfile(User user) {
		this.user = user;
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
		String userName,fName,lName,email;
		if (user.isVisible()) {
			userName = user.getUsername();
			fName = user.getFname();
			lName = user.getLname();
			email = user.getEmail();
		} else {
			userName = "N/A";
			fName = "N/A";
			lName = "N/A";
			email = "N/A";
		}
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username: " + userName);
		lblUsername.setBounds(100, 75, 289, 16);
		contentPane.add(lblUsername);
		
		JLabel lblFirstName = new JLabel("First Name: " + fName);
		lblFirstName.setBounds(100, 93, 289, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: " + lName);
		lblLastName.setBounds(100, 111, 289, 16);
		contentPane.add(lblLastName);
		
		JCheckBox chckbxPrivate = new JCheckBox("Private");
		chckbxPrivate.setEnabled(false);
		chckbxPrivate.setBounds(147, 177, 128, 23);
		contentPane.add(chckbxPrivate);
		
		JLabel lblEmail = new JLabel("Email: " + email);
		lblEmail.setBounds(100, 131, 267, 16);
		contentPane.add(lblEmail);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(68, 212, 117, 29);
		contentPane.add(btnApply);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(214, 212, 117, 29);
		contentPane.add(btnCancel);
	}

}
