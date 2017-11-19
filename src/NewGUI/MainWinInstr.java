/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewGUI;

import NotezzaClient.NotezzaClient;
import objects.Course;
import objects.CourseList;
import objects.Note;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.*;

/**
 *
 * @author user
 */
public class MainWinInstr extends javax.swing.JFrame {
    private NotezzaClient client;
    private CourseList courseList;
    private Course currentCourse;
    private Note currentNote;
    /**
     * Creates new form MainWin
     */
    public MainWinInstr(NotezzaClient client, CourseList courseList) {
        this.client = client;
        this.courseList = courseList;
//        Vector<Course> courses = courseList.getCourses();
//        if (courses != null && courses.size() > 0) {
//            currentCourse = courses.get(0);
//            if (currentCourse.getAllNotes().size() > 0) {
//                currentNote = currentCourse.getAllNotes().get(0);
//            } else {
//                currentNote = null;
//            }
//        } else {
//            currentCourse = null;
//            currentNote = null;
//        }
        initComponents();
        initContents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        functionBar = new javax.swing.JPanel();
        sortChoiceBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchNote = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        homeLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lecture = new javax.swing.JLabel();
        addClass = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        viewMember = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OverviewList = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        layer2 = new javax.swing.JPanel();
        PostScroll = new javax.swing.JScrollPane();
        Post = new javax.swing.JTextPane();
        layer1 = new javax.swing.JPanel();
        likeButton = new javax.swing.JButton();
        dislikeButton = new javax.swing.JButton();
        CommentScroll = new javax.swing.JScrollPane();
        Comments = new javax.swing.JTextPane();
        writeCommentPanel = new javax.swing.JPanel();
        CreateComment = new javax.swing.JTextField();
        PostComment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        functionBar.setBackground(new java.awt.Color(114, 137, 218));

        sortChoiceBox.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        sortChoiceBox.setForeground(new java.awt.Color(42, 77, 105));
        sortChoiceBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Latest Date", "Highest Rating", "Most Number of Comments", "Most Number of Likes" }));
        sortChoiceBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortChoiceBoxItemStateChanged(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sort Posts By:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/search-20.png"))); // NOI18N

        searchNote.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        searchNote.setForeground(new java.awt.Color(42, 77, 105));
        searchNote.setText("Search Notes");
        searchNote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(42, 77, 105), 1, true));
        searchNote.setCaretColor(new java.awt.Color(42, 77, 105));
        searchNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchNoteMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(42, 77, 105));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/plus-17-dark.png"))); // NOI18N
        jButton1.setText("Add New Post");

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        homeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/home-20.png"))); // NOI18N
        homeLabel.setToolTipText("Change Class");

//        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CS201" }));
//        jComboBox1.setToolTipText("Change Class");

        javax.swing.GroupLayout functionBarLayout = new javax.swing.GroupLayout(functionBar);
        functionBar.setLayout(functionBarLayout);
        functionBarLayout.setHorizontalGroup(
            functionBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionBarLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(homeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchNote, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortChoiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        functionBarLayout.setVerticalGroup(
            functionBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(functionBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(homeLabel)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4)
                    .addComponent(jLabel3)
                    .addComponent(searchNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(sortChoiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2)
                    .addComponent(jButton1))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(59, 89, 152));

        jLabel1.setBackground(new java.awt.Color(144, 201, 229));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(231, 239, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOTEZZA");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/logo50.png"))); // NOI18N

        lecture.setBackground(new java.awt.Color(59, 89, 152));
        lecture.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        lecture.setForeground(new java.awt.Color(231, 239, 246));
        lecture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecture.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/lecture-20.png"))); // NOI18N
        lecture.setText("Enter Lecture");
        lecture.setToolTipText("");
        lecture.setOpaque(true);
        lecture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lectureMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lectureMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lectureMouseEntered(evt);
            }
        });

        addClass.setBackground(new java.awt.Color(59, 89, 152));
        addClass.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        addClass.setForeground(new java.awt.Color(231, 239, 246));
        addClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/plus-20.png"))); // NOI18N
        addClass.setText(" Create Class");
        addClass.setToolTipText("");
        addClass.setOpaque(true);
        addClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addClassMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addClassMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addClassMouseEntered(evt);
            }
        });

        logout.setBackground(new java.awt.Color(59, 89, 152));
        logout.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        logout.setForeground(new java.awt.Color(231, 239, 246));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/exit-20.png"))); // NOI18N
        logout.setText("Log Out");
        logout.setToolTipText("");
        logout.setOpaque(true);
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
        });

        profile.setBackground(new java.awt.Color(59, 89, 152));
        profile.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        profile.setForeground(new java.awt.Color(231, 239, 246));
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/profile-20.png"))); // NOI18N
        profile.setText(" Profile");
        profile.setToolTipText("");
        profile.setOpaque(true);
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileMouseEntered(evt);
            }
        });

        viewMember.setBackground(new java.awt.Color(59, 89, 152));
        viewMember.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        viewMember.setForeground(new java.awt.Color(231, 239, 246));
        viewMember.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/viewMember-20.png"))); // NOI18N
        viewMember.setText(" Find Students");
        viewMember.setToolTipText("");
        viewMember.setOpaque(true);
        viewMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMemberMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewMemberMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewMemberMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(logo)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lecture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewMember, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(addClass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lecture, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewMember, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel5.setBackground(new java.awt.Color(231, 239, 246));

//        OverviewList.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
        OverviewList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        OverviewList.setCellRenderer(getCellRenderer());
        OverviewList.setSelectionBackground(new java.awt.Color(223, 227, 238));
        OverviewList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(OverviewList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel6.setBackground(new java.awt.Color(231, 239, 246));

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLayeredPane1.setOpaque(true);

        PostScroll.setBorder(null);

        Post.setEditable(false);
        Post.setContentType("text/html"); // NOI18N
        PostScroll.setViewportView(Post);

        javax.swing.GroupLayout layer2Layout = new javax.swing.GroupLayout(layer2);
        layer2.setLayout(layer2Layout);
        layer2Layout.setHorizontalGroup(
            layer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
            .addGroup(layer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PostScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
        );
        layer2Layout.setVerticalGroup(
            layer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
            .addGroup(layer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PostScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        layer1.setOpaque(false);

        likeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/like-22.png"))); // NOI18N
        likeButton.setText("63");

        dislikeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/dislike-22.png"))); // NOI18N
        dislikeButton.setText("63");

        javax.swing.GroupLayout layer1Layout = new javax.swing.GroupLayout(layer1);
        layer1.setLayout(layer1Layout);
        layer1Layout.setHorizontalGroup(
            layer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layer1Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(likeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dislikeButton)
                .addGap(14, 14, 14))
        );
        layer1Layout.setVerticalGroup(
            layer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layer1Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(layer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(likeButton)
                    .addComponent(dislikeButton))
                .addContainerGap())
        );

        jLayeredPane1.setLayer(layer2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(layer1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(layer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(layer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 51, Short.MAX_VALUE)))
        );

        Comments.setEditable(false);
        Comments.setContentType("text/html"); // NOI18N
        CommentScroll.setViewportView(Comments);

        writeCommentPanel.setBackground(new java.awt.Color(231, 239, 246));

        CreateComment.setToolTipText("Add Comment");
        CreateComment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        CreateComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateCommentActionPerformed(evt);
            }
        });

        PostComment.setText("Post");
        PostComment.setToolTipText("");
        PostComment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PostCommentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout writeCommentPanelLayout = new javax.swing.GroupLayout(writeCommentPanel);
        writeCommentPanel.setLayout(writeCommentPanelLayout);
        writeCommentPanelLayout.setHorizontalGroup(
            writeCommentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeCommentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CreateComment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PostComment, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        writeCommentPanelLayout.setVerticalGroup(
            writeCommentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeCommentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(writeCommentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(writeCommentPanelLayout.createSequentialGroup()
                        .addComponent(PostComment)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(CreateComment))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addComponent(CommentScroll)
            .addComponent(writeCommentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CommentScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(writeCommentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(functionBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(functionBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>  
    
    
    private void initContents() {
    		List<String> overviewList = new ArrayList<String>();
    		Vector<Course> courses;
		if (courseList == null || courseList.getCourses() == null || courseList.getCourses().isEmpty()) {
			// No course available
			
			// classes dropdown box
			jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String [] {"No Classes"}));
			jComboBox1.setToolTipText("Change Class");
			// Posts Overview
			OverviewList.setModel(new javax.swing.AbstractListModel<String>() {
    				String[] strings = { "<html><h3>No Posts Available<h3><html>" };
    				public int getSize() { return strings.length; }
    				public String getElementAt(int i) { return strings[i]; }
    			});
			
			// Post Content
			
			return;
		}
		courses = courseList.getCourses();
		// classes dropdown box
		DefaultComboBoxModel dropDownModel = new DefaultComboBoxModel();
		for (Course course : courses) {
			dropDownModel.addElement(course.getCourseName());
		}
		jComboBox1.setModel(dropDownModel);
		jComboBox1.setToolTipText("Change Class");
		
		// Posts
		Course currentCourse = courses.get(1); 
		Vector<Note> notes = currentCourse.getAllNotes();
		DefaultListModel<String> notesOverviewModel = new DefaultListModel<String>();
		for (Note note : notes) {
			notesOverviewModel.addElement(Util.getHTMLforNoteOverview(note));
		}
		
		OverviewList.setModel(notesOverviewModel);
		
		// Post Content
		//Post.setText("<html><h2><font face=\"Century Gothic\">You haven't select a post yet.</font></h2></html>");
		
		
		
    }

    private void addClassMouseEntered(java.awt.event.MouseEvent evt) {                                      
        addClass.setBackground(new Color(139,157,195));
    }                                     

    private void lectureMouseEntered(java.awt.event.MouseEvent evt) {                                     
        lecture.setBackground(new Color(139,157,195));
    }                                    

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {                                    
        logout.setBackground(new Color(139,157,195));
    }                                   

    private void addClassMouseExited(java.awt.event.MouseEvent evt) {                                     
        addClass.setBackground(new Color(59,89,152));
    }                                    

    private void lectureMouseExited(java.awt.event.MouseEvent evt) {                                    
        lecture.setBackground(new Color(59,89,152));
    }                                   

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {                                   
        logout.setBackground(new Color(59,89,152));
    }                                  

    private void addClassMouseClicked(java.awt.event.MouseEvent evt) {                                      
        
    }                                     

    private void lectureMouseClicked(java.awt.event.MouseEvent evt) {                                     
        
    }                                    

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {                                    
        
    }                                   

    private void searchNoteMouseClicked(java.awt.event.MouseEvent evt) {                                        
        searchNote.setText("");
    }                                       

    private void sortChoiceBoxItemStateChanged(java.awt.event.ItemEvent evt) {                                               
        
    }                                              

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {                                     
        
    }                                    

    private void profileMouseExited(java.awt.event.MouseEvent evt) {                                    
        profile.setBackground(new Color(59,89,152));
    }                                   

    private void profileMouseEntered(java.awt.event.MouseEvent evt) {                                     
        profile.setBackground(new Color(139,157,195));
    }                                    

    private void viewMemberMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void viewMemberMouseExited(java.awt.event.MouseEvent evt) {                                       
        viewMember.setBackground(new Color(59,89,152));
    }                                      

    private void viewMemberMouseEntered(java.awt.event.MouseEvent evt) {                                        
        viewMember.setBackground(new Color(139,157,195));
    }                                       

    private void CreateCommentActionPerformed(java.awt.event.ActionEvent evt) {                                              

    }                                             

    private void PostCommentMouseClicked(java.awt.event.MouseEvent evt) {                                         

    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWinInstr(null,null).setVisible(true);
            }
        });
    }
    
    private ListCellRenderer<? super String> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                JLabel cellRenderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
                cellRenderer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
                return cellRenderer;
            }
        };
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane CommentScroll;
    private javax.swing.JTextPane Comments;
    private javax.swing.JTextField CreateComment;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel Menu;
    private javax.swing.JList<String> OverviewList;
    private javax.swing.JTextPane Post;
    private javax.swing.JButton PostComment;
    private javax.swing.JScrollPane PostScroll;
    private javax.swing.JLabel addClass;
    private javax.swing.JButton dislikeButton;
    private javax.swing.JPanel functionBar;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel layer1;
    private javax.swing.JPanel layer2;
    private javax.swing.JLabel lecture;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel profile;
    private javax.swing.JTextField searchNote;
    private javax.swing.JComboBox<String> sortChoiceBox;
    private javax.swing.JLabel viewMember;
    private javax.swing.JPanel writeCommentPanel;
    // End of variables declaration                   
}
