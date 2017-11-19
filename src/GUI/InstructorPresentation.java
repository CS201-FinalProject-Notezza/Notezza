package GUI;

import java.awt.EventQueue;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class InstructorPresentation extends JFrame {

	private JPanel contentPane;
	private JTextField chatTextBox;
	private JPanel slidePanel;

	private NotezzaClient client;
	private Course course;

	private JLabel slideImageLabel;
	private URL temp;
	private BufferedImage image;

	private JButton slideBackwardsButton;
	private JButton slideForwardButton;
	private JButton sendChatButton;
	private final Action slideForwards = new SlideForwards();
	private final Action slideBackwards = new SlideBackwards();
	private final Action sendChatMessage = new SendChatMessage();
	private int lectureIndex;
	private Vector<String> urls;
	private final Action action = new NewPresentationClicked();
	//private final Action slideBackwards;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorPresentation frame = new InstructorPresentation(null, null);
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
	public InstructorPresentation(NotezzaClient client, Course course) {
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

		JList chatWindow = new JList();
		chatWindow.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		chatWindow.setBounds(500, 100, 272, 373);
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
		
		JComboBox questionBox = new JComboBox();
		questionBox.setBounds(500, 61, 271, 27);
		contentPane.add(questionBox);
		
		JButton newPresentationButton = new JButton("New Presentation");
		newPresentationButton.setAction(action);
		newPresentationButton.setText("New Presentation");
		newPresentationButton.setBounds(619, 20, 152, 29);
		contentPane.add(newPresentationButton);
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
	private class NewPresentationClicked extends AbstractAction {
		public NewPresentationClicked() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			NewPresentation newPresentation = new NewPresentation(client, course);
			newPresentation.setVisible(true);
		}
	}
}
