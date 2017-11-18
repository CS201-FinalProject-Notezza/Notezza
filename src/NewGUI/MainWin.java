package NewGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author user
 */
public class MainWin extends javax.swing.JFrame {

	Path path;
	String currentRelativePath;
    /**
     * Creates new form MainWin
     */
    public MainWin() {
    		path = Paths.get("");
    		currentRelativePath = path.toAbsolutePath().toString();	
    		System.out.println(currentRelativePath);
        initComponents();
        //OverviewList.setCellRender(getCellRenderer());
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
        jPanel1 = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lecture = new javax.swing.JLabel();
        addClass = new javax.swing.JLabel();
        changeClass = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        viewMember = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OverviewList = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        PostContent = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        functionBar.setBackground(new java.awt.Color(99, 172, 229));

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
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/plus-17-dark.png"))); // NOI18N
        jButton1.setText("Add New Post");

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout functionBarLayout = new javax.swing.GroupLayout(functionBar);
        functionBar.setLayout(functionBarLayout);
        functionBarLayout.setHorizontalGroup(
            functionBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(searchNote, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortChoiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        functionBarLayout.setVerticalGroup(
            functionBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(functionBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(sortChoiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jButton1)
                    .addComponent(jSeparator4)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        Menu.setBackground(new java.awt.Color(75, 134, 180));

        jLabel1.setBackground(new java.awt.Color(144, 201, 229));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(231, 239, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOTEZZA");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/logo50.png"))); // NOI18N

        jSeparator3.setForeground(null);

        lecture.setBackground(new java.awt.Color(75, 134, 180));
        lecture.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        lecture.setForeground(new java.awt.Color(231, 239, 246));
        lecture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecture.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/lecture-20.png"))); // NOI18N
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

        addClass.setBackground(new java.awt.Color(75, 134, 180));
        addClass.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        addClass.setForeground(new java.awt.Color(231, 239, 246));
        addClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addClass.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/plus-20.png"))); // NOI18N
        addClass.setText(" Add Class");
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

        changeClass.setBackground(new java.awt.Color(75, 134, 180));
        changeClass.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        changeClass.setForeground(new java.awt.Color(231, 239, 246));
        changeClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changeClass.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/home-20.png"))); // NOI18N
        changeClass.setText(" Your Classes");
        changeClass.setToolTipText("");
        changeClass.setOpaque(true);
        changeClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeClassMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeClassMouseEntered(evt);
            }
        });

        logout.setBackground(new java.awt.Color(75, 134, 180));
        logout.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        logout.setForeground(new java.awt.Color(231, 239, 246));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/exit-20.png"))); // NOI18N
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

        profile.setBackground(new java.awt.Color(75, 134, 180));
        profile.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        profile.setForeground(new java.awt.Color(231, 239, 246));
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/profile-20.png"))); // NOI18N
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

        viewMember.setBackground(new java.awt.Color(75, 134, 180));
        viewMember.setFont(new java.awt.Font("Eurostile", 1, 17)); // NOI18N
        viewMember.setForeground(new java.awt.Color(231, 239, 246));
        viewMember.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewMember.setIcon(new javax.swing.ImageIcon(getClass().getResource( "img/viewMember-20.png"))); // NOI18N
        viewMember.setText(" Find Classmates");
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
                    .addComponent(changeClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeClass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel5.setBackground(new java.awt.Color(231, 239, 246));

        OverviewList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        OverviewList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        OverviewList.setCellRenderer(getCellRenderer());
        OverviewList.setSelectionBackground(new java.awt.Color(173, 203, 227));
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
        jPanel6.setLayout(new java.awt.BorderLayout());

        PostContent.setEditable(false);
        PostContent.setContentType("text/html"); // NOI18N
        PostContent.setText("\n<html>\n  <head>\n    <title>USC: CSCI 201L Fall 2017</title>\n\n  </head>\n  <body text=\"#333333\" bgcolor=\"#EEEEEE\" link=\"#0000EE\" vlink=\"#551A8B\" alink=\"#336633\">\n<p wrap=\"hard\">\n    <h1>USC: CSCI 201L Fall 2017. USC: CSCI 201L Fall 2017. USC: CSCI 201L Fall 2017</h1>\n</p>\n  </body>\n</html>\n");
        PostContent.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane4.setViewportView(PostContent);

        jPanel6.add(jScrollPane4, java.awt.BorderLayout.CENTER);

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
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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

    private void changeClassMouseEntered(java.awt.event.MouseEvent evt) {                                         
        changeClass.setBackground(new Color(42,77,105));
    }                                        

    private void addClassMouseEntered(java.awt.event.MouseEvent evt) {                                      
        addClass.setBackground(new Color(42,77,105));
    }                                     

    private void lectureMouseEntered(java.awt.event.MouseEvent evt) {                                     
        lecture.setBackground(new Color(42,77,105));
    }                                    

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {                                    
        logout.setBackground(new Color(42,77,105));
    }                                   

    private void changeClassMouseExited(java.awt.event.MouseEvent evt) {                                        
        changeClass.setBackground(new Color(75,134,180));
    }                                       

    private void addClassMouseExited(java.awt.event.MouseEvent evt) {                                     
        addClass.setBackground(new Color(75,134,180));
    }                                    

    private void lectureMouseExited(java.awt.event.MouseEvent evt) {                                    
        lecture.setBackground(new Color(75,134,180));
    }                                   

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {                                   
        logout.setBackground(new Color(75,134,180));
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
        profile.setBackground(new Color(75,134,180));
    }                                   

    private void profileMouseEntered(java.awt.event.MouseEvent evt) {                                     
        profile.setBackground(new Color(42,77,105));
    }                                    

    private void viewMemberMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void viewMemberMouseExited(java.awt.event.MouseEvent evt) {                                       
        viewMember.setBackground(new Color(75,134,180));
    }                                      

    private void viewMemberMouseEntered(java.awt.event.MouseEvent evt) {                                        
        viewMember.setBackground(new Color(42,77,105));
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
                new MainWin().setVisible(true);
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
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel Menu;
    private javax.swing.JList<String> OverviewList;
    private javax.swing.JTextPane PostContent;
    private javax.swing.JLabel addClass;
    private javax.swing.JLabel changeClass;
    private javax.swing.JPanel functionBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lecture;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel profile;
    private javax.swing.JTextField searchNote;
    private javax.swing.JComboBox<String> sortChoiceBox;
    private javax.swing.JLabel viewMember;
    // End of variables declaration                   
}
