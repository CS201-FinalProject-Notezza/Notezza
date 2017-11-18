package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class InstructorPresentation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private JList chatList;
	private JComboBox questionBox;
	private ImageIcon presentationSlide;
	private JLabel slideLabel; 
	private final Action action = new SwingAction();
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
	// TODO add constructor
	public InstructorPresentation() {
		setTitle("Presentation");
		setResizable(false);
	
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
		
		
		setBounds(100, 100, 791, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chatList = new JList();
		chatList.setBounds(501, 122, 265, 303);
		contentPane.add(chatList);
		
		textField = new JTextField();
		textField.setBounds(496, 469, 164, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.setBounds(664, 469, 121, 29);
		contentPane.add(btnSendMessage);
		
		JButton button = new JButton("<");
		button.setBounds(140, 469, 38, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton(">");
		button_1.setBounds(222, 469, 38, 29);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(32, 42, 427, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		presentationSlide = new ImageIcon("Notezza.png");
		
		slideLabel = new JLabel(presentationSlide);
		slideLabel.setBounds(6, 6, 415, 371);
		panel.add(slideLabel);
		
		
		//JLabel lblNewLabel = new JLabel(logo);
		
		
		//JButton btnNewPresentation = new JButton("New Presentation");
		//btnNewPresentation.setBounds(67, 371, 153, 29);
		//contentPane.add(btnNewPresentation);
		
		JButton btnNewPresentation_1 = new JButton("New Presentation");
		btnNewPresentation_1.setAction(action);
		btnNewPresentation_1.setBounds(633, 6, 152, 29);
		contentPane.add(btnNewPresentation_1);
		
		 questionBox = new JComboBox();
		questionBox.setBounds(491, 70, 294, 27);
		contentPane.add(questionBox);
		
		JLabel lblQuestions = new JLabel("Questions:");
		lblQuestions.setBounds(491, 42, 112, 16);
		contentPane.add(lblQuestions);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "New Presentation");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			//TODO uncomment
			//NewPresentation newPresentation = new NewPresentation(c);
			//newPresentation.setVisible(true);
		}
	}
}
