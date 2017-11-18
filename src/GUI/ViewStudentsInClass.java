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
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.DefaultListModel;

public class ViewStudentsInClass extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JList studentList;
	private DefaultListModel studentDefaultListModel;

	private Vector<User> students;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentsInClass frame = new ViewStudentsInClass(null);
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
	public ViewStudentsInClass(Vector<User> students) {
		
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

		this.students = students;
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setBounds(70, 26, 92, 16);
		contentPane.add(lblStudents);
		
		studentDefaultListModel = new DefaultListModel();
		
		for(int i = 0; i<students.size(); i++)
		{
			studentDefaultListModel.addElement(students.get(i).getUsername());
		}
		studentList = new JList(studentDefaultListModel);
		
		
		studentList.setBounds(70, 69, 289, 163);
		contentPane.add(studentList);
		
		JButton btnClose = new JButton("Close");
		btnClose.setAction(action);
		btnClose.setBounds(141, 244, 117, 29);
		contentPane.add(btnClose);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Close");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
