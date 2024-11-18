/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin.analytics;

import Business.Business;
import Business.CommonFunction;
import Business.Market.Market;
import Business.SalesPersonRevenue;
import Business.TopProducts;
import Business.Users.User;
import Business.sales.OrderItems;
import Business.sales.PurchaseOrder;
import Business.supplier.Product;
import Business.supplier.Supplier;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author group-11
 */
public class TopSoldProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TopSoldProduct
     */
    JPanel UserProcessJPanel;
    Business business;
    public TopSoldProductJPanel(JPanel UserProcessJPanel, Business business) {
        initComponents();
        this.UserProcessJPanel = UserProcessJPanel;
        this.business=business;
        populateTable();
        
    }
    public void changeTable(JTable table,int column_index) { 
    table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                if (!isSelected) {
//                    int age = Integer.parseInt(table.getValueAt(row, 1).toString());
System.out.println(table.getValueAt(row, 7).toString());
                    boolean check = Boolean.parseBoolean(table.getValueAt(row, 7).toString());
     // you can set your own implementation here. As an example I 
     // have checked if the age is over 20 or not. According to the 
     // age return from the table column you get different background colors. 
                    int req_age = 20;
     // in your case req_age can be rs.getString("column_name"); or something
     // you need to check with..
                    if (!check) {
                        c.setBackground(new Color(255, 101, 18));
                    } else {
                        c.setBackground(new Color(0, 204, 0));
                    }

                }
                return c;
            }
        });
    }
    void populateTable(){
         DefaultTableModel dtm2 = (DefaultTableModel) topTenProductjTable.getModel();

        int rowCount = dtm2.getRowCount();
        for (int i =0; i<rowCount; i++)
        {
            dtm2.removeRow(0);
        }
        dtm2.setRowCount(0);
        ArrayList<TopProducts> spa = new ArrayList<TopProducts>();
        int count = 1;
        
        for(Supplier supplier : business.getSupplierDirectory().getSupplierDirectory()){
            for(Product product : supplier.getProductDirectory().getProduct()){
                int quantity = 0;
                double targetTotal = 0;
                double actual = 0;
                double totalPrice = 0;
                for(PurchaseOrder po: business.getPurchaseOrderCat().getPurchaseOrderCat()){
                    for(OrderItems oi : po.getOrderItemsCat().getOrderItemsCat()){
                        if(oi.getProduct() == product){
                            quantity+= oi.getReqQantity();
                            targetTotal+= oi.getTarget()*oi.getReqQantity();
                            actual += oi.getItemPrice();
                            totalPrice += oi.getTotalPrice();
                        }
                    }
                }
                TopProducts tp = new TopProducts();
                tp.setProduct(product);
                tp.setQuantity(quantity);
                tp.setSupplier(supplier);
                tp.setTargetTotal(targetTotal);
                tp.setActualTotal(actual);
                tp.setItemPriceTotal(totalPrice);
                spa.add(tp);
                
                Collections.sort(spa, new Comparator<TopProducts>() {
                        @Override
                        public int compare(TopProducts sp1, TopProducts sp2) {
                        return (int) (sp2.getQuantity() - sp1.getQuantity());
                        }
                    });
                
                
                
                
            }
        }
        for(TopProducts tp1 : spa){
                    Object row[] = new Object[9];
                    row[0] = count++;
                    row[1] = tp1.getProduct().getProductName();
                    row[2] = tp1.getSupplier().getSupplierName();
                    row[3] = tp1.getQuantity();
                    row[4] = tp1.getItemPriceTotal();
                    row[5] = tp1.getTargetTotal();
                    if(tp1.getItemPriceTotal()>tp1.getTargetTotal()){
                        double gap = tp1.getItemPriceTotal()-tp1.getTargetTotal();
                        row[6] = gap;
                        row[7] = true;
                        row[8] = "Unexpected Revenue";
                        
                    }
                    else{
                        double gap = tp1.getTargetTotal()-tp1.getItemPriceTotal();
                        row[6] = "-"+gap;
                        row[7] = false;
                        row[8] = "Missed Revenue";
                    }
                    dtm2.addRow(row);
        }
        changeTable(topTenProductjTable,6);
        
           
                
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
        topTenProductjTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Top Sold Products");

        topTenProductjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rank", "Product", "Supplier", "Quantity", "Actual", "Target", "Gap", "Above target", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(topTenProductjTable);

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UserProcessJPanel.remove(this);
        CardLayout layout = (CardLayout)UserProcessJPanel.getLayout();
        layout.previous(UserProcessJPanel);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable topTenProductjTable;
    // End of variables declaration//GEN-END:variables
}
