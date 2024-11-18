/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin;

import Business.Business;
import Business.MapSalesPersonUser;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author group-11
 */
public class MappingUserSalesPersonJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MappingUserSupplier
     */
    Business business;
    JPanel cardSeqjPanel;

    public MappingUserSalesPersonJPanel(JPanel cardSeqjPanel,Business business) {
        initComponents();
        this.business = business;
        this.cardSeqjPanel = cardSeqjPanel;

        populateTable();

    }

    public void populateTable() {

        int rowCount = suppUserTb.getRowCount();

        DefaultTableModel dtm = (DefaultTableModel) suppUserTb.getModel();

        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        try {
            for (MapSalesPersonUser m : business.getMapSalesPersonUserDirectory().getMapSalesPersonUserDirectory()) // 1st time getProductCatalog() is called in supplier and 2nd time the same method is called in product Catalog class. So we have 2 getProductCatalog()
            {
                Object row[] = new Object[4];
                row[0] = m;                   // we hv created toString() so that, inspite of giving address of object we will get product name
                row[1] = m.getSalesPerson().getPerson().getFullName();
                row[2] = m.getUser().getUserId();
                row[3] = m.getUser().getUserName();
                dtm.addRow(row);

            }
        } catch (Exception e) {
             e.printStackTrace();
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
        suppUserTb = new javax.swing.JTable();
        deletejButton = new javax.swing.JButton();
        addjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        suppUserTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SalesPerson Id", "SalesPerson Name", "User Id", "User Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(suppUserTb);

        deletejButton.setText("Delete");
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });

        addjButton.setText("Add Map");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage User Sales Person Menu");

        backBtn.setBackground(new java.awt.Color(153, 153, 153));
        backBtn.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("<< Back");
        backBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.darkGray, null, null));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deletejButton)
                                .addGap(18, 18, 18)
                                .addComponent(addjButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addjButton)
                    .addComponent(deletejButton)
                    .addComponent(backBtn))
                .addContainerGap(276, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjButtonActionPerformed

        AddUserSalesPersonJPanel ad = new AddUserSalesPersonJPanel(cardSeqjPanel, business);
        cardSeqjPanel.add("AddUserSalesPersonJPanel", ad);
        CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
        layout.next(cardSeqjPanel);
    }//GEN-LAST:event_addjButtonActionPerformed

    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed

        int selectRow = suppUserTb.getSelectedRow(); 
        if (selectRow < 0) {                                                           // if selectedRow <0 means the row is not selected 
            JOptionPane.showMessageDialog(null, "please select any row from the first table", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MapSalesPersonUser SalesPersonUser = (MapSalesPersonUser) suppUserTb.getValueAt(selectRow, 0);
        business.getMapSalesPersonUserDirectory().deleteMapSalesPersonUser(SalesPersonUser);
        populateTable();

    }//GEN-LAST:event_deletejButtonActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        cardSeqjPanel.remove(this);
        CardLayout layout = (CardLayout)cardSeqjPanel.getLayout();
        layout.previous(cardSeqjPanel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addjButton;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deletejButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable suppUserTb;
    // End of variables declaration//GEN-END:variables
}