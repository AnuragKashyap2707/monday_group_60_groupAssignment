/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin.analytics;

import Business.Business;
import Business.CommonFunction;
import Business.ConfigureABusiness;
import Business.sales.PurchaseOrder;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author group-11
 */
public class viewAllSalesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form viewAllSalesJPanel
     */
    JPanel cardSeqjPanel;
    Business business;
    DecimalFormat df;
    public viewAllSalesJPanel(JPanel cardSeqjPanel,  Business business) {
        initComponents();
        
        this.cardSeqjPanel = cardSeqjPanel;
        this.business = business;
        populateTable();
        df = new DecimalFormat("#.##");
    }
    void populateTable(){
       int rowCount = purchaseOrderjTable.getRowCount();

        DefaultTableModel dtm = (DefaultTableModel) purchaseOrderjTable.getModel();

        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        double totalSales = 0;
        CommonFunction cf = new CommonFunction();
//        System.out.println(business.getPurchaseOrderCat().getPurchaseOrderCat().get(0).getTotalPrice());
        int sno = 1;
       // System.out.println(business.getPurchaseOrderCat().getPurchaseOrderCat().get(0).getCustomer());
//        try{
            for (PurchaseOrder m : business.getPurchaseOrderCat().getPurchaseOrderCat()) // 1st time getProductCatalog() is called in supplier and 2nd time the same method is called in product Catalog class. So we have 2 getProductCatalog()
            {
               
                    Object row[] = new Object[10];
                    row[0] = sno++;
                    row[1] = m;
                    row[2] = m.getCustomer().getCustomerName();                   // we hv created toString() so that, inspite of giving address of object we will get product name
                    row[3] = m.getMarket().getMarketType();
                    
                    if(cf.getTotalTarget(business, m)<m.getTotalPrice()){
                        row[4] = true;
                        row[7] = m.getTotalPrice()-cf.getTotalTarget(business, m);
                    }
                    else{
                        row[4] = false;
                        row[7] = cf.getTotalTarget(business, m)-m.getTotalPrice();
                    }
                    row[5] = cf.getTotalTarget(business, m);
                    row[6] = m.getTotalPrice();
                    
                    row[8] = String.valueOf(m.getDate());
                    row[9] = m.getUser().getUserName();
                    dtm.addRow(row);
                    totalSales +=m.getTotalPrice(); 
                    
                }
            System.out.println(totalSales);
           // System.out.println(df.format(totalSales));
           //     String total = df.format(totalSales);
                totaljTextField.setText(String.valueOf(totalSales));
               
            
//        }
//        catch(Exception e){
//            System.out.println("Hello");
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseOrderjTable = new javax.swing.JTable();
        viewOrderItemsjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        totaljTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        simNumberjTextField = new javax.swing.JTextField();
        simulatejButton = new javax.swing.JButton();
        deleteAlljButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Sales View");

        purchaseOrderjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sno", "Purchase Id", "Customer", "Market", "Above Target", "Target Price", "Total Price", "Gap", "Date", "Sold By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(purchaseOrderjTable);
        if (purchaseOrderjTable.getColumnModel().getColumnCount() > 0) {
            purchaseOrderjTable.getColumnModel().getColumn(0).setResizable(false);
        }

        viewOrderItemsjButton.setText("View Ordered Items");
        viewOrderItemsjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderItemsjButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Total Sales");

        totaljTextField.setEditable(false);

        jLabel3.setText("Simulate Sales :");

        simulatejButton.setText("Simulate");
        simulatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulatejButtonActionPerformed(evt);
            }
        });

        deleteAlljButton.setText("Delete All Entries");
        deleteAlljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAlljButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Delete Entries :");

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(totaljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                        .addComponent(viewOrderItemsjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteAlljButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(simNumberjTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(simulatejButton))
                            .addComponent(backBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewOrderItemsjButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(totaljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(simNumberjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simulatejButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteAlljButton)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderItemsjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderItemsjButtonActionPerformed
        int selectedRow = purchaseOrderjTable.getSelectedRow();
        System.out.println(selectedRow);
        if(selectedRow>=0)
        {
            
            PurchaseOrder vs = (PurchaseOrder)purchaseOrderjTable.getValueAt(selectedRow, 1);
            OrderItemsViewJPanel viewuser = new OrderItemsViewJPanel(cardSeqjPanel,business,vs);
            cardSeqjPanel.add("OrderItemsViewJPanel",viewuser);
            CardLayout layout = (CardLayout) cardSeqjPanel.getLayout();
            layout.next(cardSeqjPanel);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_viewOrderItemsjButtonActionPerformed

    private void simulatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulatejButtonActionPerformed
        ConfigureABusiness cb = new ConfigureABusiness();
        if(!simNumberjTextField.getText().isEmpty()){
            int simNum = Integer.parseInt(simNumberjTextField.getText());
            cb.simulateSales(business, simNum-1);
            populateTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
        }
        
        
    }//GEN-LAST:event_simulatejButtonActionPerformed

    private void deleteAlljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAlljButtonActionPerformed
        business.getPurchaseOrderCat().deleteAllPurchaseOrder();
        populateTable();
    }//GEN-LAST:event_deleteAlljButtonActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        cardSeqjPanel.remove(this);
        CardLayout layout = (CardLayout)cardSeqjPanel.getLayout();
        layout.previous(cardSeqjPanel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteAlljButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseOrderjTable;
    private javax.swing.JTextField simNumberjTextField;
    private javax.swing.JButton simulatejButton;
    private javax.swing.JTextField totaljTextField;
    private javax.swing.JButton viewOrderItemsjButton;
    // End of variables declaration//GEN-END:variables
}