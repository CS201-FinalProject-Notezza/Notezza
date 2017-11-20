package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.Course;
import objects.Presentation;
import objects.PresentationANDCourse;
import objects.Quiz;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class NewPresentation extends JFrame {

	private JPanel contentPane;
	private JLabel lblEnterLinksTo;
	private JTextPane linkText;
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

	private NotezzaClient client;
	private Course course;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JSeparator separator_12;
	private JSeparator separator_13;
	private JSeparator separator_14;
	private JSeparator separator_15;
	private JSeparator separator_16;
	private JSeparator separator_17;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPresentation frame = new NewPresentation(null, null);
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

		this.client = client;
		this.course = course;
		setBounds(100, 100, 400, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new java.awt.Color(52, 61, 70));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEnterLinksTo = new JLabel("Enter links to slides (separated by commas):");
		lblEnterLinksTo.setBounds(15, 15, 368, 16);
		lblEnterLinksTo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEnterLinksTo.setForeground(new java.awt.Color(204, 204, 204));
		lblEnterLinksTo.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblEnterLinksTo);

		linkText = new JTextPane();
		linkText.setBounds(15, 43, 368, 85);
		linkText.setBackground(new java.awt.Color(204, 204, 204));
		linkText.setForeground(new java.awt.Color(52, 61, 70));
		linkText.setBorder(null);
		linkText.setCaretColor(new java.awt.Color(52, 61, 70));
		contentPane.add(linkText);

		q1Label = new JLabel("Question 1: ");
		q1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Label.setFont(new Font("Dialog", Font.BOLD, 13));
		q1Label.setForeground(new java.awt.Color(204, 204, 204));
		q1Label.setBounds(6, 136, 86, 16);
		contentPane.add(q1Label);

		q1Choice1Label = new JLabel("Choice 1: ");
		q1Choice1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q1Choice1Label.setForeground(new java.awt.Color(204, 204, 204));
		q1Choice1Label.setBounds(15, 164, 77, 16);
		contentPane.add(q1Choice1Label);

		q1c1Check = new JCheckBox("");
		q1c1Check.setBounds(355, 157, 28, 29);
		contentPane.add(q1c1Check);

		q1Choice2Label = new JLabel("Choice 2: ");
		q1Choice2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q1Choice2Label.setForeground(new java.awt.Color(204, 204, 204));
		q1Choice2Label.setBounds(15, 186, 77, 16);
		contentPane.add(q1Choice2Label);

		q1c2Check = new JCheckBox("");
		q1c2Check.setBounds(355, 179, 28, 29);
		contentPane.add(q1c2Check);

		q1Choice3Label = new JLabel("Choice 3: ");
		q1Choice3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q1Choice3Label.setForeground(new java.awt.Color(204, 204, 204));
		q1Choice3Label.setBounds(15, 208, 77, 16);
		contentPane.add(q1Choice3Label);

		q1c3Check = new JCheckBox("");
		q1c3Check.setBounds(355, 201, 28, 29);
		contentPane.add(q1c3Check);

		q1Choice4Label = new JLabel("Choice 4: ");
		q1Choice4Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice4Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q1Choice4Label.setForeground(new java.awt.Color(204, 204, 204));
		q1Choice4Label.setBounds(15, 230, 77, 16);
		contentPane.add(q1Choice4Label);

		q1c4Check = new JCheckBox("");
		q1c4Check.setBounds(355, 223, 28, 29);
		contentPane.add(q1c4Check);

		q1Choice5Label = new JLabel("Choice 5: ");
		q1Choice5Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q1Choice5Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q1Choice5Label.setForeground(new java.awt.Color(204, 204, 204));
		q1Choice5Label.setBounds(15, 252, 77, 16);
		contentPane.add(q1Choice5Label);

		q1c5Check = new JCheckBox("");
		q1c5Check.setBounds(355, 245, 28, 29);
		contentPane.add(q1c5Check);

		q2Label = new JLabel("Question 2: ");
		q2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Label.setFont(new Font("Dialog", Font.BOLD, 13));
		q2Label.setForeground(new java.awt.Color(204, 204, 204));
		q2Label.setBounds(6, 279, 86, 16);
		contentPane.add(q2Label);

		q2Choice1Label = new JLabel("Choice 1: ");
		q2Choice1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q2Choice1Label.setForeground(new java.awt.Color(204, 204, 204));
		q2Choice1Label.setBounds(15, 307, 77, 16);
		contentPane.add(q2Choice1Label);

		q2c1Check = new JCheckBox("");
		q2c1Check.setBounds(355, 300, 28, 29);
		contentPane.add(q2c1Check);

		q2Choice2Label = new JLabel("Choice 2: ");
		q2Choice2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q2Choice2Label.setForeground(new java.awt.Color(204, 204, 204));
		q2Choice2Label.setBounds(15, 329, 77, 16);
		contentPane.add(q2Choice2Label);

		q2c2Check = new JCheckBox("");
		q2c2Check.setBounds(355, 322, 28, 29);
		contentPane.add(q2c2Check);

		q2Choice3Label = new JLabel("Choice 3: ");
		q2Choice3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q2Choice3Label.setForeground(new java.awt.Color(204, 204, 204));
		q2Choice3Label.setBounds(15, 351, 77, 16);
		contentPane.add(q2Choice3Label);

		q2c3Check = new JCheckBox("");
		q2c3Check.setBounds(355, 344, 28, 29);
		contentPane.add(q2c3Check);

		q2Choice4Label = new JLabel("Choice 4: ");
		q2Choice4Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice4Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q2Choice4Label.setForeground(new java.awt.Color(204, 204, 204));
		q2Choice4Label.setBounds(15, 373, 77, 16);
		contentPane.add(q2Choice4Label);

		q2c4Check = new JCheckBox("");
		q2c4Check.setBounds(355, 366, 28, 29);
		contentPane.add(q2c4Check);

		q2Choice5Label = new JLabel("Choice 5: ");
		q2Choice5Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q2Choice5Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q2Choice5Label.setForeground(new java.awt.Color(204, 204, 204));
		q2Choice5Label.setBounds(15, 395, 77, 16);
		contentPane.add(q2Choice5Label);

		q2c5Check = new JCheckBox("");
		q2c5Check.setBounds(355, 388, 28, 29);
		contentPane.add(q2c5Check);

		q3Label = new JLabel("Question 3: ");
		q3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Label.setFont(new Font("Dialog", Font.BOLD, 13));
		q3Label.setForeground(new java.awt.Color(204, 204, 204));
		q3Label.setBounds(6, 423, 86, 16);
		contentPane.add(q3Label);

		q3Choice1Label = new JLabel("Choice 1: ");
		q3Choice1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice1Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q3Choice1Label.setForeground(new java.awt.Color(204, 204, 204));
		q3Choice1Label.setBounds(15, 451, 77, 16);
		contentPane.add(q3Choice1Label);

		q3c1Check = new JCheckBox("");
		q3c1Check.setBounds(355, 444, 28, 29);
		contentPane.add(q3c1Check);

		q3Choice2Label = new JLabel("Choice 2: ");
		q3Choice2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice2Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q3Choice2Label.setForeground(new java.awt.Color(204, 204, 204));
		q3Choice2Label.setBounds(15, 473, 77, 16);
		contentPane.add(q3Choice2Label);

		q3c2Check = new JCheckBox("");
		q3c2Check.setBounds(355, 466, 28, 29);
		contentPane.add(q3c2Check);

		q3Choice3Label = new JLabel("Choice 3: ");
		q3Choice3Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice3Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q3Choice3Label.setForeground(new java.awt.Color(204, 204, 204));
		q3Choice3Label.setBounds(15, 495, 77, 16);
		contentPane.add(q3Choice3Label);

		q3c3Check = new JCheckBox("");
		q3c3Check.setBounds(355, 488, 28, 29);
		contentPane.add(q3c3Check);

		q3Choice4Label = new JLabel("Choice 4: ");
		q3Choice4Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice4Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q3Choice4Label.setForeground(new java.awt.Color(204, 204, 204));
		q3Choice4Label.setBounds(15, 517, 77, 16);
		contentPane.add(q3Choice4Label);

		q3c4Check = new JCheckBox("");
		q3c4Check.setBounds(355, 510, 28, 29);
		contentPane.add(q3c4Check);

		q3Choice5Label = new JLabel("Choice 5: ");
		q3Choice5Label.setHorizontalAlignment(SwingConstants.RIGHT);
		q3Choice5Label.setFont(new Font("Dialog", Font.BOLD, 12));
		q3Choice5Label.setForeground(new java.awt.Color(204, 204, 204));
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
		
		separator = new JSeparator();
		separator.setBounds(16, 150, 368, 16);
		contentPane.add(separator);
		
		q1Text = new JTextField();
		q1Text.setBounds(94, 131, 290, 26);
		q1Text.setForeground(new Color(204, 204, 204));
		q1Text.setCaretColor(new Color(204, 204, 204));
		q1Text.setBackground(new Color(52, 61, 70));
		q1Text.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(q1Text);
		q1Text.setColumns(10);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(16, 293, 368, 16);
		contentPane.add(separator_1);
																																								
		separator_2 = new JSeparator();
		separator_2.setBounds(16, 437, 368, 16);
		contentPane.add(separator_2);
																																								
		q3Text = new JTextField();
		q3Text.setColumns(10);
		q3Text.setBounds(94, 418, 290, 26);
		q3Text.setForeground(new Color(204, 204, 204));
		q3Text.setCaretColor(new Color(204, 204, 204));
		q3Text.setBackground(new Color(52, 61, 70));
		q3Text.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(q3Text);
																																										
		separator_3 = new JSeparator();
		separator_3.setBounds(94, 176, 261, 16);
		contentPane.add(separator_3);
																																										
		q1Choice1Text = new JTextField();
		q1Choice1Text.setColumns(10);
		q1Choice1Text.setBounds(94, 159, 261, 26);
		q1Choice1Text.setForeground(new Color(204, 204, 204));
		q1Choice1Text.setCaretColor(new Color(204, 204, 204));
		q1Choice1Text.setBackground(new Color(52, 61, 70));
		q1Choice1Text.setBorder(null);
		contentPane.add(q1Choice1Text);
																																														
		separator_4 = new JSeparator();
		separator_4.setBounds(94, 198, 261, 16);
		contentPane.add(separator_4);
																																																
		q1Choice2Text = new JTextField();
		q1Choice2Text.setColumns(10);
		q1Choice2Text.setBounds(94, 181, 261, 26);
		q1Choice2Text.setForeground(new Color(204, 204, 204));
		q1Choice2Text.setCaretColor(new Color(204, 204, 204));
		q1Choice2Text.setBackground(new Color(52, 61, 70));
		q1Choice2Text.setBorder(null);
		contentPane.add(q1Choice2Text);
																																																		
		separator_5 = new JSeparator();
		separator_5.setBounds(94, 220, 261, 16);
		contentPane.add(separator_5);
																																																		
		q1Choice3Text = new JTextField();
		q1Choice3Text.setColumns(10);
		q1Choice3Text.setBounds(94, 203, 261, 26);
		q1Choice3Text.setForeground(new Color(204, 204, 204));
		q1Choice3Text.setCaretColor(new Color(204, 204, 204));
		q1Choice3Text.setBackground(new Color(52, 61, 70));
		q1Choice3Text.setBorder(null);
		contentPane.add(q1Choice3Text);
																																																								
		separator_6 = new JSeparator();
		separator_6.setBounds(94, 242, 261, 16);
		contentPane.add(separator_6);
																																																								
		q1Choice4Text = new JTextField();
		q1Choice4Text.setColumns(10);
		q1Choice4Text.setBounds(94, 225, 261, 26);
		q1Choice4Text.setForeground(new Color(204, 204, 204));
		q1Choice4Text.setCaretColor(new Color(204, 204, 204));
		q1Choice4Text.setBackground(new Color(52, 61, 70));
		q1Choice4Text.setBorder(null);
		contentPane.add(q1Choice4Text);

		separator_7 = new JSeparator();
		separator_7.setBounds(94, 264, 261, 16);
		contentPane.add(separator_7);

		q2Text = new JTextField();
		q2Text.setColumns(10);
		q2Text.setBounds(94, 274, 290, 26);
		q2Text.setForeground(new Color(204, 204, 204));
		q2Text.setCaretColor(new Color(204, 204, 204));
		q2Text.setBackground(new Color(52, 61, 70));
		q2Text.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(q2Text);

		q1Choice5Text = new JTextField();
		q1Choice5Text.setColumns(10);
		q1Choice5Text.setBounds(94, 247, 261, 26);
		q1Choice5Text.setForeground(new Color(204, 204, 204));
		q1Choice5Text.setCaretColor(new Color(204, 204, 204));
		q1Choice5Text.setBackground(new Color(52, 61, 70));
		q1Choice5Text.setBorder(null);
		contentPane.add(q1Choice5Text);

		separator_8 = new JSeparator();
		separator_8.setBounds(94, 319, 261, 16);
		contentPane.add(separator_8);

		separator_9 = new JSeparator();
		separator_9.setBounds(94, 341, 261, 16);
		contentPane.add(separator_9);

		separator_10 = new JSeparator();
		separator_10.setBounds(94, 363, 261, 16);
		contentPane.add(separator_10);

		separator_11 = new JSeparator();
		separator_11.setBounds(94, 385, 261, 16);
		contentPane.add(separator_11);

		q2Choice1Text = new JTextField();
		q2Choice1Text.setColumns(10);
		q2Choice1Text.setBounds(94, 302, 261, 26);
		q2Choice1Text.setForeground(new Color(204, 204, 204));
		q2Choice1Text.setCaretColor(new Color(204, 204, 204));
		q2Choice1Text.setBackground(new Color(52, 61, 70));
		q2Choice1Text.setBorder(null);
		contentPane.add(q2Choice1Text);

		q2Choice2Text = new JTextField();
		q2Choice2Text.setColumns(10);
		q2Choice2Text.setBounds(94, 324, 261, 26);
		q2Choice2Text.setForeground(new Color(204, 204, 204));
		q2Choice2Text.setCaretColor(new Color(204, 204, 204));
		q2Choice2Text.setBackground(new Color(52, 61, 70));
		q2Choice2Text.setBorder(null);
		contentPane.add(q2Choice2Text);

		q2Choice3Text = new JTextField();
		q2Choice3Text.setColumns(10);
		q2Choice3Text.setBounds(94, 346, 261, 26);
		q2Choice3Text.setForeground(new Color(204, 204, 204));
		q2Choice3Text.setCaretColor(new Color(204, 204, 204));
		q2Choice3Text.setBackground(new Color(52, 61, 70));
		q2Choice3Text.setBorder(null);
		contentPane.add(q2Choice3Text);

		separator_12 = new JSeparator();
		separator_12.setBounds(94, 407, 261, 16);
		contentPane.add(separator_12);

		q2Choice4Text = new JTextField();
		q2Choice4Text.setColumns(10);
		q2Choice4Text.setBounds(94, 368, 261, 26);
		q2Choice4Text.setForeground(new Color(204, 204, 204));
		q2Choice4Text.setCaretColor(new Color(204, 204, 204));
		q2Choice4Text.setBackground(new Color(52, 61, 70));
		q2Choice4Text.setBorder(null);
		contentPane.add(q2Choice4Text);

		q2Choice5Text = new JTextField();
		q2Choice5Text.setColumns(10);
		q2Choice5Text.setBounds(94, 390, 261, 26);
		q2Choice5Text.setForeground(new Color(204, 204, 204));
		q2Choice5Text.setCaretColor(new Color(204, 204, 204));
		q2Choice5Text.setBackground(new Color(52, 61, 70));
		q2Choice5Text.setBorder(null);
		contentPane.add(q2Choice5Text);

		separator_13 = new JSeparator();
		separator_13.setBounds(94, 463, 261, 16);
		contentPane.add(separator_13);

		separator_14 = new JSeparator();
		separator_14.setBounds(94, 485, 261, 16);
		contentPane.add(separator_14);

		separator_15 = new JSeparator();
		separator_15.setBounds(94, 507, 261, 16);
		contentPane.add(separator_15);

		separator_16 = new JSeparator();
		separator_16.setBounds(94, 529, 261, 16);
		contentPane.add(separator_16);

		separator_17 = new JSeparator();
		separator_17.setBounds(94, 551, 261, 16);
		contentPane.add(separator_17);

		q3Choice1Text = new JTextField();
		q3Choice1Text.setColumns(10);
		q3Choice1Text.setBounds(94, 446, 261, 26);
		q3Choice1Text.setForeground(new Color(204, 204, 204));
		q3Choice1Text.setCaretColor(new Color(204, 204, 204));
		q3Choice1Text.setBackground(new Color(52, 61, 70));
		q3Choice1Text.setBorder(null);
		contentPane.add(q3Choice1Text);

		q3Choice2Text = new JTextField();
		q3Choice2Text.setColumns(10);
		q3Choice2Text.setBounds(94, 468, 261, 26);
		q3Choice2Text.setForeground(new Color(204, 204, 204));
		q3Choice2Text.setCaretColor(new Color(204, 204, 204));
		q3Choice2Text.setBackground(new Color(52, 61, 70));
		q3Choice2Text.setBorder(null);
		contentPane.add(q3Choice2Text);

		q3Choice3Text = new JTextField();
		q3Choice3Text.setColumns(10);
		q3Choice3Text.setBounds(94, 490, 261, 26);
		q3Choice3Text.setForeground(new Color(204, 204, 204));
		q3Choice3Text.setCaretColor(new Color(204, 204, 204));
		q3Choice3Text.setBackground(new Color(52, 61, 70));
		q3Choice3Text.setBorder(null);
		contentPane.add(q3Choice3Text);

		q3Choice4Text = new JTextField();
		q3Choice4Text.setColumns(10);
		q3Choice4Text.setBounds(94, 512, 261, 26);
		q3Choice4Text.setForeground(new Color(204, 204, 204));
		q3Choice4Text.setCaretColor(new Color(204, 204, 204));
		q3Choice4Text.setBackground(new Color(52, 61, 70));
		q3Choice4Text.setBorder(null);
		contentPane.add(q3Choice4Text);

		q3Choice5Text = new JTextField();
		q3Choice5Text.setColumns(10);
		q3Choice5Text.setBounds(94, 534, 261, 26);
		q3Choice5Text.setForeground(new Color(204, 204, 204));
		q3Choice5Text.setCaretColor(new Color(204, 204, 204));
		q3Choice5Text.setBackground(new Color(52, 61, 70));
		q3Choice5Text.setBorder(null);
		contentPane.add(q3Choice5Text);
	}

	private class AddNewPresentation extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			// Get all the text value;
			String allLinksStr = linkText.getText();
			String[] linksArray = allLinksStr.split(",");
			Vector<String> links = new Vector<String>(Arrays.asList(linksArray));
			// Show error if no links entered
			if (links.size() == 1 && links.get(0).equals("")) {
				JOptionPane.showMessageDialog(contentPane, "ERROR: There must be at least one slide link!", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String q1Name = q1Text.getText();
			String q2Name = q2Text.getText();
			String q3Name = q3Text.getText();

			String[] quizArrays1 = {q1Choice1Text.getText(), q1Choice2Text.getText(), q1Choice3Text.getText(),
					q1Choice4Text.getText(), q1Choice5Text.getText()};
			String[] quizArrays2 = {q2Choice1Text.getText(), q2Choice2Text.getText(), q2Choice3Text.getText(),
					q2Choice4Text.getText(), q2Choice5Text.getText()};
			String[] quizArrays3 = {q3Choice1Text.getText(), q3Choice2Text.getText(), q3Choice3Text.getText(),
					q3Choice4Text.getText(), q3Choice5Text.getText()};
			Map<Integer,String[]> numberToQuizTextArrays = new HashMap<>();
			numberToQuizTextArrays.put(1,quizArrays1);
			numberToQuizTextArrays.put(2,quizArrays2);
			numberToQuizTextArrays.put(3,quizArrays3);

			JCheckBox[] checkBoxes1 = {q1c1Check, q1c2Check, q1c3Check, q1c4Check, q1c5Check};
			JCheckBox[] checkBoxes2 = {q2c1Check, q2c2Check, q2c3Check, q2c4Check, q2c5Check};
			JCheckBox[] checkBoxes3 = {q3c1Check, q3c2Check, q3c3Check, q3c4Check, q3c5Check};
			Map<Integer,JCheckBox[] > numberToCheckBoxes = new HashMap<>();
			numberToCheckBoxes.put(1,checkBoxes1);
			numberToCheckBoxes.put(2,checkBoxes2);
			numberToCheckBoxes.put(3,checkBoxes3);

			Quiz quiz1 = createQuiz(q1Name, numberToQuizTextArrays.get(1),numberToCheckBoxes.get(1));
			Quiz quiz2 = createQuiz(q2Name, numberToQuizTextArrays.get(2),numberToCheckBoxes.get(2));
			Quiz quiz3  = createQuiz(q3Name, numberToQuizTextArrays.get(3),numberToCheckBoxes.get(3));

			Vector<Quiz> quizzes = new Vector<>();
			if (quiz1 != null) {
				quizzes.add(quiz1);
			}
			if (quiz2 != null) {
				quizzes.add(quiz2);
			}
			if (quiz3 != null) {
				quizzes.add(quiz3);
			}

			Presentation presentation = new Presentation(links, quizzes);
			// send to server
			PresentationANDCourse pc = new PresentationANDCourse(presentation,course);
			client.sendCommand(new Command(CommandType.CREATE_PRESENTATION, pc));
			setVisible(false);
		}

		private Quiz createQuiz(String name, String[] quizArray,JCheckBox[] checkBoxes) {
			// A quiz is created only when the title is not empty and has at least one choices
			if (!name.isEmpty()) {
				Vector<String> choices = new Vector<>();
				Set<Integer> correctAnswer = new HashSet<>();
				for (int i = 0; i < quizArray.length; i++) {
					if (!quizArray[i].isEmpty()) {
						choices.add(quizArray[i]);
						if (checkBoxes[i].isSelected()) {
							correctAnswer.add(choices.indexOf(quizArray[i]));
						}
					}
				}
				if (choices.size() >= 1) {
					// create the quiz otherwise set to null;
					return new Quiz(name, choices, correctAnswer);
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
	}
}
