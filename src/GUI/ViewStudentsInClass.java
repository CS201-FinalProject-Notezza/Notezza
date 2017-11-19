package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import objects.User;

public class ViewStudentsInClass extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JList studentList;
	private DefaultListModel studentDefaultListModel;

	private Vector<User> students;
	private JLabel instructorLabel;
	private JLabel instructorText;
	private JSeparator separator;
	private JLabel studentsLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentsInClass frame = new ViewStudentsInClass(null, null);
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
	public ViewStudentsInClass(Vector<User> students, User instructor) {
		setTitle("Course Info");
		setResizable(false);

		this.students = students;
		
		setBounds(100, 100, 200, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(52, 61, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		studentDefaultListModel = new DefaultListModel();
		
		for(int i = 0; i<students.size(); i++)
		{
			studentDefaultListModel.addElement(students.get(i).getUsername());
		}
		studentList = new JList(studentDefaultListModel);
		
		
		studentList.setBounds(22, 92, 156, 219);
		studentList.setBackground(new java.awt.Color(204, 204, 204));
		studentList.setForeground(new java.awt.Color(52, 61, 70));
		studentList.setBorder(null);
		contentPane.add(studentList);
		
		studentList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        // Double click detected
		        if (evt.getClickCount() == 2) {
		        	
		        	String username = (String)studentList.getSelectedValue();
		        	for (User s : students) {
		        		if (s.getUsername().equals(username)) {
		        			UserProfile profile = new UserProfile(s);
		        			profile.setVisible(true);
		        			break;
		        		}
		        	}
		        }
		    }
		});
		
		instructorLabel = new JLabel("Instructor: ");
		instructorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructorLabel.setForeground(new Color(204, 204, 204));
		instructorLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		instructorLabel.setBounds(6, 14, 188, 16);
		contentPane.add(instructorLabel);
		
		instructorText = new JLabel(instructor.getUsername());
		instructorText.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		instructorText.setHorizontalAlignment(SwingConstants.CENTER);
		instructorText.setForeground(new Color(204, 204, 204));
		instructorText.setBorder(null);
		instructorText.setBounds(6, 30, 188, 26);
		contentPane.add(instructorText);
		
		instructorText.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        // Double click detected
		        if (evt.getClickCount() == 2) {
		        	
		        	UserProfile profile = new UserProfile(instructor);
		        	profile.setVisible(true);
		        }
		    }
		});
		
		separator = new JSeparator();
		separator.setBounds(8, 56, 184, 16);
		contentPane.add(separator);
		
		studentsLabel = new JLabel("Students:");
		studentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		studentsLabel.setForeground(new Color(204, 204, 204));
		studentsLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		studentsLabel.setBounds(6, 68, 188, 16);
		contentPane.add(studentsLabel);
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
