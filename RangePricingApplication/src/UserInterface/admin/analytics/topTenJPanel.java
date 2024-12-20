/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin.analytics;

import Business.Business;
import Business.CommonFunction;
import Business.Market.Market;
import Business.Person.SalesPerson;
import Business.SalesPersonRevenue;
import Business.Users.User;
import Business.sales.OrderItems;
import Business.sales.PurchaseOrder;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author group-11
 */
public class topTenJPanel extends javax.swing.JPanel {

    /**
     * Creates new form topTenJPanel
     */
    JPanel UserProcessJPanel;
    Business business;
    public topTenJPanel(JPanel UserProcessJPanel, Business business) {
        initComponents();
        this.UserProcessJPanel = UserProcessJPanel;
        this.business=business;
        populateTable();
    }
    public void populateTable()
    {

        DefaultTableModel dtm2 = (DefaultTableModel) topPerformingjTable.getModel();

        int rowCount = dtm2.getRowCount();
        for (int i =0; i<rowCount; i++)
        {
            dtm2.removeRow(0);
        }
        dtm2.setRowCount(0);
        CommonFunction cf = new CommonFunction();
        double targetTotal = 0;
            for(Market market : business.getMarketDirectory().getMarketDirectory()){
                Object row[] = new Object [15];
                ArrayList<SalesPersonRevenue> spa = new ArrayList<SalesPersonRevenue>();
                for(User user : business.getUserCat().getUserCat()){
                    double revenue = 0;
                    SalesPersonRevenue sp = new SalesPersonRevenue();
                    for(PurchaseOrder po : business.getPurchaseOrderCat().getPurchaseOrderCat())
                    {
                        if(po.getMarket()==market && po.getUser()==user){
                          revenue += po.getTotalPrice();
                          targetTotal+= cf.getTarget(business, market, po);
                        }   
                     }
                    sp.setRevenue(revenue);
                    sp.setUser(user);
                    sp.setTargetTotal(targetTotal);
                    spa.add(sp);
                    Collections.sort(spa, new Comparator<SalesPersonRevenue>() {
                        @Override
                        public int compare(SalesPersonRevenue sp1, SalesPersonRevenue sp2) {
                        return (int) (sp2.getRevenue() - sp1.getRevenue());
                        }
                    });
                    for(SalesPersonRevenue ps : spa){
                        System.out.println(market.getMarketType());
                        System.out.println(ps.getRevenue());
                    }  
                }
                row[0] =market.getMarketType();
                row[1] = spa.get(0).getUser().getUserName();
                row[2] = spa.get(0).getRevenue();
                row[3] = spa.get(1).getUser().getUserName();
                row[4] = spa.get(1).getRevenue();
                row[5] = spa.get(2).getUser().getUserName();
                row[6] = spa.get(2).getRevenue();
                row[7] = spa.get(3).getUser().getUserName();
                row[8] = spa.get(3).getRevenue();
                row[9] = spa.get(4).getUser().getUserName();
                row[10] = spa.get(4).getRevenue();
                row[11] = spa.get(5).getUser().getUserName();
                row[12] = spa.get(5).getRevenue();
                dtm2.addRow(row);
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
        topPerformingjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();

        topPerformingjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Market", "1 Sales Person", "Revenue", "2 Sales Person", "Revenue", "3 Sales Person", "Revenue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(topPerformingjTable);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Top Performing Sales Person");

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backjButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backjButton)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessJPanel.remove(this);
        CardLayout layout = (CardLayout)UserProcessJPanel.getLayout();
        layout.previous(UserProcessJPanel);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable topPerformingjTable;
    // End of variables declaration//GEN-END:variables
}
