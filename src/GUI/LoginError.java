package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginError extends JFrame {

	private JPanel contentPane;

	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginError frame = new LoginError();
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
	public LoginError() {

		setBounds(100, 100, 320, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(52, 61, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel privateLabel = new JLabel("Password or Username incorrect!");
		privateLabel.setForeground(new Color(178, 34, 34));
		privateLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		privateLabel.setVisible(true);
		privateLabel.setBounds(20, 20, 320, 26);
		contentPane.add(privateLabel);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSubmit.setAction(action);
		btnSubmit.setBounds(70, 50, 160, 30);
		btnSubmit.setForeground(new java.awt.Color(52, 61, 70));
		contentPane.add(btnSubmit);
		

	}

	public class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}

}
