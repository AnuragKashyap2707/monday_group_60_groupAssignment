/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.login;

import Business.Business;
import Business.Users.User;
import UserInterface.Main.DataEntry;
import UserInterface.admin.AdminMenuJFrame;
import UserInterface.admin.ManageRolesJPanel;
import UserInterface.sales.SalesMenu;
import UserInterface.supplierJPanel.ManageProductsJPanel;
import UserInterface.supplierJPanel.SupplierMenuJFrame;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author group-11
 */
public class LoginForm extends javax.swing.JPanel {

    /**
     * Creates new form LoginForm
     */
    Business business;
    JPanel cardSeqjPanel;
    User loggedUser;

    public LoginForm() throws IOException {
        initComponents();
        runDataEntry();

    }

    public LoginForm(JPanel cardSeqjPanel, Business business) throws IOException {
        initComponents();
        runDataEntry();
        this.cardSeqjPanel = cardSeqjPanel;
        this.business = business;
        BufferedImage myPicture = ImageIO.read(new File("images/Xerox_2008_Logo.png"));
        xeroxLogo.setIcon(new ImageIcon(myPicture));

    }
    
      private void runDataEntry() {
        try {
            // Create an instance of DataEntry and call its main method
            DataEntry dataEntry = new DataEntry();
            dataEntry.main(null);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    private Boolean validateForm() {
        int isNotValid = 1;
        if (userNameTextFeild.getText().isEmpty() && passwordField.getText().isEmpty()) {
            if (!(userNameTextFeild.getText().matches("[a-zA-Z0-9]+"))) {
                astrixUsername.setText("*");
                astrixPassword.setText("*");
                warningText.setText("Enter Username and Password");
                isNotValid = 0;
            } else {
                astrixUsername.setText("");
                warningText.setText("");
                astrixPassword.setText("");
            }
        } else if (userNameTextFeild.getText().isEmpty()) {
            if (!(userNameTextFeild.getText().matches("[a-zA-Z0-9]+"))) {
                astrixUsername.setText("");
                warningText.setText("");
                astrixPassword.setText("");
                astrixUsername.setText("*");
                warningText.setText("Enter Username");
                isNotValid = 0;
            } else {
                astrixUsername.setText("");
                warningText.setText("");
            }
        } else if (passwordField.getText().isEmpty()) {
            if (!(passwordField.getText().matches("[a-zA0-9]+"))) {
                astrixUsername.setText("");
                warningText.setText("");
                astrixPassword.setText("");
                astrixPassword.setText("*");
                warningText.setText("Enter Password");
                isNotValid = 0;
            } else {
                astrixPassword.setText("");
                warningText.setText("");
            }
        }
        Boolean returnVar = false;
        if (isNotValid == 1) {
            returnVar = true;
        } else if (isNotValid == 0) {
            returnVar = false;
        }
        return returnVar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        userNameTextFeild = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginJButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        astrixUsername = new javax.swing.JLabel();
        astrixPassword = new javax.swing.JLabel();
        warningText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        xeroxLogo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("User Name");

        userNameTextFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameTextFeildKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        loginJButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        astrixUsername.setForeground(new java.awt.Color(255, 0, 51));

        astrixPassword.setForeground(new java.awt.Color(255, 0, 51));

        warningText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        warningText.setForeground(new java.awt.Color(255, 0, 51));

        jLabel4.setFont(new java.awt.Font("Helvetica", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Xerox Sales Analytics App");

        jLabel5.setFont(new java.awt.Font("Damascus", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Login Page");

        xeroxLogo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        xeroxLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                            .addComponent(xeroxLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(295, 295, 295)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(astrixUsername)
                                    .addComponent(astrixPassword)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(warningText, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(418, 418, 418)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(userNameTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginJButton))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(astrixUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xeroxLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(astrixPassword)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userNameTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginJButton)
                .addGap(13, 13, 13)
                .addComponent(warningText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(542, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        String userName = userNameTextFeild.getText();
        String password = passwordField.getText();
        User user = new User(" ");
        if (validateForm()) {
            try {
                String hash = business.getUserCat().get_SHA_512_SecurePassword(password, "Fancy");
                try {
                    user = getUser(userName, hash);
                    business.setLoggedUser(user);
                    this.loggedUser = user;
                    System.out.println(user.getAuth());

                    if (user.getUserName() == null) {
                        System.out.println("User not found");
                        warningText.setText("Wrong Username or Password");
                    } else if ("admin".compareTo(user.getAuth()) == 0) {
                        AdminMenuJFrame amf = new AdminMenuJFrame(cardSeqjPanel,business);
                        cardSeqjPanel.add("AdminMenuJFrame", amf);
                        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
                        layout.next(cardSeqjPanel);
                    } 
//                    else if ("user".compareTo(user.getAuth()) == 0) {
//                        ManageRolesJPanel mp = new ManageRolesJPanel(cardSeqjPanel, business);
//                        cardSeqjPanel.add("ManageProducts", mp);
//                        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
//                        layout.next(cardSeqjPanel);
//                    
//                    } 
                    
//                    else if ("supplier".compareTo(user.getAuth()) == 0) {
//                       
//                        SupplierMenuJFrame mp = new SupplierMenuJFrame(cardSeqjPanel, business);
//                        cardSeqjPanel.add("SupplierMenuJFrame", mp);
//                        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
//                        layout.next(cardSeqjPanel);
//                    
//                    }
                    
                    
                    
                    else if ("sales".compareTo(user.getAuth()) == 0) {
                        SalesMenu ajp = new SalesMenu(cardSeqjPanel, business);
                        cardSeqjPanel.add("UserPanel", ajp);
                        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
                        layout.next(cardSeqjPanel);
                    }
                    
                    userNameTextFeild.setText("");
                    passwordField.setText("");

                } catch (Exception e) {
                    System.out.println("User not found");
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_loginJButtonActionPerformed

    private void userNameTextFeildKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTextFeildKeyPressed
        //validateForm();
    }//GEN-LAST:event_userNameTextFeildKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel astrixPassword;
    private javax.swing.JLabel astrixUsername;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameTextFeild;
    private javax.swing.JLabel warningText;
    private javax.swing.JLabel xeroxLogo;
    // End of variables declaration//GEN-END:variables

    private User getUser(String userName, String hash) {
        User result;
        result = business.getUserCat().getUserDetails(userName, hash);
        return result;
    }
}