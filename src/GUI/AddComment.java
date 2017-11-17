package GUI;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class AddComment extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private TextArea commentText;
	private final Action action_1 = new SwingAction_1();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddComment frame = new AddComment();
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
	public AddComment() {
		
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
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(47, 35, 72, 16);
		contentPane.add(lblComment);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setAction(action_1);
		btnSubmit.setBounds(47, 222, 117, 29);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action);
		btnCancel.setBounds(194, 222, 117, 29);
		contentPane.add(btnCancel);
		
		commentText = new TextArea();
		commentText.setBounds(57, 57, 354, 157);
		contentPane.add(commentText);
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
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Comment");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(commentText.getText().equals("")) 
				{
					//open a dialogue to warn the user
					JOptionPane.showMessageDialog(contentPane, "ERROR: Please enter a comment!", "ERROR",  JOptionPane.ERROR_MESSAGE);
				
				}
		}
	}
}
