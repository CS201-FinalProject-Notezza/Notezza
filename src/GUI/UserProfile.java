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
		contentPane.setBackground(new java.awt.Color(52, 61, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String userName,fName,lName,email;

		userName = user.getUsername();
		fName = user.getFname();
		lName = user.getLname();
		email = user.getEmail();
		
		JLabel privateLabel = new JLabel("This user's profile is private!");
		privateLabel.setForeground(new Color(178, 34, 34));
		privateLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		privateLabel.setVisible(false);
		privateLabel.setBounds(37, 65, 245, 26);
		contentPane.add(privateLabel);
		
		JLabel lnameText = new JLabel(lName);
		lnameText.setHorizontalAlignment(SwingConstants.RIGHT);
		lnameText.setBounds(116, 69, 184, 26);
		lnameText.setForeground(new java.awt.Color(204, 204, 204));
		lnameText.setBorder(null);
		contentPane.add(lnameText);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(20, 20, 100, 16);
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		usernameLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(usernameLabel);

		JLabel fnameLabel = new JLabel("First Name:");
		fnameLabel.setBounds(20, 47, 100, 16);
		fnameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		fnameLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(fnameLabel);
		
		JLabel lnameLabel = new JLabel("Last Name:");
		lnameLabel.setBounds(20, 74, 100, 16);
		lnameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lnameLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(lnameLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(20, 101, 100, 16);
		emailLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		emailLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(emailLabel);
		
		JLabel fnameText = new JLabel(fName);
		fnameText.setHorizontalAlignment(SwingConstants.RIGHT);
		fnameText.setBounds(116, 42, 184, 26);
		fnameText.setForeground(new java.awt.Color(204, 204, 204));
		fnameText.setBorder(null);
		contentPane.add(fnameText);
		
		JLabel emailText = new JLabel(email);
		emailText.setHorizontalAlignment(SwingConstants.RIGHT);
		emailText.setBounds(116, 96, 184, 26);
		emailText.setForeground(new java.awt.Color(204, 204, 204));
		emailText.setBorder(null);
		contentPane.add(emailText);
		
		JLabel usernameText = new JLabel(userName);
		usernameText.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameText.setBounds(116, 15, 184, 26);
		usernameText.setForeground(new java.awt.Color(204, 204, 204));
		usernameText.setBorder(null);
		contentPane.add(usernameText);
		
		if (!user.isVisible()) {
			privateLabel.setVisible(true);
			fnameLabel.setVisible(false);
			fnameText.setVisible(false);
			lnameLabel.setVisible(false);
			lnameText.setVisible(false);
			emailLabel.setVisible(false);
			emailText.setVisible(false);
		}
	}

}
