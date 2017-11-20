package GUI;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.CreateClassInfo;
import objects.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;

public class NewCourse extends JFrame {

	private JPanel contentPane;
	private JTextPane emailText;

	private NotezzaClient client;
	private JTextField courseNameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCourse frame = new NewCourse(null);
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
	public NewCourse(NotezzaClient client) {
		setResizable(false);

		this.client = client;
		
		setTitle("New Course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(52, 61, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel courseNameLabel = new JLabel("Course Name:");
		courseNameLabel.setBounds(20, 20, 116, 16);
		courseNameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		courseNameLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(courseNameLabel);
		
		JLabel emailLabel = new JLabel("Student Emails:");
		emailLabel.setBounds(20, 49, 165, 16);
		emailLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		emailLabel.setForeground(new java.awt.Color(204, 204, 204));
		contentPane.add(emailLabel);
		
		emailText = new JTextPane();
		emailText.setBounds(20, 70, 280, 122);
		emailText.setBackground(new java.awt.Color(204, 204, 204));
		emailText.setForeground(new java.awt.Color(52, 61, 70));
		emailText.setBorder(null);
		emailText.setCaretColor(new java.awt.Color(52, 61, 70));
		contentPane.add(emailText);
		Action addClass = new AddClass();
		Action action = new SwingAction();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(136, 32, 164, 16);
		contentPane.add(separator);
		
		courseNameText = new JTextField();
		courseNameText.setForeground(new Color(204, 204, 204));
		courseNameText.setColumns(10);
		courseNameText.setCaretColor(new Color(204, 204, 204));
		courseNameText.setBorder(null);
		courseNameText.setBackground(new Color(52, 61, 70));
		courseNameText.setBounds(136, 15, 164, 26);
		contentPane.add(courseNameText);
		
		JButton createCourseButton = new JButton("Create Course");
		createCourseButton.setForeground(new Color(52, 61, 70));
		createCourseButton.setFont(new Font("Dialog", Font.BOLD, 15));
		createCourseButton.setBounds(80, 205, 160, 34);
		contentPane.add(createCourseButton);
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
	private class AddClass extends AbstractAction {
 		public AddClass() {
						putValue(NAME, "OK");
						putValue(SHORT_DESCRIPTION, "Some short description");
					}
 		public void actionPerformed(ActionEvent e) {
			System.out.println("Creating class");
			String courseName = courseNameText.getText();
			String studentEmailStrings = emailText.getText();
			String[] studentEmailArrays = studentEmailStrings.split(",");

			User instructor = client.getUser();
			client.sendCommand(new Command(CommandType.CREATE_CLASS,new CreateClassInfo(courseName,studentEmailArrays,instructor)));
		}
	}
}
