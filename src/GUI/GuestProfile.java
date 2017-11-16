package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class GuestProfile extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestProfile frame = new GuestProfile();
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
	public GuestProfile() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username: N/A");
		lblUsername.setBounds(100, 75, 175, 16);
		contentPane.add(lblUsername);
		
		JLabel lblFirstName = new JLabel("First Name: N/A");
		lblFirstName.setBounds(100, 93, 175, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: N/A");
		lblLastName.setBounds(100, 111, 175, 16);
		contentPane.add(lblLastName);
		
		JCheckBox chckbxPrivate = new JCheckBox("Private");
		chckbxPrivate.setEnabled(false);
		chckbxPrivate.setSelected(true);
		chckbxPrivate.setBounds(147, 177, 128, 23);
		contentPane.add(chckbxPrivate);
		
		JLabel lblEmail = new JLabel("Email: N/A");
		lblEmail.setBounds(100, 131, 140, 16);
		contentPane.add(lblEmail);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setAction(action);
		btnApply.setBounds(68, 212, 117, 29);
		contentPane.add(btnApply);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action_1);
		btnCancel.setBounds(214, 212, 117, 29);
		contentPane.add(btnCancel);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Apply");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
