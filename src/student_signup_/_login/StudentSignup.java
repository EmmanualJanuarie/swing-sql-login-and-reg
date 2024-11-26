/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_signup_._login;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author emman
 */
public class StudentSignup extends javax.swing.JFrame {

    //creating public variables for Connection and statement
    public Statement statement;
    
    //private variables for username, url and pwd
    
    private String url = "jdbc:mysql://localhost:3306/student_system";
    private String username = "root";
    private String pwd = "egMT5@me";
    private String sql;
    
    java.sql.Connection conn;
    
    //global variables for textbox
    String fname = "";
    String lname = "";
    String user_name = "";
    String User_pwd = "";
    
    /**
     * Creates new form StudentSignup
     */
    public StudentSignup() {
        initComponents();
        
        //try-catch to create connection
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username, pwd);//establish connection
            statement = conn.createStatement();
           
            System.out.print("Connected to DB!!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);//printing message to dialog box
            System.out.print(e.getMessage());
        }        
    }
    
    int counter = 0;//counter variable
    
     //creating a method to be utilsed for the login gui styling
     public void signupGui_Style(StudentSignup frmSignup){
        
        //setting title
        frmSignup.setTitle("Sign Up");
         
        //setting the background color of Sign UP Gui
        frmSignup.getContentPane().setBackground(new Color(60,63,65,255));
        
        //setting background color of textboxs
        frmSignup.txtFirstName.setBackground(new Color(69,73,74,255));
        frmSignup.txtLastName.setBackground(new Color(69,73,74,255));
        frmSignup.txtUsername.setBackground(new Color(69,73,74,255));
        frmSignup.txtPassword.setBackground(new Color(69,73,74,255));
        frmSignup.txtConfirmPwd.setBackground(new Color(69,73,74,255));
        
        //setting background colour for button
        frmSignup.btnSignUp.setBackground(new Color(140,100,100,255));
        
        //setting background color of textboxes border
        frmSignup.txtFirstName.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
        frmSignup.txtLastName.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
        frmSignup.txtUsername.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
        frmSignup.txtPassword.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
        frmSignup.txtConfirmPwd.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
        
        
        //setting background color when clicked - for txtFirstName
        frmSignup.txtFirstName.addFocusListener(new FocusListener(){
        
            @Override
            //colour trigger when active
            public void focusGained(FocusEvent e) {
               frmSignup.txtFirstName.setBorder(BorderFactory.createLineBorder(new Color(75,110,175)));
            }

            @Override
            //colour triggered when not active
            public void focusLost(FocusEvent e) {
                frmSignup.txtFirstName.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
            }
        });

        //setting background color when clicked - for txtLastName
        frmSignup.txtLastName.addFocusListener(new FocusListener(){
        
            @Override
            //colour trigger when active
            public void focusGained(FocusEvent e) {
               frmSignup.txtLastName.setBorder(BorderFactory.createLineBorder(new Color(75,110,175)));
            }

            @Override
            //colour triggered when not active
            public void focusLost(FocusEvent e) {
                frmSignup.txtLastName.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
            }
        });
        
        //setting background color when clicked - for txtUsername
        frmSignup.txtUsername.addFocusListener(new FocusListener(){
        
            @Override
            //colour trigger when active
            public void focusGained(FocusEvent e) {
               frmSignup.txtUsername.setBorder(BorderFactory.createLineBorder(new Color(75,110,175)));
               
               //calling method to handle username conditions
               frmSignup.correctUserName();
            }

            @Override
            //colour triggered when not active
            public void focusLost(FocusEvent e) {
                frmSignup.txtUsername.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
                
               //calling method to handle username conditions
               frmSignup.correctUserName();
            }
        });
        
        //setting background color when clicked - for txtPassword
        frmSignup.txtPassword.addFocusListener(new FocusListener(){
        
            @Override
            //colour trigger when active
            public void focusGained(FocusEvent e) {
               frmSignup.txtPassword.setBorder(BorderFactory.createLineBorder(new Color(75,110,175)));
            }

            @Override
            //colour triggered when not active
            public void focusLost(FocusEvent e) {
                frmSignup.txtPassword.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
            }
        });
        
        //setting background color when clicked - for txtConfirmPwd
        frmSignup.txtConfirmPwd.addFocusListener(new FocusListener(){
        
            @Override
            //colour trigger when active
            public void focusGained(FocusEvent e) {
               frmSignup.txtConfirmPwd.setBorder(BorderFactory.createLineBorder(new Color(75,110,175)));
               
               //calling method to check if the pwd match
               frmSignup.isPwdMatch();
               
               //CALLING METHOD - IS PWD VALID
               frmSignup.meetPasswordComplexity();
            }

            @Override
            //colour triggered when not active
            public void focusLost(FocusEvent e) {
                frmSignup.txtConfirmPwd.setBorder(BorderFactory.createLineBorder(new Color(100,100,100,255)));
                //calling method to check if the pwd match
               frmSignup.isPwdMatch();
            }
        });
        
        //Fabricating a hover effect for the lblDirectLogin text
        frmSignup.lblDirectLogin.addMouseListener(new MouseAdapter(){
            //when cursor enters label
             @Override
             public void mouseEntered(MouseEvent e) {
            // Change appearance on hover (e.g., set background color)
              frmSignup.lblDirectLogin.setForeground(new Color(75,110,175));
        }

            @Override
            public void mouseExited(MouseEvent e) {
                // Revert to default appearance
                  frmSignup.lblDirectLogin.setForeground(Color.WHITE);
            }
        });
        
        //Creating a actionlistner for lblDirectLogin
        frmSignup.lblDirectLogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               //takes user to login GUI
               student_signup_._login.FormativeLogin frmLogin = new student_signup_._login.FormativeLogin();//creating an instance of student_signup_._login.FormativeLogin 
               frmLogin.setVisible(true);//Login GUI set to true
               
               //calling login style method
               frmLogin.loginGui_style(frmLogin);
               
               frmSignup.setVisible(false);//Sign Up GUI set to false
                 
            }
        }); 
     }
     
     //creating a method to handle signup username conditions
     public void correctUserName(){
         if(!txtUsername.getText().contains("#")){
            lblPoundSign.setForeground(Color.RED);
         }else{
            lblPoundSign.setForeground(Color.GREEN);
            counter++;
         }
         
         char[] username_txt = txtUsername.getText().toCharArray();
              if(username_txt.length == 8){
                  lblCharMax.setForeground(Color.GREEN);
                   counter++;
              }else{
                  lblCharMax.setForeground(Color.RED);
              }
     }
     
     //creating a method to handle signup Confirm password conditions
     public void isPwdMatch(){
         //conditional statement to chec if pwd mathces
        if(!txtConfirmPwd.getText().equals(txtPassword.getText())){
           lblPwdMatch.setForeground(Color.red);//set text color to red
        }else{
          lblPwdMatch.setForeground(new Color(60,63,65,255));//set text color to contentPane color  
        }
        
     
     
     }
     
     //creating a method to handle signup password conditions
     public void  meetPasswordComplexity(){
             char[] pwd_txt = txtPassword.getPassword();
         
              // creating condition to detect size of character length
              if(pwd_txt.length >= 8){
                  lblPwdCharMax.setForeground(Color.GREEN);
                  counter++;
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
                   counter++;
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
                   counter++;
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
                   counter++;
                   break;// Exit the loop once a special char is found
               }
            }
             
     }
     
     //creating method to determine messgae to be displayed
     public void  regUser(){
          student_signup_._login.MessageBox frmMsg = new student_signup_._login.MessageBox();//creating an instance of sstudent_signup_._login.MessageBox
          
         if(counter == 6){
             //call method to set style of message box
             frmMsg.msgBox_Style(frmMsg);
             frmMsg.setVisible(true);//Displays the Message box Gui
             
             //changing the text of the lblMessage - requirements met
             frmMsg.lblMessage.setText("<html>Username and Password requirements are met. Proceed to Login.</html>");
             
            Signup(fname, lname,user_name, User_pwd);//calling method to insert data into db table
            
         }else{
             frmMsg.msgBox_Style(frmMsg);
             frmMsg.setVisible(true);//Displays the Message box Gui
             
             //changing the text of the lblMessage - requirements not met
             frmMsg.lblMessage.setText("<html>Username or Password requirements are not met. Return to Signup.</html>");
         }
            
        
     }
     
     
      //creating a method for delay
    public void delayOn_Signup_removal(int sec, StudentSignup frmSignup){
  
        fname += txtFirstName.getText();
        lname += txtLastName.getText();
        user_name += txtUsername.getText();
        User_pwd += new String(txtPassword.getPassword());
        
        //condition to dispose gui
            if(btnSignUp.isEnabled()){
                
                regUser();
                //setting delay for 
                Timer delay = new Timer(sec, e -> { 
                     setVisible(false);
                });
                
                //starting timer
                delay.start();

                delay.setRepeats(false);//runs once
            }
    }
    
    //create signUp method - allows user to signup
    public void Signup(String _fname, String _lname, String _username, String _pwd){
       
       try{
           
         sql = "INSERT INTO userreg (firstname, lastname, username, pwd) VALUES (?, ?, ?, ?)";
          PreparedStatement preparedStatement  = conn.prepareStatement(sql) ;
         
            // Set parameters using user input
            preparedStatement.setString(1, _fname);
            preparedStatement.setString(2, _lname); 
            preparedStatement.setString(3, _username);
           
            preparedStatement.setString(4,);
            
            System.out.print("firstname: " +fname);
            
            // Execute the query
            preparedStatement.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "You successfully Signed Up.");
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
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

        lblpwd = new javax.swing.JLabel();
        lblConfirmPwd = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        lblDirectLogin = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        lblFname = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLname = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblCharMax = new javax.swing.JLabel();
        lblPoundSign = new javax.swing.JLabel();
        lblPwdCharMax = new javax.swing.JLabel();
        lblCharCap = new javax.swing.JLabel();
        lblCharNum = new javax.swing.JLabel();
        lblCharSpec = new javax.swing.JLabel();
        lblPwdMatch = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblpwd.setForeground(new java.awt.Color(255, 255, 255));
        lblpwd.setText("Password:");

        lblConfirmPwd.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmPwd.setText("Confirm Password:");

        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        lblDirectLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblDirectLogin.setText("Already Have an Account? LogIn");

        lblHeading.setBackground(new java.awt.Color(255, 255, 255));
        lblHeading.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblHeading.setText("Sign Up");

        lblFname.setBackground(new java.awt.Color(255, 255, 255));
        lblFname.setForeground(new java.awt.Color(255, 255, 255));
        lblFname.setText("First Name:");

        txtFirstName.setForeground(new java.awt.Color(204, 204, 204));

        lblLname.setForeground(new java.awt.Color(255, 255, 255));
        lblLname.setText("Last Name:");

        txtLastName.setForeground(new java.awt.Color(255, 255, 255));

        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username:");

        txtUsername.setForeground(new java.awt.Color(255, 255, 255));

        lblCharMax.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblCharMax.setForeground(new java.awt.Color(60, 63, 65));
        lblCharMax.setText("* Must be 8 Characters Long");

        lblPoundSign.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblPoundSign.setForeground(new java.awt.Color(60, 63, 65));
        lblPoundSign.setText("* Must contain \" # \" sign");

        lblPwdCharMax.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblPwdCharMax.setForeground(new java.awt.Color(60, 63, 65));
        lblPwdCharMax.setText("* More than 8 characters");

        lblCharCap.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblCharCap.setForeground(new java.awt.Color(60, 63, 65));
        lblCharCap.setText("* Contains a Capital letter");

        lblCharNum.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblCharNum.setForeground(new java.awt.Color(60, 63, 65));
        lblCharNum.setText("* Contains a number");

        lblCharSpec.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblCharSpec.setForeground(new java.awt.Color(60, 63, 65));
        lblCharSpec.setText("* Contains special character");

        lblPwdMatch.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblPwdMatch.setForeground(new java.awt.Color(60, 63, 65));
        lblPwdMatch.setText("* Password Does not Match");

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));

        txtConfirmPwd.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoundSign)
                    .addComponent(lblCharMax))
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLname)
                            .addComponent(lblUsername)
                            .addComponent(lblFname))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName)
                            .addComponent(txtLastName)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lblHeading))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(lblpwd)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblConfirmPwd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPwdMatch)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtConfirmPwd, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDirectLogin)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblPwdCharMax)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCharCap))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCharNum)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCharSpec))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFname)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLname))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCharMax)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoundSign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpwd)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPwd)
                    .addComponent(txtConfirmPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lblPwdMatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPwdCharMax)
                    .addComponent(lblCharCap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCharSpec)
                    .addComponent(lblCharNum))
                .addGap(20, 20, 20)
                .addComponent(btnSignUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDirectLogin)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        //creating instance of StudentSignup
        StudentSignup frmSignup = new StudentSignup();
        
//         regUser(); //Check Validility of username and pwd - Signup
        delayOn_Signup_removal(1000,frmSignup);    
    }//GEN-LAST:event_btnSignUpActionPerformed

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
            java.util.logging.Logger.getLogger(StudentSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        StudentSignup frmSignup = new StudentSignup();
        
        //calling the Sign up gui style method
        frmSignup.signupGui_Style(frmSignup);

        frmSignup.setVisible(true);//Sign Up GUI set to true
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
//                new StudentSignup().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel lblCharCap;
    private javax.swing.JLabel lblCharMax;
    private javax.swing.JLabel lblCharNum;
    private javax.swing.JLabel lblCharSpec;
    private javax.swing.JLabel lblConfirmPwd;
    private javax.swing.JLabel lblDirectLogin;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLname;
    private javax.swing.JLabel lblPoundSign;
    private javax.swing.JLabel lblPwdCharMax;
    private javax.swing.JLabel lblPwdMatch;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblpwd;
    private javax.swing.JPasswordField txtConfirmPwd;
    public javax.swing.JTextField txtFirstName;
    public javax.swing.JTextField txtLastName;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
