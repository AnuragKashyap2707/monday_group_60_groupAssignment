/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin;

import Business.Business;
import Business.Users.User;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author group-11
 */
public class UserJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PersonJPanel
     */
    JPanel cardSeqjPanel;
    Business business;
    public UserJPanel(JPanel cardSeqjPanel,Business business) {
        initComponents();
        this.cardSeqjPanel = cardSeqjPanel;
        this.business = business;
        populate();
    }
    
    public void populate(){
        
            DefaultTableModel dtm = (DefaultTableModel) PersonjTable.getModel();
            int rowCount = dtm.getRowCount();
            int count = 0;
            
            for (int i =0; i<rowCount; i++)
            {
                dtm.removeRow(0);
            }
            dtm.setRowCount(0);
            try {
                for(User user : business.getUserCat().getUserCat())
                {
                    count ++;
                    Object row[] = new Object [5];
                    row[0] = user;
                    row[1] = user.getUserName();
                    try{
                        row[2] = user.getPerson().getFullName();
                    }
                    catch(Exception e){
                        row[2] ="Not Assignmed";
                    }
                    row[3] = user.getPassword();
                    row[4] = user.getAuth();
                    dtm.addRow(row);
                }
            CountjTextField.setText(String.valueOf(count));
            }
            catch(Exception e){
                System.out.println("No values in DB");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PersonjTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        CountjTextField = new javax.swing.JTextField();
        addjButton = new javax.swing.JButton();
        viewUpdatejButton = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();
        errorjLabel = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Directory");

        PersonjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Username", "Person Name", "Password", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(PersonjTable);

        jLabel10.setText("Count:");

        CountjTextField.setEditable(false);

        addjButton.setText("Add");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });

        viewUpdatejButton.setText("View/Update");
        viewUpdatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUpdatejButtonActionPerformed(evt);
            }
        });

        deletejButton.setText("Delete");
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });

        errorjLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
            .addComponent(errorjLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(addjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewUpdatejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletejButton))))
            .addComponent(backjButton)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(errorjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewUpdatejButton)
                    .addComponent(deletejButton)
                    .addComponent(addjButton)
                    .addComponent(CountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(129, 129, 129)
                .addComponent(backjButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        int selectedRow = PersonjTable.getSelectedRow();
        System.out.println(selectedRow);
        if(selectedRow>=0)
        {
            
            User vs = (User)PersonjTable.getValueAt(selectedRow, 0);
            if(vs==business.getLoggedUser()){
                JOptionPane.showMessageDialog(null, "You cant delete yourself while logged in");
            }
            else{
                 int dialogueButton = JOptionPane.YES_NO_OPTION;
                String message = "Are you sure you want to delete username: "+vs.getUserName();
                int result = JOptionPane.showConfirmDialog(null, message, "Warning", dialogueButton);
                if(result == JOptionPane.YES_OPTION){
                    business.getUserCat().deleteUser(vs);
                    JOptionPane.showMessageDialog(null,"User Deleted");
                    populate();
                }
            }
           
            
        }
        else
        JOptionPane.showMessageDialog(null,"No Row is selected");
    }//GEN-LAST:event_deletejButtonActionPerformed

    private void viewUpdatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUpdatejButtonActionPerformed
        int selectedRow = PersonjTable.getSelectedRow();
        System.out.println(selectedRow);
        if(selectedRow>=0)
        {
            
            User vs = (User)PersonjTable.getValueAt(selectedRow, 0);
            ViewUpdateJPanel viewuser = new ViewUpdateJPanel(cardSeqjPanel,business,vs);
        cardSeqjPanel.add("ViewJPanel",viewuser);
        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
        layout.next(cardSeqjPanel);
        }
        
    }//GEN-LAST:event_viewUpdatejButtonActionPerformed

    private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjButtonActionPerformed
        AddUser adduser = new AddUser(cardSeqjPanel,business);
        cardSeqjPanel.add("AddUser",adduser);
        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
        layout.next(cardSeqjPanel);
    }//GEN-LAST:event_addjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        cardSeqjPanel.remove(this);
        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
        layout.previous(cardSeqjPanel);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CountjTextField;
    private javax.swing.JTable PersonjTable;
    private javax.swing.JButton addjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel errorjLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewUpdatejButton;
    // End of variables declaration//GEN-END:variables
}
