/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewGUI;

import java.awt.Color;

import GUI.CreateNewUser;
import GUI.GuestWindow;
import NotezzaClient.NotezzaClient;
import NotezzaServer.Command;
import NotezzaServer.CommandType;
import objects.LoginCredential;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JPanel {

    private NotezzaClient client;
    /**
     * Creates new form Login
     */
    public Login(NotezzaClient client) {
        initComponents();
        String uText = "<html><u>Not a Member? Sign Up</u></html>";
        signupLabel.setText(uText);
        uText = "<html><u>Continue As Guest</u></html>";
        guestLabel.setText(uText);
        this.client = client;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        signinPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        signupLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        unameField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        signinButton = new javax.swing.JButton();
        guestLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(630, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signinPanel.setBackground(new java.awt.Color(52, 61, 70));
        signinPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/user100.png"))); // NOI18N
        signinPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        usernameLabel.setBackground(new java.awt.Color(52, 61, 70));
        usernameLabel.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(204, 204, 204));
        usernameLabel.setText("USERNAME");
        signinPanel.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        signupLabel.setBackground(new java.awt.Color(52, 61, 70));
        signupLabel.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        signupLabel.setForeground(new java.awt.Color(204, 204, 204));
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("Not a Member? Sign Up");
        signupLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupLabelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupLabelMouseEntered(evt);
            }
        });
        signinPanel.add(signupLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 120, -1));
        signinPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 152, 10));
        signinPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 152, 10));

        unameField.setBackground(new java.awt.Color(52, 61, 70));
        unameField.setForeground(new java.awt.Color(204, 204, 204));
        unameField.setText("Enter your username");
        unameField.setBorder(null);
        unameField.setCaretColor(new java.awt.Color(204, 204, 204));
        unameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                unameFieldFocusLost(evt);
            }
        });
        unameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unameFieldMouseClicked(evt);
            }
        });
        signinPanel.add(unameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        passField.setBackground(new java.awt.Color(52, 61, 70));
        passField.setForeground(new java.awt.Color(204, 204, 204));
        passField.setText("jPasswordField1");
        passField.setBorder(null);
        passField.setCaretColor(new java.awt.Color(204, 204, 204));
        passField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passFieldFocusLost(evt);
            }
        });
        signinPanel.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        signinButton.setForeground(new java.awt.Color(52, 61, 70));
        signinButton.setText("Sign In");
        signinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinButtonActionPerformed(evt);
            }
        });
        signinPanel.add(signinButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 120, -1));

        guestLabel.setBackground(new java.awt.Color(52, 61, 70));
        guestLabel.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        guestLabel.setForeground(new java.awt.Color(204, 204, 204));
        guestLabel.setText("Continue As Guest");
        guestLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guestLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guestLabelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guestLabelMouseEntered(evt);
            }
        });
        signinPanel.add(guestLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        passLabel.setBackground(new java.awt.Color(52, 61, 70));
        passLabel.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        passLabel.setForeground(new java.awt.Color(204, 204, 204));
        passLabel.setText("PASSWORD");
        signinPanel.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 212, -1, -1));

        add(signinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 310, 400));

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/label400.png"))); // NOI18N
        add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));
    }// </editor-fold>

    private void passFieldFocusGained(java.awt.event.FocusEvent evt) {
        passField.setText("");
    }

    private void unameFieldMouseClicked(java.awt.event.MouseEvent evt) {
        if(unameField.getText().equals("Enter your username")){
            unameField.setText("");
        }
    }

    private void unameFieldFocusLost(java.awt.event.FocusEvent evt) {
        if(unameField.getText().isEmpty() || unameField.getText() == null){
            unameField.setText("Enter your username");
        }
    }

    private void passFieldFocusLost(java.awt.event.FocusEvent evt) {
        if(passField.getPassword().length == 0 || passField.getPassword() == null){
            passField.setText("jPasswordField1");
        }
    }

    private void signinButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(passField.getPassword());
        System.out.println(unameField.getText());
        String password = String.copyValueOf(passField.getPassword());
        LoginCredential loginCredential = new LoginCredential(unameField.getText(),password);
        Command login = new Command(CommandType.LOGIN,loginCredential);
        client.sendCommand(login);
    }

    private void signupLabelMouseEntered(java.awt.event.MouseEvent evt) {
        signupLabel.setForeground(new Color(153, 204, 255));
        CreateNewUser createNewUser = new CreateNewUser(client);
        createNewUser.setVisible(true);
    }

    private void signupLabelMouseExited(java.awt.event.MouseEvent evt) {
        signupLabel.setForeground(new Color(204,204,204));
    }

    private void guestLabelMouseEntered(java.awt.event.MouseEvent evt) {
        guestLabel.setForeground(new Color(153, 204, 255));
    }

    private void guestLabelMouseExited(java.awt.event.MouseEvent evt) {
        guestLabel.setForeground(new Color(204,204,204));
        GuestWindow guest = new GuestWindow();
        guest.setVisible(true);
    }

    private void guestLabelMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void signupLabelMouseClicked(java.awt.event.MouseEvent evt) {

    }


    // Variables declaration - do not modify
    private javax.swing.JLabel guestLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton signinButton;
    private javax.swing.JPanel signinPanel;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JTextField unameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration
}
