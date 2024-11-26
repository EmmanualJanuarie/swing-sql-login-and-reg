/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_signup_._login;

import java.awt.Color;
import javax.swing.Timer;

/**
 *
 * @author emman
 */
public class MessageBox extends javax.swing.JFrame {

    /**
     * Creates new form MessageBox
     */
    public MessageBox() {
        initComponents();
    }
    
    //method for msgbox styling
    public void msgBox_Style(MessageBox frmMsg){
        
        //setting title
        frmMsg.setTitle("Pop Up Message");
        frmMsg.getContentPane().setBackground(new Color(60,63,65,255));
        
        //setting the button bck color
        frmMsg.btnOK.setBackground(new Color(140,100,100,255));

    }
    
    //method for direction to gui type
    public void isValidFor_LoginGui(){
        //calling delay method
        delayOn_MsgBox_login(1000);

    }
    
    //creating a method for delay
    public void delayOn_MsgBox_login(int sec){
        student_signup_._login.FormativeLogin frmLogin = new student_signup_._login.FormativeLogin();//creating an instance of student_signup_._login.FormativeLogin
        student_signup_._login.StudentSignup frmSignup = new student_signup_._login.StudentSignup();//creating an instance of student_signup_._login.StudentSignup
        
        if (lblMessage.getText().endsWith("Login.</html>")) {         
            frmLogin.loginGui_style(frmLogin);
            frmLogin.setVisible(true);
            setVisible(false);
        } else if (lblMessage.getText().endsWith("Signup.</html>")) {
            frmSignup.signupGui_Style(frmSignup);
            frmSignup.setVisible(true);
            setVisible(false);
        }else if (lblMessage.getText().endsWith("again.</html>")) {
            frmLogin.loginGui_style(frmLogin);
            frmLogin.setVisible(true);
            setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMessage = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMessage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setText("This is Default text.");
        lblMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnOK.setBackground(new java.awt.Color(255, 51, 51));
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnOK)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        delayOn_MsgBox_login(1000);       
    }//GEN-LAST:event_btnOKActionPerformed

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
            java.util.logging.Logger.getLogger(MessageBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessageBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessageBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessageBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //Creating an instance of MessageBox
        MessageBox frmMsg = new MessageBox();
        
        //calling messageBox style method
        frmMsg.msgBox_Style(frmMsg);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
//            new MessageBox().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    public javax.swing.JLabel lblMessage;
    // End of variables declaration//GEN-END:variables
}
