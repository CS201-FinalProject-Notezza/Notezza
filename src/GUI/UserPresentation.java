package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserPresentation extends JFrame {

	private JPanel contentPane;
	//private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPresentation frame = new UserPresentation();
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
	public UserPresentation() {
		setBounds(100, 100, 573, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(366, 183, 186, 145);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(376, 339, 164, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.setBounds(391, 371, 149, 29);
		contentPane.add(btnSendMessage);
		
		JButton button = new JButton("<");
		button.setBounds(83, 330, 38, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton(">");
		button_1.setBounds(150, 330, 38, 29);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 42, 289, 246);
		contentPane.add(panel);
	}
}
