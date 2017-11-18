package GUI;

import NotezzaClient.NotezzaClient;
import objects.Course;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class UserPresentation extends JFrame {

	private JPanel contentPane;
	private JTextField chatTextBox;

	private NotezzaClient client;
	private Course course;

	private JButton slideBackwardsButton;
	private JButton slideForwardButton;
	private final Action slideForward = new SlideForwards();
	//private final Action slideBackwards;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPresentation frame = new UserPresentation(null,null);
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
	public UserPresentation(NotezzaClient client, Course course) {
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

		this.client = client;
		this.course = course;

		setBounds(100, 100, 791, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList chatWindow = new JList();
		chatWindow.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		chatWindow.setBounds(500, 271, 272, 202);
		contentPane.add(chatWindow);
		
		chatTextBox = new JTextField();
		chatTextBox.setBounds(499, 473, 207, 27);
		contentPane.add(chatTextBox);
		chatTextBox.setColumns(10);
		
		JButton sendChatButton = new JButton("Send");
		sendChatButton.setBounds(707, 473, 68, 29);
		contentPane.add(sendChatButton);
		
		JPanel slidePanel = new JPanel();
		slidePanel.setBorder(null);
		slidePanel.setBounds(20, 37, 468, 409);
		contentPane.add(slidePanel);

		Vector<String> urls = course.getCurrentLecture().getLinks();
		// Hardcoded URL is here: "http://1.bp.blogspot.com/-Uuu510AUdjk/Vqqo0jAUe5I/AAAAAAAAAc8/UCdgGmH5EUc/s1600/figure_01.gif";
		try {
			URL temp = new URL(urls.get(0));
			ImageIcon slideImage = new ImageIcon(temp);
			JLabel slideImageLabel = new JLabel("");
			slideImageLabel.setIcon(slideImage);
			slidePanel.add(slideImageLabel);
		} catch (MalformedURLException murle) { }
		
		JPanel quizPanel = new JPanel();
		quizPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		quizPanel.setBounds(500, 42, 272, 218);
		contentPane.add(quizPanel);
		GridBagLayout gbl_quizPanel = new GridBagLayout();
		gbl_quizPanel.columnWidths = new int[] {136, 133, 136};
		gbl_quizPanel.rowHeights = new int[] {50, 28, 28, 28, 28, 28, 28};
		gbl_quizPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_quizPanel.rowWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		quizPanel.setLayout(gbl_quizPanel);
		
		JLabel questionLabel = new JLabel("Quiz Question");
		questionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		GridBagConstraints gbc_questionLabel = new GridBagConstraints();
		gbc_questionLabel.anchor = GridBagConstraints.WEST;
		gbc_questionLabel.gridwidth = 2;
		gbc_questionLabel.insets = new Insets(0, 0, 5, 0);
		gbc_questionLabel.gridx = 0;
		gbc_questionLabel.gridy = 0;
		quizPanel.add(questionLabel, gbc_questionLabel);
		
		JCheckBox answer1 = new JCheckBox("Answer 1");
		GridBagConstraints gbc_answer1 = new GridBagConstraints();
		gbc_answer1.anchor = GridBagConstraints.WEST;
		gbc_answer1.gridwidth = 2;
		gbc_answer1.insets = new Insets(0, 0, 5, 5);
		gbc_answer1.gridx = 0;
		gbc_answer1.gridy = 1;
		quizPanel.add(answer1, gbc_answer1);
		
		JCheckBox answer2 = new JCheckBox("Answer 2");
		GridBagConstraints gbc_answer2 = new GridBagConstraints();
		gbc_answer2.anchor = GridBagConstraints.WEST;
		gbc_answer2.gridwidth = 2;
		gbc_answer2.insets = new Insets(0, 0, 5, 5);
		gbc_answer2.gridx = 0;
		gbc_answer2.gridy = 2;
		quizPanel.add(answer2, gbc_answer2);
		
		JCheckBox answer3 = new JCheckBox("Answer 3");
		GridBagConstraints gbc_answer3 = new GridBagConstraints();
		gbc_answer3.anchor = GridBagConstraints.WEST;
		gbc_answer3.gridwidth = 2;
		gbc_answer3.insets = new Insets(0, 0, 5, 5);
		gbc_answer3.gridx = 0;
		gbc_answer3.gridy = 3;
		quizPanel.add(answer3, gbc_answer3);
		
		JCheckBox answer4 = new JCheckBox("Answer 4");
		GridBagConstraints gbc_answer4 = new GridBagConstraints();
		gbc_answer4.anchor = GridBagConstraints.WEST;
		gbc_answer4.gridwidth = 2;
		gbc_answer4.insets = new Insets(0, 0, 5, 5);
		gbc_answer4.gridx = 0;
		gbc_answer4.gridy = 4;
		quizPanel.add(answer4, gbc_answer4);
		
		JCheckBox answer5 = new JCheckBox("Answer 5");
		GridBagConstraints gbc_answer5 = new GridBagConstraints();
		gbc_answer5.anchor = GridBagConstraints.WEST;
		gbc_answer5.gridwidth = 2;
		gbc_answer5.insets = new Insets(0, 0, 5, 5);
		gbc_answer5.gridx = 0;
		gbc_answer5.gridy = 5;
		quizPanel.add(answer5, gbc_answer5);
		
		JButton checkAnswerButton = new JButton("Check");
		GridBagConstraints gbc_checkAnswerButton = new GridBagConstraints();
		gbc_checkAnswerButton.insets = new Insets(0, 0, 0, 5);
		gbc_checkAnswerButton.gridx = 0;
		gbc_checkAnswerButton.gridy = 6;
		quizPanel.add(checkAnswerButton, gbc_checkAnswerButton);
		
		JLabel correctLabel = new JLabel("Correct/Incorrect");
		GridBagConstraints gbc_correctLabel = new GridBagConstraints();
		gbc_correctLabel.gridx = 1;
		gbc_correctLabel.gridy = 6;
		quizPanel.add(correctLabel, gbc_correctLabel);
		
		JPanel slideButtonPanel = new JPanel();
		slideButtonPanel.setBounds(17, 473, 468, 27);
		contentPane.add(slideButtonPanel);
		GridBagLayout gbl_slideButtonPanel = new GridBagLayout();
		gbl_slideButtonPanel.columnWidths = new int[] {220, 28, 220};
		gbl_slideButtonPanel.rowHeights = new int[]{0, 0};
		gbl_slideButtonPanel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_slideButtonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		slideButtonPanel.setLayout(gbl_slideButtonPanel);
		
		slideBackwardsButton = new JButton("<");
		GridBagConstraints gbc_slideBackwardsButton = new GridBagConstraints();
		gbc_slideBackwardsButton.insets = new Insets(0, 0, 0, 5);
		gbc_slideBackwardsButton.gridx = 0;
		gbc_slideBackwardsButton.gridy = 0;
		slideButtonPanel.add(slideBackwardsButton, gbc_slideBackwardsButton);
		
		slideForwardButton = new JButton(">");
		GridBagConstraints gbc_slideForwardButton = new GridBagConstraints();
		gbc_slideForwardButton.gridx = 2;
		gbc_slideForwardButton.gridy = 0;
		slideButtonPanel.add(slideForwardButton, gbc_slideForwardButton);
	}

	private class SlideForwards extends AbstractAction {
		public SlideForwards() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

		}
	}
}
