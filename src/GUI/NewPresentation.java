package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import NotezzaClient.NotezzaClient;
import objects.Course;
import objects.Presentation;
import objects.Quiz;

public class NewPresentation extends JFrame {

	private JPanel contentPane;
	private JLabel lblEnterLinksTo;
	private JTextArea linkText;
	private JLabel q1Label;
	private JTextField q1Text;
	private JTextField q1Choice1Text;
	private JLabel q1Choice1Label;
	private JCheckBox q1c1Check;
	private JTextField q1Choice2Text;
	private JLabel q1Choice2Label;
	private JCheckBox q1c2Check;
	private JTextField q1Choice3Text;
	private JLabel q1Choice3Label;
	private JCheckBox q1c3Check;
	private JTextField q1Choice4Text;
	private JLabel q1Choice4Label;
	private JCheckBox q1c4Check;
	private JTextField q1Choice5Text;
	private JLabel q1Choice5Label;
	private JCheckBox q1c5Check;
	private JLabel q2Label;
	private JTextField q2Text;
	private JTextField q2Choice1Text;
	private JLabel q2Choice1Label;
	private JCheckBox q2c1Check;
	private JTextField q2Choice2Text;
	private JLabel q2Choice2Label;
	private JCheckBox q2c2Check;
	private JTextField q2Choice3Text;
	private JLabel q2Choice3Label;
	private JCheckBox q2c3Check;
	private JTextField q2Choice4Text;
	private JLabel q2Choice4Label;
	private JCheckBox q2c4Check;
	private JTextField q2Choice5Text;
	private JLabel q2Choice5Label;
	private JCheckBox q2c5Check;
	private JLabel q3Label;
	private JTextField q3Text;
	private JTextField q3Choice1Text;
	private JLabel q3Choice1Label;
	private JCheckBox q3c1Check;
	private JTextField q3Choice2Text;
	private JLabel q3Choice2Label;
	private JCheckBox q3c2Check;
	private JTextField q3Choice3Text;
	private JLabel q3Choice3Label;
	private JCheckBox q3c3Check;
	private JTextField q3Choice4Text;
	private JLabel q3Choice4Label;
	private JCheckBox q3c4Check;
	private JTextField q3Choice5Text;
	private JLabel q3Choice5Label;
	private JCheckBox q3c5Check;
	private JButton createPresentationButton;
	
	private final Action AddNewPresentation = new AddNewPresentation();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPresentation frame = new NewPresentation(null,null);
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
	public NewPresentation(NotezzaClient client, Course course) {
		setTitle("New Presentation");
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEnterLinksTo = new JLabel("Enter links to slides (separated by commas):");
		lblEnterLinksTo.setBounds(15, 15, 368, 16);
		lblEnterLinksTo.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblEnterLinksTo);
		
		linkText = new JTextArea();
		linkText.setBounds(15, 43, 368, 85);
		contentPane.add(linkText);
		
		q1Label = new JLabel("Question 1: ");
		q1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Label.setBounds(15, 136, 77, 16);
		contentPane.add(q1Label);
		
		q1Text = new JTextField();
		q1Text.setBounds(94, 131, 290, 26);
		contentPane.add(q1Text);
		q1Text.setColumns(10);
		
		q1Choice1Text = new JTextField();
		q1Choice1Text.setColumns(10);
		q1Choice1Text.setBounds(94, 159, 261, 26);
		contentPane.add(q1Choice1Text);
		
		q1Choice1Label = new JLabel("Choice 1: ");
		q1Choice1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice1Label.setBounds(15, 164, 77, 16);
		contentPane.add(q1Choice1Label);
		
		q1c1Check = new JCheckBox("");
		q1c1Check.setBounds(355, 157, 28, 29);
		contentPane.add(q1c1Check);
		
		q1Choice2Text = new JTextField();
		q1Choice2Text.setColumns(10);
		q1Choice2Text.setBounds(94, 181, 261, 26);
		contentPane.add(q1Choice2Text);
		
		q1Choice2Label = new JLabel("Choice 2: ");
		q1Choice2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice2Label.setBounds(15, 186, 77, 16);
		contentPane.add(q1Choice2Label);
		
		q1c2Check = new JCheckBox("");
		q1c2Check.setBounds(355, 179, 28, 29);
		contentPane.add(q1c2Check);
		
		q1Choice3Text = new JTextField();
		q1Choice3Text.setColumns(10);
		q1Choice3Text.setBounds(94, 203, 261, 26);
		contentPane.add(q1Choice3Text);
		
		q1Choice3Label = new JLabel("Choice 3: ");
		q1Choice3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice3Label.setBounds(15, 208, 77, 16);
		contentPane.add(q1Choice3Label);
		
		q1c3Check = new JCheckBox("");
		q1c3Check.setBounds(355, 201, 28, 29);
		contentPane.add(q1c3Check);
		
		q1Choice4Text = new JTextField();
		q1Choice4Text.setColumns(10);
		q1Choice4Text.setBounds(94, 225, 261, 26);
		contentPane.add(q1Choice4Text);
		
		q1Choice4Label = new JLabel("Choice 4: ");
		q1Choice4Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice4Label.setBounds(15, 230, 77, 16);
		contentPane.add(q1Choice4Label);
		
		q1c4Check = new JCheckBox("");
		q1c4Check.setBounds(355, 223, 28, 29);
		contentPane.add(q1c4Check);
		
		q1Choice5Text = new JTextField();
		q1Choice5Text.setColumns(10);
		q1Choice5Text.setBounds(94, 247, 261, 26);
		contentPane.add(q1Choice5Text);
		
		q1Choice5Label = new JLabel("Choice 5: ");
		q1Choice5Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice5Label.setBounds(15, 252, 77, 16);
		contentPane.add(q1Choice5Label);
		
		q1c5Check = new JCheckBox("");
		q1c5Check.setBounds(355, 245, 28, 29);
		contentPane.add(q1c5Check);
		
		q2Label = new JLabel("Question 2: ");
		q2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Label.setBounds(15, 279, 77, 16);
		contentPane.add(q2Label);
		
		q2Text = new JTextField();
		q2Text.setColumns(10);
		q2Text.setBounds(94, 274, 290, 26);
		contentPane.add(q2Text);
		
		q2Choice1Text = new JTextField();
		q2Choice1Text.setColumns(10);
		q2Choice1Text.setBounds(94, 302, 261, 26);
		contentPane.add(q2Choice1Text);
		
		q2Choice1Label = new JLabel("Choice 1: ");
		q2Choice1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice1Label.setBounds(15, 307, 77, 16);
		contentPane.add(q2Choice1Label);
		
		q2c1Check = new JCheckBox("");
		q2c1Check.setBounds(355, 300, 28, 29);
		contentPane.add(q2c1Check);
		
		q2Choice2Text = new JTextField();
		q2Choice2Text.setColumns(10);
		q2Choice2Text.setBounds(94, 324, 261, 26);
		contentPane.add(q2Choice2Text);
		
		q2Choice2Label = new JLabel("Choice 2: ");
		q2Choice2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice2Label.setBounds(15, 329, 77, 16);
		contentPane.add(q2Choice2Label);
		
		q2c2Check = new JCheckBox("");
		q2c2Check.setBounds(355, 322, 28, 29);
		contentPane.add(q2c2Check);
		
		q2Choice3Text = new JTextField();
		q2Choice3Text.setColumns(10);
		q2Choice3Text.setBounds(94, 346, 261, 26);
		contentPane.add(q2Choice3Text);
		
		q2Choice3Label = new JLabel("Choice 3: ");
		q2Choice3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice3Label.setBounds(15, 351, 77, 16);
		contentPane.add(q2Choice3Label);
		
		q2c3Check = new JCheckBox("");
		q2c3Check.setBounds(355, 344, 28, 29);
		contentPane.add(q2c3Check);
		
		q2Choice4Text = new JTextField();
		q2Choice4Text.setColumns(10);
		q2Choice4Text.setBounds(94, 368, 261, 26);
		contentPane.add(q2Choice4Text);
		
		q2Choice4Label = new JLabel("Choice 4: ");
		q2Choice4Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice4Label.setBounds(15, 373, 77, 16);
		contentPane.add(q2Choice4Label);
		
		q2c4Check = new JCheckBox("");
		q2c4Check.setBounds(355, 366, 28, 29);
		contentPane.add(q2c4Check);
		
		q2Choice5Text = new JTextField();
		q2Choice5Text.setColumns(10);
		q2Choice5Text.setBounds(94, 390, 261, 26);
		contentPane.add(q2Choice5Text);
		
		q2Choice5Label = new JLabel("Choice 5: ");
		q2Choice5Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice5Label.setBounds(15, 395, 77, 16);
		contentPane.add(q2Choice5Label);
		
		q2c5Check = new JCheckBox("");
		q2c5Check.setBounds(355, 388, 28, 29);
		contentPane.add(q2c5Check);
		
		q3Label = new JLabel("Question 3: ");
		q3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Label.setBounds(15, 423, 77, 16);
		contentPane.add(q3Label);
		
		q3Text = new JTextField();
		q3Text.setColumns(10);
		q3Text.setBounds(94, 418, 290, 26);
		contentPane.add(q3Text);
		
		q3Choice1Text = new JTextField();
		q3Choice1Text.setColumns(10);
		q3Choice1Text.setBounds(94, 446, 261, 26);
		contentPane.add(q3Choice1Text);
		
		q3Choice1Label = new JLabel("Choice 1: ");
		q3Choice1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice1Label.setBounds(15, 451, 77, 16);
		contentPane.add(q3Choice1Label);
		
		q3c1Check = new JCheckBox("");
		q3c1Check.setBounds(355, 444, 28, 29);
		contentPane.add(q3c1Check);
		
		q3Choice2Text = new JTextField();
		q3Choice2Text.setColumns(10);
		q3Choice2Text.setBounds(94, 468, 261, 26);
		contentPane.add(q3Choice2Text);
		
		q3Choice2Label = new JLabel("Choice 2: ");
		q3Choice2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice2Label.setBounds(15, 473, 77, 16);
		contentPane.add(q3Choice2Label);
		
		q3c2Check = new JCheckBox("");
		q3c2Check.setBounds(355, 466, 28, 29);
		contentPane.add(q3c2Check);
		
		q3Choice3Text = new JTextField();
		q3Choice3Text.setColumns(10);
		q3Choice3Text.setBounds(94, 490, 261, 26);
		contentPane.add(q3Choice3Text);
		
		q3Choice3Label = new JLabel("Choice 3: ");
		q3Choice3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice3Label.setBounds(15, 495, 77, 16);
		contentPane.add(q3Choice3Label);
		
		q3c3Check = new JCheckBox("");
		q3c3Check.setBounds(355, 488, 28, 29);
		contentPane.add(q3c3Check);
		
		q3Choice4Text = new JTextField();
		q3Choice4Text.setColumns(10);
		q3Choice4Text.setBounds(94, 512, 261, 26);
		contentPane.add(q3Choice4Text);
		
		q3Choice4Label = new JLabel("Choice 4: ");
		q3Choice4Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice4Label.setBounds(15, 517, 77, 16);
		contentPane.add(q3Choice4Label);
		
		q3c4Check = new JCheckBox("");
		q3c4Check.setBounds(355, 510, 28, 29);
		contentPane.add(q3c4Check);
		
		q3Choice5Text = new JTextField();
		q3Choice5Text.setColumns(10);
		q3Choice5Text.setBounds(94, 534, 261, 26);
		contentPane.add(q3Choice5Text);
		
		q3Choice5Label = new JLabel("Choice 5: ");
		q3Choice5Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice5Label.setBounds(15, 539, 77, 16);
		contentPane.add(q3Choice5Label);
		
		q3c5Check = new JCheckBox("");
		q3c5Check.setBounds(355, 532, 28, 29);
		contentPane.add(q3c5Check);
		
		createPresentationButton = new JButton("Create Presentation");
		createPresentationButton.setBounds(117, 574, 166, 29);
		contentPane.add(createPresentationButton);
		createPresentationButton.setAction(AddNewPresentation);
		createPresentationButton.setText("Create Presentation");
	}

	private class AddNewPresentation extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			// Get all the text value;
			String allLinksStr = linkText.getText();
			String [] linksArray = allLinksStr.split(",");
			Vector<String> links = new Vector<String>(Arrays.asList(linksArray));
			// Show error if no links entered
			if (links.size() == 1 && links.get(0).equals("")) {
				JOptionPane.showMessageDialog(contentPane, "ERROR: There must be at least one slide link!", "ERROR",  JOptionPane.ERROR_MESSAGE);
				return;
			}

			String q1Name = q1Text.getText();
			String q2Name = q2Text.getText();
			String q3Name = q3Text.getText();

			Quiz quiz1 = null;
			Quiz quiz2 = null;
			Quiz quiz3 = null;


			if (!q1Name.isEmpty()) {
				int numOfQuiz = 0;
				String [] quizArrays = {q1Choice1Text.getText(),q1Choice2Text.getText(),q1Choice3Text.getText(),
						q1Choice4Text.getText(),q1Choice5Text.getText()};
				JCheckBox [] checkboxes = {q1c1Check, q1c2Check, q1c3Check, q1c4Check, q1c5Check};
				Vector<String> choices = new Vector<>();
				Set<Integer> correctAnswer = new HashSet<>();
				for (int i = 0; i < quizArrays.length; i++) {
					if (!quizArrays[i].isEmpty()){
						numOfQuiz++;
						choices.add(quizArrays[i]);
						if (checkboxes[i].isSelected()) {
							correctAnswer.add(choices.indexOf(quizArrays[i]));
						}
					}
				}


				if (choices.size() >= 1) {
					// create the quiz otherwise set to null;
					quiz1 = new Quiz(q1Name,choices,correctAnswer);
				} else {
					quiz1 = null;
				}
			}

			if (!q2Name.isEmpty()) {
				int numOfQuiz = 0;
				String [] quizArrays = {q2Choice1Text.getText(),q2Choice2Text.getText(),q2Choice3Text.getText(),
						q2Choice4Text.getText(),q2Choice5Text.getText()};
				JCheckBox [] checkboxes = {q2c1Check, q2c2Check, q2c3Check, q2c4Check, q2c5Check};
				Vector<String> choices = new Vector<>();
				Set<Integer> correctAnswer = new HashSet<>();
				for (int i = 0; i < quizArrays.length; i++) {
					if (!quizArrays[i].isEmpty()){
						numOfQuiz++;
						choices.add(quizArrays[i]);
						if (checkboxes[i].isSelected()) {
							correctAnswer.add(choices.indexOf(quizArrays[i]));
						}
					}
				}
				if (choices.size() >= 1) {
					// create the quiz otherwise set to null;
					quiz2 = new Quiz(q2Name,choices,correctAnswer);
				} else {
					quiz2 = null;
				}
			}

			if (!q3Name.isEmpty()) {
				int numOfQuiz = 0;
				String [] quizArrays = {q3Choice1Text.getText(),q3Choice2Text.getText(),q3Choice3Text.getText(),
						q3Choice4Text.getText(),q3Choice5Text.getText()};
				JCheckBox [] checkboxes = {q3c1Check, q3c2Check, q3c3Check, q3c4Check, q3c5Check};
				Vector<String> choices = new Vector<>();
				Set<Integer> correctAnswer = new HashSet<>();
				for (int i = 0; i < quizArrays.length; i++) {
					if (!quizArrays[i].isEmpty()){
						numOfQuiz++;
						choices.add(quizArrays[i]);
						if (checkboxes[i].isSelected()) {
							correctAnswer.add(choices.indexOf(quizArrays[i]));
						}
					}
				}
				if (choices.size() >= 1) {
					// create the quiz otherwise set to null;
					quiz3 = new Quiz(q3Name,choices,correctAnswer);
				} else {
					quiz3 = null;
				}
			}
			
			Vector<Quiz> quizzes = new Vector<Quiz>();
			if (quiz1 != null) { quizzes.add(quiz1); }
			if (quiz2 != null) { quizzes.add(quiz2); }
			if (quiz3 != null) { quizzes.add(quiz3); }
			
			Presentation p = new Presentation(links, quizzes);
		}
	}


}
