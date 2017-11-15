package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.TextField;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.List;
import javax.swing.JTabbedPane;

public class UserWindow extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow frame = new UserWindow();
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
	public UserWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUserProfile = new JButton("User Profile");
		btnUserProfile.setAction(action);
		btnUserProfile.setBounds(877, 6, 117, 29);
		contentPane.add(btnUserProfile);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(472, 442, 499, 179);
		contentPane.add(textArea);
		
		Button button = new Button("Add Note");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(772, 627, 117, 29);
		contentPane.add(button);
		
		List list = new List();
		list.setBounds(46, 124, 290, 532);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(35, 72, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>() ;
		comboBox.setBounds(35, 33, 141, 27);
		contentPane.add(comboBox);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(177, 72, 117, 29);
		contentPane.add(button_1);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "User Profile");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			UserProfile profile = new UserProfile();
			profile.setVisible(true);
		}
	}
}
