package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.ChatMessage;
import objects.Course;
import objects.Quiz;

public class UserPresentation extends JFrame {

	private JPanel contentPane;
	private JTextField chatTextBox;
	private JPanel slidePanel;
	private Vector<JComponent> quizObjects = new Vector<JComponent>();

	private NotezzaClient client;
	private Course course;
	private Quiz currQuiz = null;

	private JLabel slideImageLabel;
	private URL temp;
	private BufferedImage image;
	
	private JLabel questionLabel;
	private JCheckBox answer1;
	private JCheckBox answer2;
	private JCheckBox answer3;
	private JCheckBox answer4;
	private JCheckBox answer5;
	private JButton checkAnswerButton;
	private JLabel correctLabel;
	private Vector<JCheckBox> checkboxes = new Vector<JCheckBox>();

	private JButton slideBackwardsButton;
	private JButton slideForwardButton;
	private JButton sendChatButton;
	private final Action slideForwards = new SlideForwards();
	private final Action slideBackwards = new SlideBackwards();
	private final Action sendChatMessage = new SendChatMessage();
	private final Action checkQuizAnswers = new CheckQuizAnswers();
	private int lectureIndex;
	private Vector<String> urls;
	
	private JList chatWindow;
	private DefaultListModel chatDefaultListModel;
	
	//private final Action slideBackwards;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPresentation frame = new UserPresentation(null, null);
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
		this.lectureIndex = 0;

		setBounds(100, 100, 791, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		chatDefaultListModel = new DefaultListModel();
		
		chatWindow = new JList(chatDefaultListModel);
		chatWindow.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		chatWindow.setBounds(500, 271, 272, 202);
		contentPane.add(chatWindow);

		chatTextBox = new JTextField();
		chatTextBox.setBounds(499, 473, 207, 27);
		contentPane.add(chatTextBox);
		chatTextBox.setColumns(10);

		sendChatButton = new JButton("Send");
		sendChatButton.setBounds(707, 473, 68, 29);
		sendChatButton.setAction(sendChatMessage);
		contentPane.add(sendChatButton);

		slidePanel = new JPanel();
		slidePanel.setBorder(null);
		slidePanel.setBounds(20, 37, 468, 409);
		contentPane.add(slidePanel);

		//this.urls = course.getCurrentLecture().getLinks();
		// Hardcoded URL is here: "http://1.bp.blogspot.com/-Uuu510AUdjk/Vqqo0jAUe5I/AAAAAAAAAc8/UCdgGmH5EUc/s1600/figure_01.gif";
		// TODO CHANGE THIS LATER:
		// HARDCODE WARNING:
		this.urls = new Vector<>();
		slideImageLabel = new JLabel("");
		slidePanel.add(slideImageLabel);

		urls.add("http://www-scf.usc.edu/~csci201/images/jeffrey_miller.jpg");
		urls.add("http://1.bp.blogspot.com/-Uuu510AUdjk/Vqqo0jAUe5I/AAAAAAAAAc8/UCdgGmH5EUc/s1600/figure_01.gif");
		if (urls.size() != 0) {
			displayImage();
		}

		JPanel quizPanel = new JPanel();
		quizPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		quizPanel.setBounds(500, 42, 272, 218);
		contentPane.add(quizPanel);
		GridBagLayout gbl_quizPanel = new GridBagLayout();
		gbl_quizPanel.columnWidths = new int[]{136, 133, 136};
		gbl_quizPanel.rowHeights = new int[]{50, 28, 28, 28, 28, 28, 28};
		gbl_quizPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_quizPanel.rowWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		quizPanel.setLayout(gbl_quizPanel);

		questionLabel = new JLabel("Quiz Question");
		questionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		GridBagConstraints gbc_questionLabel = new GridBagConstraints();
		gbc_questionLabel.anchor = GridBagConstraints.WEST;
		gbc_questionLabel.gridwidth = 2;
		gbc_questionLabel.insets = new Insets(0, 0, 5, 0);
		gbc_questionLabel.gridx = 0;
		gbc_questionLabel.gridy = 0;
		quizPanel.add(questionLabel, gbc_questionLabel);
		quizObjects.add(questionLabel);

		answer1 = new JCheckBox("Answer 1");
		GridBagConstraints gbc_answer1 = new GridBagConstraints();
		gbc_answer1.anchor = GridBagConstraints.WEST;
		gbc_answer1.gridwidth = 2;
		gbc_answer1.insets = new Insets(0, 0, 5, 5);
		gbc_answer1.gridx = 0;
		gbc_answer1.gridy = 1;
		quizPanel.add(answer1, gbc_answer1);
		quizObjects.add(answer1);
		checkboxes.add(answer1);

		answer2 = new JCheckBox("Answer 2");
		GridBagConstraints gbc_answer2 = new GridBagConstraints();
		gbc_answer2.anchor = GridBagConstraints.WEST;
		gbc_answer2.gridwidth = 2;
		gbc_answer2.insets = new Insets(0, 0, 5, 5);
		gbc_answer2.gridx = 0;
		gbc_answer2.gridy = 2;
		quizPanel.add(answer2, gbc_answer2);
		quizObjects.add(answer2);
		checkboxes.add(answer2);

		answer3 = new JCheckBox("Answer 3");
		GridBagConstraints gbc_answer3 = new GridBagConstraints();
		gbc_answer3.anchor = GridBagConstraints.WEST;
		gbc_answer3.gridwidth = 2;
		gbc_answer3.insets = new Insets(0, 0, 5, 5);
		gbc_answer3.gridx = 0;
		gbc_answer3.gridy = 3;
		quizPanel.add(answer3, gbc_answer3);
		quizObjects.add(answer3);
		checkboxes.add(answer3);

		answer4 = new JCheckBox("Answer 4");
		GridBagConstraints gbc_answer4 = new GridBagConstraints();
		gbc_answer4.anchor = GridBagConstraints.WEST;
		gbc_answer4.gridwidth = 2;
		gbc_answer4.insets = new Insets(0, 0, 5, 5);
		gbc_answer4.gridx = 0;
		gbc_answer4.gridy = 4;
		quizPanel.add(answer4, gbc_answer4);
		quizObjects.add(answer4);
		checkboxes.add(answer4);

		answer5 = new JCheckBox("Answer 5");
		GridBagConstraints gbc_answer5 = new GridBagConstraints();
		gbc_answer5.anchor = GridBagConstraints.WEST;
		gbc_answer5.gridwidth = 2;
		gbc_answer5.insets = new Insets(0, 0, 5, 5);
		gbc_answer5.gridx = 0;
		gbc_answer5.gridy = 5;
		quizPanel.add(answer5, gbc_answer5);
		quizObjects.add(answer5);
		checkboxes.add(answer5);

		checkAnswerButton = new JButton("Check");
		checkAnswerButton.setAction(checkQuizAnswers);
		checkAnswerButton.setText("Check");
		GridBagConstraints gbc_checkAnswerButton = new GridBagConstraints();
		gbc_checkAnswerButton.insets = new Insets(0, 0, 0, 5);
		gbc_checkAnswerButton.gridx = 0;
		gbc_checkAnswerButton.gridy = 6;
		quizPanel.add(checkAnswerButton, gbc_checkAnswerButton);
		quizObjects.addElement(checkAnswerButton);

		correctLabel = new JLabel("Correct/Incorrect");
		GridBagConstraints gbc_correctLabel = new GridBagConstraints();
		gbc_correctLabel.gridx = 1;
		gbc_correctLabel.gridy = 6;
		quizPanel.add(correctLabel, gbc_correctLabel);
		quizObjects.addElement(correctLabel);

		JPanel slideButtonPanel = new JPanel();
		slideButtonPanel.setBounds(17, 473, 468, 27);
		contentPane.add(slideButtonPanel);
		GridBagLayout gbl_slideButtonPanel = new GridBagLayout();
		gbl_slideButtonPanel.columnWidths = new int[]{220, 28, 220};
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
		slideBackwardsButton.setAction(slideBackwards);

		slideForwardButton = new JButton(">");
		GridBagConstraints gbc_slideForwardButton = new GridBagConstraints();
		gbc_slideForwardButton.gridx = 2;
		gbc_slideForwardButton.gridy = 0;
		slideButtonPanel.add(slideForwardButton, gbc_slideForwardButton);
		slideForwardButton.setAction(slideForwards);
		
		for (JComponent jc : quizObjects) {
			jc.setVisible(false);
		}
	}

	private class SlideForwards extends AbstractAction {
		public SlideForwards() {
			putValue(NAME, ">");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("> pressed");
			// TODO UNCOMMENT THIS AFTER POPULATING
			/*
			System.out.println(lectureIndex);
			System.out.println(course.getCurrentLecture().getLinks().size() - 1);

			if (lectureIndex < course.getCurrentLecture().getLinks().size() - 1) {
				lectureIndex++;
				displayImage();
			}
			*/

			// TODO DELETE THIS AFTER POPULATING
			if (lectureIndex < urls.size() - 1) {
				lectureIndex++;
				displayImage();
			}


		}
	}

	private class SlideBackwards extends AbstractAction {
		public SlideBackwards() {
			putValue(NAME, "<");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("< pressed");
			// TODO UNCOMMENT THIS AFTER POPULATING
			/*
			System.out.println(lectureIndex);
			System.out.println(course.getCurrentLecture().getLinks().size() - 1);
			*/
			if (lectureIndex >= 1) {
				lectureIndex--;
				displayImage();
			}
		}
	}

	private class SendChatMessage extends AbstractAction {
		public SendChatMessage() {
			putValue(NAME, "Send");
			putValue(SHORT_DESCRIPTION, "Sends chat message");
		}
		public void actionPerformed(ActionEvent e) {
			String chatContent = chatTextBox.getText();
			String username = client.getUser().getUsername();
			ChatMessage chatMessage = new ChatMessage(chatContent, username, course);
			System.out.println("Sending the chat message...");
			System.out.println(username + ": " + chatContent);
			System.out.println("Chat has been sent");
			client.sendCommand(new Command(CommandType.SEND_CHAT_MESSAGE, chatMessage));
			
			
		}
	}
	
	private class CheckQuizAnswers extends AbstractAction {
		public CheckQuizAnswers() {
			putValue(NAME, "Check Quiz Answers");
			putValue(SHORT_DESCRIPTION, "Determines whether quiz answers are correct or incorrect");
		}
		public void actionPerformed(ActionEvent e) {
			Boolean correct = true;
			
			for (int i = 0; i < currQuiz.getChoices().size(); i++) {
				if (checkboxes.get(i).isSelected()) {
					if (!currQuiz.getAnswers().contains(i)) {
						correct = false;
						break;
					}
				} else {
					if (currQuiz.getAnswers().contains(i)) {
						correct = false;
						break;
					}
				}
			}
			
			if (correct) {
				correctLabel.setVisible(true);
				correctLabel.setText("CORRECT");
				correctLabel.setForeground(new java.awt.Color(0, 128, 0));
			} else {
				correctLabel.setVisible(true);
				correctLabel.setText("INCORRECT");
				correctLabel.setForeground(new java.awt.Color(128, 0, 0));
			}
		}
	}

	private void displayImage() {
		try {
			System.out.println("lectureIndex is: " + lectureIndex);
			// TODO change the urls in the following 2 lines:
			System.out.println("url is " + urls.get(lectureIndex));
			temp = new URL(urls.get(lectureIndex));
			image = ImageIO.read(temp);
			ImageIcon icon = new ImageIcon(image);
			slideImageLabel.setIcon(icon);
			slidePanel.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receiveChatMessage(ChatMessage cm)
	{
		if(cm.getCourse().equals(course)) {
			chatDefaultListModel.addElement(cm.getUsername() + ": " + cm.getMessage());
		}
	}
	
	public void updateQuiz(Quiz q) {
		if (q.equals(null)) {
			for (JComponent jc : quizObjects) {
				jc.setVisible(false);
			}
		} else {
			
			questionLabel.setText(q.getQuestion());
			int i;
			for (i = 0; i < q.getChoices().size(); i++) {
				checkboxes.get(i).setSelected(false);
				checkboxes.get(i).setText(q.getChoices().get(i));
			}
			
			for (JComponent jc : quizObjects) {
				if (!jc.equals(correctLabel)) {
					jc.setVisible(true);
				} else {
					jc.setVisible(false);
				}
			}
			
			for (int j = i; j < 5; j++) {
				checkboxes.get(j).setVisible(false);
			}
		}
	}
}
