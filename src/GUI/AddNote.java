package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class AddNote extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNote frame = new AddNote();
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
	public AddNote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(153, 45, 270, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(107, 50, 61, 16);
		contentPane.add(lblTitle);
		
		JLabel lblTags = new JLabel("Tags:");
		lblTags.setBounds(107, 83, 61, 16);
		contentPane.add(lblTags);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(107, 148, 94, 16);
		contentPane.add(lblDescription);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(107, 174, 425, 173);
		contentPane.add(textArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(21, 359, 94, 26);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action);
		btnCancel.setBounds(117, 359, 117, 29);
		contentPane.add(btnCancel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 83, 270, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
