/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin;

import Business.Business;
import Business.MapSalesPersonUser;
import Business.MapSupplierUser;
import Business.Person.SalesPerson;
import Business.Users.User;
import Business.supplier.Product;
import Business.supplier.Supplier;
import UserInterface.login.LoginForm;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author group-11
 */
public class AddUserSalesPersonJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddProducts
     */
    JPanel cardSeqJPanel;
    Business business;

    public AddUserSalesPersonJPanel(JPanel cardSeqJPanel, Business business) {
        initComponents();

        this.cardSeqJPanel = cardSeqJPanel;
        this.business = business;

        populateUserTable();
        populateSupplierTable();

    }

    public void populateUserTable() {

        int rowCount = userTb.getRowCount();

        DefaultTableModel dtm = (DefaultTableModel) userTb.getModel();

        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }

        for (User m : business.getUserCat().getUserCat()) // 1st time getProductCatalog() is called in supplier and 2nd time the same method is called in product Catalog class. So we have 2 getProductCatalog()
        {
            Object row[] = new Object[2];

            row[0] = m;                   // we hv created toString() so that, inspite of giving address of object we will get product name
            row[1] = m.getUserName();

            dtm.addRow(row);

        }

    }

    public void populateSupplierTable() {

        int rowCount = supplierTb.getRowCount();

        DefaultTableModel dtm = (DefaultTableModel) supplierTb.getModel();

        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (SalesPerson sp : business.getSalesPersonDirectory().getSalesPersonDirectory()) // 1st time getProductCatalog() is called in supplier and 2nd time the same method is called in product Catalog class. So we have 2 getProductCatalog()
        {
            Object row[] = new Object[2];

            row[0] = sp;                   // we hv created toString() so that, inspite of giving address of object we will get product name
            row[1] = sp.getPerson().getFullName();

            dtm.addRow(row);

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
        userTb = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        supplierTb = new javax.swing.JTable();
        LinkjButton = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        userTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User Id", "User Name"
            }
        ));
        jScrollPane1.setViewportView(userTb);

        supplierTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sales Person ID", "Sales Person Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(supplierTb);

        LinkjButton.setText("Link Ids");
        LinkjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinkjButtonActionPerformed(evt);
            }
        });

        back.setText("<<Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Link Sales With User Menu");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LinkjButton)
                                .addContainerGap())
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 19074, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LinkjButton)
                    .addComponent(back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:

        Component[] componentArray = cardSeqJPanel.getComponents();        // to get all the components as these values will be added
        Component component = componentArray[componentArray.length - 2];
        MappingUserSupplier ms = (MappingUserSupplier) component;
        ms.populateTable();
        cardSeqJPanel.remove(this);
        CardLayout layout = (CardLayout) cardSeqJPanel.getLayout();
        layout.previous(cardSeqJPanel);

    }//GEN-LAST:event_backActionPerformed

    private void LinkjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LinkjButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = supplierTb.getSelectedRow();
        int selectedRow1 = userTb.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "please select a row from the table first  to view details", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SalesPerson sp = (SalesPerson) supplierTb.getValueAt(selectedRow, 0);
            User user = (User) userTb.getValueAt(selectedRow1, 0);

            MapSalesPersonUser ms = business.getMapSalesPersonUserDirectory().addMapSalesPersonUser();

            ms.setSalesPerson(sp);
            ms.setUser(user);
          
            JOptionPane.showMessageDialog(null, "added successfully");
            Component[] componentArray = cardSeqJPanel.getComponents();        // to get all the components as these values will be added
            Component component = componentArray[componentArray.length - 2];
            
            MappingUserSalesPersonJPanel mp = (MappingUserSalesPersonJPanel) component;
            mp.populateTable();

            cardSeqJPanel.remove(this);
            CardLayout layout = (CardLayout) cardSeqJPanel.getLayout();
            layout.previous(cardSeqJPanel);

        }

    }//GEN-LAST:event_LinkjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LinkjButton;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable supplierTb;
    private javax.swing.JTable userTb;
    // End of variables declaration//GEN-END:variables
}
