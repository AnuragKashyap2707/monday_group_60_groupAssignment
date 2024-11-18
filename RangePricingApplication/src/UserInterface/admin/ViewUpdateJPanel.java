/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin;


import Business.Business;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Users.User;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author group-11
 */
public class ViewUpdateJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateViewJPanel
     */
    Business business;
    User user;
    JPanel cardSeqjPanel;
    public ViewUpdateJPanel(JPanel cardSeqjPanel,Business business, User user) {
        initComponents();
        this.user=user;
        this.business=business;
        this.cardSeqjPanel=cardSeqjPanel;
        typejComboBox.setEnabled(false);
        usernamejTextField.setText(user.getUserName());
        passwordjPasswordField.setText(user.getPassword());
        typejComboBox.getModel().setSelectedItem(user.getAuth());
        isActivejCheckBox.setSelected(user.isActive());
        
        
        isActivejCheckBox.setEnabled(user.isActive());
        usernamejTextField.setEnabled(false);
        passwordjPasswordField.setEnabled(false);
        savejButton.setEnabled(false);
        isActivejCheckBox.setEnabled(false);
            pnamejTextField.setEnabled(false);
            pPhonejTextField.setEnabled(false);
            populateComboPerson(business.getPersonDirectory());
            personIdjComboBox.setEnabled(false);
        
        try{
            //personIdjComboBox.getModel().setSelectedItem(user.getPerson().getPersonId());
           // personIdjTextField.setText(String.valueOf(user.getPerson().getPersonId()));
            pnamejTextField.setText("  ");
            //pPhonejTextField.setText(String.valueOf(user.getPerson().getPhone()));
           // personIdjTextField.setEnabled(false);
            pnamejTextField.setEnabled(false);
            pPhonejTextField.setEnabled(false);
        }
        catch(Exception e){
//            personIdjTextField.setText("not Assigned");
//            personIdjTextField.setEnabled(false);
        }
    }
    
    private void populateComboPerson(PersonDirectory pd) {
        for(Person k: pd.getPersonDirectory())
        {
            personIdjComboBox.addItem(String.valueOf(k.getPersonId()));
        }
    }
    private Boolean validateForm(){
        int isNotValid = 1; 
        if(usernamejTextField.getText().isEmpty())
        {
            if(!(usernamejTextField.getText().matches("[a-zA-Z]+")) )
            {
                errorjLabel.setText("Enter Valid Customer ID");
                isNotValid = 0;
            }
            else{
                errorjLabel.setText("");
            }
        }
        
        
        
        
        Boolean returnVar = false;
        if (isNotValid == 1)
            returnVar = true;
        else if (isNotValid == 0)
            returnVar = false;
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

        usernamejTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passwordjPasswordField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        isActivejCheckBox = new javax.swing.JCheckBox();
        pnamejTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pPhonejTextField = new javax.swing.JTextField();
        backjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        updatejButton = new javax.swing.JButton();
        savejButton = new javax.swing.JButton();
        typejComboBox = new javax.swing.JComboBox<>();
        personIdjComboBox = new javax.swing.JComboBox<>();
        errorjLabel = new javax.swing.JLabel();

        usernamejTextField.setEditable(false);
        usernamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernamejTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("User Name");

        jLabel5.setText("Password");

        passwordjPasswordField.setEditable(false);
        passwordjPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordjPasswordFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordjPasswordFieldKeyTyped(evt);
            }
        });

        jLabel7.setText("Type");

        jLabel8.setText("Person ID");

        jLabel12.setText("Is active");

        isActivejCheckBox.setSelected(true);
        isActivejCheckBox.setText("Active");

        pnamejTextField.setEditable(false);

        jLabel10.setText("Person Name");

        jLabel9.setText("User Details:");

        jLabel11.setText("Person Phone");

        pPhonejTextField.setEditable(false);

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Update  User Accounts");

        updatejButton.setText("update");
        updatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButtonActionPerformed(evt);
            }
        });

        savejButton.setText("Save");
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
            }
        });

        typejComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "admin", "hr", "user" }));

        personIdjComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                personIdjComboBoxItemStateChanged(evt);
            }
        });

        errorjLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        errorjLabel.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(isActivejCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel9)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pPhonejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(usernamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordjPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updatejButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(savejButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(personIdjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(errorjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pnamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordjPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(typejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(personIdjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(isActivejCheckBox))
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(pnamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pPhonejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton)
                    .addComponent(updatejButton)
                    .addComponent(savejButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernamejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamejTextFieldActionPerformed

    private void passwordjPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordjPasswordFieldKeyPressed
//        passwordStrengthTextField.setText("well");
//        if(passwordjPasswordField.getText().matches("[a-zA-Z0-9!@#\\$%\\^\\&*\\)\\(+=._-]{6,}$/g")){
//            passwordStrengthTextField.setText("Very Strong");
//        }
//        else if(passwordjPasswordField.getText().matches("[a-zA-Z0-9]{6,}$/g")){
//            passwordStrengthTextField.setText("Strong");
//        }
//        else if(passwordjPasswordField.getText().matches("[a-zA-Z]{6,}$/g")){
//            passwordStrengthTextField.setText("weak");
//        }
//        else if(passwordjPasswordField.getText().matches("[a-z]{6,}$/g")){
//            passwordStrengthTextField.setText("Very weak");
//        }
//        else if(passwordjPasswordField.getText().matches("[a-z]{0,6}$/g")){
//            passwordStrengthTextField.setText("Password must be atleat 6 Characters");
//        }
    }//GEN-LAST:event_passwordjPasswordFieldKeyPressed

    private void passwordjPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordjPasswordFieldKeyTyped

    }//GEN-LAST:event_passwordjPasswordFieldKeyTyped

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        cardSeqjPanel.remove(this);
        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
        layout.previous(cardSeqjPanel);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        updatejButton.setEnabled(false);
        usernamejTextField.setEnabled(true);
        passwordjPasswordField.setEnabled(true);
        savejButton.setEnabled(true);
        personIdjComboBox.setEnabled(true);
        isActivejCheckBox.setEnabled(true);
        personIdjComboBox.setEnabled(true);
        typejComboBox.setEnabled(true);
        usernamejTextField.setEditable(true);
        passwordjPasswordField.setEditable(true);
        personIdjComboBox.setEditable(true);
        personIdjComboBox.setEditable(true);
        typejComboBox.setEditable(true);
    }//GEN-LAST:event_updatejButtonActionPerformed

    private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
        if(validateForm()){
        user.setUserName(usernamejTextField.getText());
        user.setAuth(String.valueOf(typejComboBox.getSelectedItem()));
        Person person = business.getPersonDirectory().getPersonById(Integer.valueOf(String.valueOf(personIdjComboBox.getSelectedItem())));
        user.setPerson(person);
        user.setActive(isActivejCheckBox.isSelected());
            user.setPassword(passwordjPasswordField.getText());
            
        user.setActive(isActivejCheckBox.isEnabled());
        JOptionPane.showMessageDialog(null, "User Updated");
        cardSeqjPanel.remove(this);
        Component[] componentArray =  cardSeqjPanel.getComponents();
        Component component = componentArray[componentArray.length-1];
        UserJPanel ujp = (UserJPanel) component;
        ujp.populate();
        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
        layout.previous(cardSeqjPanel);
        }
    }//GEN-LAST:event_savejButtonActionPerformed

    private void personIdjComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_personIdjComboBoxItemStateChanged
        int id = Integer.parseInt(String.valueOf(personIdjComboBox.getSelectedItem()));
        Person selected =  business.getPersonDirectory().getPersonById(id);
        pnamejTextField.setText(selected.getFullName());
        pPhonejTextField.setText(String.valueOf(selected.getPhoneNum()));
    }//GEN-LAST:event_personIdjComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel errorjLabel;
    private javax.swing.JCheckBox isActivejCheckBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField pPhonejTextField;
    private javax.swing.JPasswordField passwordjPasswordField;
    private javax.swing.JComboBox<String> personIdjComboBox;
    private javax.swing.JTextField pnamejTextField;
    private javax.swing.JButton savejButton;
    private javax.swing.JComboBox<String> typejComboBox;
    private javax.swing.JButton updatejButton;
    private javax.swing.JTextField usernamejTextField;
    // End of variables declaration//GEN-END:variables
}