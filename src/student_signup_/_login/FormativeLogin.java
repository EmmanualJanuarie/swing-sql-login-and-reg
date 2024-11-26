/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_signup_._login;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Locale;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/**
 *
 * @author emman
 */
public class FormativeLogin extends javax.swing.JFrame {

    /**
     * Creates new form StudentLogin
     */
    public FormativeLogin() {
        initComponents();
    }
    
    //private variables for username, url and pwd
    
    private String url = "jdbc:mysql://localhost:3306/student_system";
    private String username = "root";
    private String pwd = "egMT5@me";
    
     int _counter = 0;
     student_signup_._login.StudentSignup frmSignup = new student_signup_._login.StudentSignup();//creating an instance of student_signup_._login.StudentSignup
     
    String user_name = "";
    String User_pwd = "";
     
    //global variables for name and sirname
    String f_name;
    String s_name;
     
    
    //creating a method to be utilsed for the login gui styling
    public void loginGui_style(FormativeLogin frmLogin){
        
        //setting title
        frmLogin.setTitle("Login");
        
        //setting the background color of Sign UP Gui
        frmLogin.getContentPane().setBackground(new Color(60,63,65,255));

        //setting background color of textboxes border
        frmLogin.txtUsername.setBackground(new Color(69,73,74,255));
        frmLogin.txtPassword.setBackground(new Color(69,73,74,255));
        
        //setting background colour for button
        frmLogin.btnLogin.setBackground(new Color(140,100,100,255));
        
        //setting background color when clicked - for txtUsername
        frmLogin.txtUsername.addFocusListener(new FocusListener(){
        
            @Override
            //colour trigger when active
            public void focusGained(FocusEvent e) {
               frmLogin.txtUsername.setBorder(BorderFactory.createLineBorder(new Color(75,110,175)));
               
               //calling method to handle username conditions
               correctUserName();
               meetPasswordComplexity();
            }

            @Override
            //colour triggered when not active
            public void focusLost(FocusEvent e) {
                frmLogin.txtUsername.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
                
                //calling method to handle username conditions
               correctUserName();
               meetPasswordComplexity();
            }
        });
        
        //setting background color when clicked - for txtPwd
        frmLogin.txtPassword.addFocusListener(new FocusListener(){
        
            @Override
            //colour trigger when active
            public void focusGained(FocusEvent e) {
               frmLogin.txtPassword.setBorder(BorderFactory.createLineBorder(new Color(75,110,175)));
               
                //CALLING METHOD - IS PWD VALID
               frmSignup.meetPasswordComplexity();
            }

            @Override
            //colour triggered when not active
            public void focusLost(FocusEvent e) {
                frmLogin.txtPassword.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
                
                 //CALLING METHOD - IS PWD VALID
               frmSignup.meetPasswordComplexity();
            }
        });
        
        //setting background color of textboxes border
        frmLogin.txtUsername.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
        frmLogin.txtPassword.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
        
        //Fabricating a hover effect for the lblDirectLogin text
        frmLogin.lblDirectSignUP.addMouseListener(new MouseAdapter(){
            //when cursor enters label
             @Override
             public void mouseEntered(MouseEvent e) {
            // Change appearance on hover (e.g., set background color)
              frmLogin.lblDirectSignUP.setForeground(new Color(75,110,175));
        }

            @Override
            public void mouseExited(MouseEvent e) {
                // Revert to default appearance
                  frmLogin.lblDirectSignUP.setForeground(Color.WHITE);
            }
        });
        
        //Fabricating a hover effect for the lblDirectLogin text
        frmLogin.btnLogin.addMouseListener(new MouseAdapter(){
            //when cursor enters label
             @Override
             public void mouseEntered(MouseEvent e) {
            // Change appearance on hover (e.g., set background color)
             meetPasswordComplexity();

        }

            @Override
            public void mouseExited(MouseEvent e) {
                // Revert to default appearance
//                  frmLogin.lblDirectSignUP.setForeground(Color.WHITE);
            }
        });
        
        //Creating a actionlistner for lblDirectLogin
        frmLogin.lblDirectSignUP.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               //takes user to Sign up GUI
               student_signup_._login.StudentSignup frmSignup = new student_signup_._login.StudentSignup();
               frmSignup.setVisible(true);
               
               //calling the Sign up gui style method
               frmSignup.signupGui_Style(frmSignup);
               
               //setting the background color of Sign UP Gui
               frmLogin.setVisible(false);
                 
            }
        });
        }
    
     public void correctUserName(){
         if(!txtUsername.getText().contains("#")){
            lblPoundSign.setForeground(Color.RED);
         }else{
            lblPoundSign.setForeground(Color.GREEN);
            _counter++;
            System.out.print(_counter);
         }
         
         char[] username_txt = txtUsername.getText().toCharArray();
              if(username_txt.length == 8){
                  lblCharMax.setForeground(Color.GREEN);
                   _counter++;
                   System.out.print(_counter);
              }else{
                  lblCharMax.setForeground(Color.RED);
              }
     }
     
      //creating a method to handle login password conditions
     public void  meetPasswordComplexity(){
             char[] pwd_txt = txtPassword.getPassword();
         
              // creating condition to detect size of character length
              if(pwd_txt.length >= 8){
                  lblPwdCharMax.setForeground(Color.GREEN);
                  _counter++;
                  System.out.print(_counter);
              }else{
                  lblPwdCharMax.setForeground(Color.RED);
              }
              
            Color redColor = Color.RED;
            Color greenColor = Color.GREEN;

            //setting default color of lblCharNum
            lblCharNum.setForeground(redColor);//color set for char num
               
             //for-each loop to detect digit in char  
             for(char x : pwd_txt){
                 
               // creating condition to detect if the character is a number
               if(Character.isDigit(x)){
                   lblCharNum.setForeground(greenColor);//color set for char num
                   _counter++;
                   System.out.print(_counter);
                   break;// Exit the loop once a number is found
               }
            }
             
             
            //setting default color of lblCharCap
            lblCharCap.setForeground(redColor);//color set for char num
               
             //for-each loop to detect Uppercase in char  
             for(char x : pwd_txt){
                 
               // creating condition to detect if the character is a Uppercase
               if(Character.isUpperCase(x)){
                   lblCharCap.setForeground(greenColor);//color set for char num
                   _counter++;
                   System.out.print(_counter);
                   break;// Exit the loop once a number is found
               } 
            }
             
             
            //setting default color of lblCharSpec
            lblCharSpec.setForeground(redColor);//color set for char num
            
             //for-each loop to detect special char in char  
             for(char x : pwd_txt){
                 
               // creating condition to detect if the character is a special char
               if(!Character.isLetter(x) && !Character.isDigit(x)){
                   lblCharSpec.setForeground(greenColor);//color set for char num
                   _counter++;
                   System.out.print(_counter);
                   break;// Exit the loop once a special char is found
               }
            }
             
     }
     
      //creating method to determine messgae to be displayed
     public void returnLogin(){
          student_signup_._login.MessageBox frmMsg = new student_signup_._login.MessageBox();//creating an instance of sstudent_signup_._login.MessageBox
          student_signup_._login.loginMsgBox frmLoginMsg = new student_signup_._login.loginMsgBox();//creating an instance of sstudent_signup_._login.MessageBox
          
         if(_counter == 6){
             //call method to set style of message box
             frmLoginMsg.msgLoginBox_Style(frmLoginMsg);
             frmLoginMsg.setVisible(true);//Displays the Message box Gui
             
             try  {
                  
                //Establishing JDBC Connection
                java.sql.Connection conn = DriverManager.getConnection(url, username, pwd);
                
                //preparing SQL query
                String query = "SELECT firstname, lastname FROM userreg WHERE username = ? or pwd = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                preparedStatement.setString(1, user_name);
                preparedStatement.setString(2, User_pwd);

                //Executing query
                ResultSet result = preparedStatement.executeQuery();

                while(result.next()){
                    f_name = result.getString("firstname");//get string of table column
                    s_name = result.getString("lastname");//get string of table column

                    frmLoginMsg.lblMessage.setText(String.format("<html>Congratulations %s %s , You have made it to second year. Wishing you all the best.</html>", f_name, s_name));
                  
                    System.out.print("Invalid credentials. Please try again.");
                    break;
                }
                
                System.out.print("Invalid credentials. Please try again.");

                
                //closing resources
                result.close();
                preparedStatement.close();
                conn.close();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
         }else{
             frmMsg.msgBox_Style(frmMsg);
             frmMsg.setVisible(true);//Displays the Message box Gui
             
             //changing the text of the lblMessage - requirements not met
             frmMsg.lblMessage.setText("<html>Incorrect credientials have been supplied, try again.</html>");
         }
            
        
     }
     
     public void login(){
       try(java.sql.Connection conn = DriverManager.getConnection(url, username, pwd)){
           
           String query = "SELECT * FROM userreg WHERE username = ? and pwd = ?";
           PreparedStatement preparedStatement = conn.prepareStatement(query);
           
           preparedStatement.setString(1, user_name);
           preparedStatement.setString(2, User_pwd);
           
           ResultSet result = preparedStatement.executeQuery();
           
           if (result.next()) {
//                returnLogin();
            } else {
               System.out.print("Can't login Something went wrong");
            }
       }catch (SQLException e) {
            e.printStackTrace();
        }
     }
     
      //delay od removal of login menu
    public void delayOn_Login_removal(int sec){
         user_name += txtUsername.getText();
         User_pwd += new String(txtPassword.getPassword());
        
        //condition to dispose gui
            if(btnLogin.isEnabled()){
                
                returnLogin();
                //setting delay for 
                Timer delay = new Timer(sec, e -> { 
                     setVisible(false);
                });
                
                //starting timer
                delay.start();

                delay.setRepeats(false);//runs once
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(209, 274));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1207, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormativeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormativeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormativeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormativeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        FormativeLogin frmLogin = new FormativeLogin();
        
        //calling the login gui style method
        frmLogin.loginGui_style(frmLogin);
        
        frmLogin.setVisible(true);
        java.awt.EventQueue.invokeLater(() -> {
//                new FormativeLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
