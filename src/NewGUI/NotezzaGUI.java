/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notezzagui;

import java.awt.BorderLayout;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;


/**
 *
 * @author user
 */
public class NotezzaGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame loginWindow = new JFrame();
        Login lg = new Login();
        loginWindow.setLayout(new BorderLayout());
        loginWindow.add(lg, BorderLayout.CENTER);
        loginWindow.setSize(630, 400);
        loginWindow.setLocationRelativeTo(null);
        loginWindow.setResizable(false);
        loginWindow.setVisible(true);
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
