package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Color;

public class InstructorPresentation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorPresentation frame = new InstructorPresentation();
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
	public InstructorPresentation() {
	
		
		
		setBounds(100, 100, 791, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(500, 258, 265, 189);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(574, 449, 164, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.setBounds(574, 488, 149, 29);
		contentPane.add(btnSendMessage);
		
		JButton button = new JButton("<");
		button.setBounds(140, 469, 38, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton(">");
		button_1.setBounds(222, 469, 38, 29);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 42, 427, 383);
		contentPane.add(panel);
		
		JButton btnNewPresentation = new JButton("New Presentation");
		btnNewPresentation.setBounds(67, 371, 153, 29);
		contentPane.add(btnNewPresentation);
	}
	
}
