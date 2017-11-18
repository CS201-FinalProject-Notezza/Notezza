package GUI;

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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class UserProfile extends JFrame {

	private JPanel contentPane;

	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile frame = new UserProfile(null);
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
	public UserProfile(User user) {
		setResizable(false);
		this.user = user;
		
		setBounds(100, 100, 320, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String userName,fName,lName,email;

		if (user.isVisible()) {
			userName = user.getUsername();
			fName = user.getFname();
			lName = user.getLname();
			email = user.getEmail();
		} else {
			userName = user.getUsername();
			fName = "";
			lName = "";
			email = "";
		}
		
		JLabel privateLabel = new JLabel("This user's profile is private!");
		privateLabel.setForeground(new Color(178, 34, 34));
		privateLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		privateLabel.setEnabled(false);
		privateLabel.setBounds(37, 65, 245, 26);
		contentPane.add(privateLabel);
		
		JLabel lnameText = new JLabel("<dynamic>");
		lnameText.setHorizontalAlignment(SwingConstants.RIGHT);
		lnameText.setBounds(116, 69, 184, 26);
		contentPane.add(lnameText);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(20, 20, 100, 16);
		contentPane.add(usernameLabel);

		JLabel fnameLabel = new JLabel("First Name:");
		fnameLabel.setBounds(20, 47, 100, 16);
		contentPane.add(fnameLabel);
		
		JLabel lnameLabel = new JLabel("Last Name:");
		lnameLabel.setBounds(20, 74, 100, 16);
		contentPane.add(lnameLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(20, 101, 100, 16);
		contentPane.add(emailLabel);
		
		JLabel fnameText = new JLabel("<dynamic>");
		fnameText.setHorizontalAlignment(SwingConstants.RIGHT);
		fnameText.setBounds(116, 42, 184, 26);
		contentPane.add(fnameText);
		
		JLabel emailText = new JLabel("<dynamic>");
		emailText.setHorizontalAlignment(SwingConstants.RIGHT);
		emailText.setBounds(116, 96, 184, 26);
		contentPane.add(emailText);
		
		JLabel usernameText = new JLabel("<dynamic>");
		usernameText.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameText.setBounds(116, 15, 184, 26);
		contentPane.add(usernameText);
		
		if (!user.isVisible()) {
			privateLabel.setEnabled(true);
			fnameLabel.setEnabled(false);
			fnameText.setEnabled(false);
			lnameLabel.setEnabled(false);
			lnameText.setEnabled(false);
		}
	}

}
