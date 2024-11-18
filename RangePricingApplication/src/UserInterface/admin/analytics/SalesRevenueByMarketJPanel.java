/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.admin.analytics;

import Business.Business;
import Business.CommonFunction;
import Business.Market.Market;
import Business.Market.MarketOffer;
import Business.sales.OrderItems;
import Business.sales.PurchaseOrder;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author group-11
 */
public class SalesRevenueByMarketJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SalesRevenueByMarketJPanel
     */JPanel UserProcessJPanel;
    Business business;
    public SalesRevenueByMarketJPanel(JPanel UserProcessJPanel, Business business) {
        initComponents();
        this.UserProcessJPanel=UserProcessJPanel;
        this.business=business;
        populateTable();
    }
    private CategoryDataset createDataset( ) {
      int salesAboveTarget = 0;
      int numberOfItems = 0;
      
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 
      for(MarketOffer mo : business.getMarketOfferCatalog().getMarketOfferCatalog()){
          for(PurchaseOrder po : business.getPurchaseOrderCat().getPurchaseOrderCat()){
              if(po.getMarket() == mo.getMarket()){
                  for(OrderItems oi : po.getOrderItemsCat().getOrderItemsCat()){
                      if(oi.isAboveTarget()){
                          salesAboveTarget++;
                      }
                      numberOfItems += oi.getReqQantity();
              }
            
           }
        dataset.addValue( po.getTotalPrice() , po.getMarket().getMarketType() , "Total Sales" );        
        dataset.addValue( salesAboveTarget , po.getMarket().getMarketType() , "Above Target" );
        dataset.addValue( numberOfItems, po.getMarket().getMarketType() , "Number of Items" ); 
      }  
      }
                  

      return dataset; 
   }
    public void BarChart_AWT( String applicationTitle , String chartTitle ){
     JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
        ChartFrame frame = new ChartFrame(applicationTitle, barChart);
        frame.pack();
        frame.setVisible(true);
   }
     public void populateTable()
    {

        DefaultTableModel dtm2 = (DefaultTableModel) salesRevenueMarketjTable.getModel();

        int rowCount = dtm2.getRowCount();
        int count = 0;
        

        for (int i =0; i<rowCount; i++)
        {
            dtm2.removeRow(0);
        }
        
        CommonFunction cf = new CommonFunction();
        
        dtm2.setRowCount(0);
        //try {
            for(Market market : business.getMarketDirectory().getMarketDirectory()){
                count ++;
                Object row[] = new Object [10];
                row[0] = count;
                row[1] = market.getMarketType();
                int totalPurchaseOrder = 0;
                int salesAboveTarget = 0;
                double totalTarget = 0;
                int numberOfItems = 0;
                double totalMarketRevenue = 0;
                for(PurchaseOrder po : business.getPurchaseOrderCat().getPurchaseOrderCat())
                {
                    
                    if(po.getMarket()==market){
                        totalPurchaseOrder++;
                        for(OrderItems oi : po.getOrderItemsCat().getOrderItemsCat()){
                            if(oi.isAboveTarget()){
                                salesAboveTarget++;
                            }
                            numberOfItems += oi.getReqQantity();
                            System.out.println("OI Target : "+String.valueOf(oi.getTarget()));
                            System.out.println("OI Total Price : "+String.valueOf(oi.getTotalPrice()));
                            totalTarget+= cf.getTotalTarget(business, po);
                            totalMarketRevenue += po.getTotalPrice();
                            
                            System.out.println("totalTarget : "+String.valueOf(totalTarget));
                            System.out.println("totalMarketRevenue : "+String.valueOf(totalMarketRevenue));
                        }
                        
                        
                    
                    
                    
                    }
                    

                }
                row[2] = salesAboveTarget;
                row[3] = totalPurchaseOrder;
                row[4] = numberOfItems;
                row[5] = totalMarketRevenue;
                row[6] = totalTarget;
                if(totalTarget<totalMarketRevenue){
                    row[7] = (totalMarketRevenue-totalTarget);
                    row[8] = "UnExpected Revenue";
                }
                else
                {
                    row[7] = (totalTarget-totalMarketRevenue);
                    row[8] = "Missed Revenue";
                }
                
                dtm2.addRow(row);
            }
                
            
//        }
//        catch(Exception e){
//            System.out.println("No values in DB");
//        }
    
    }
      public JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Sales Performance",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
      private PieDataset createDatasetpie( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      for(MarketOffer mo : business.getMarketOfferCatalog().getMarketOfferCatalog()){
          double totalMarketRev = 0;
          for(PurchaseOrder po : business.getPurchaseOrderCat().getPurchaseOrderCat()){
              if(po.getMarket() == mo.getMarket()){
                  totalMarketRev+=po.getTotalPrice();
                          
              }
            
           }
        dataset.setValue( "Market: "+String.valueOf(mo.getMarket().getMarketType()) , totalMarketRev );  
      }  
       
      return dataset;         
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
        salesRevenueMarketjTable = new javax.swing.JTable();
        salesBarChartjButton = new javax.swing.JButton();
        salesRevPiejButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sales Revenue By Market ");

        salesRevenueMarketjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno.", "Market", "Sales Above Target", "Total Purchase Order", "Total number of Products Sold", "Total Revenue", "Target Revenue", "Gap Revenue", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(salesRevenueMarketjTable);
        if (salesRevenueMarketjTable.getColumnModel().getColumnCount() > 0) {
            salesRevenueMarketjTable.getColumnModel().getColumn(3).setResizable(false);
            salesRevenueMarketjTable.getColumnModel().getColumn(5).setResizable(false);
        }

        salesBarChartjButton.setText("Sales Bar Chart");
        salesBarChartjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBarChartjButtonActionPerformed(evt);
            }
        });

        salesRevPiejButton.setText("Sales Revenue Pie  Graph");
        salesRevPiejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesRevPiejButtonActionPerformed(evt);
            }
        });

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salesRevPiejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salesBarChartjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesBarChartjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesRevPiejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salesBarChartjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBarChartjButtonActionPerformed
        BarChart_AWT( "Sales By Market Chart" , "Sales By Market Chart");
    }//GEN-LAST:event_salesBarChartjButtonActionPerformed

    private void salesRevPiejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesRevPiejButtonActionPerformed
        JFreeChart chart = createChart(createDatasetpie());
        ChartFrame frame = new ChartFrame("Results", chart);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_salesRevPiejButtonActionPerformed

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
    private javax.swing.JButton salesBarChartjButton;
    private javax.swing.JButton salesRevPiejButton;
    private javax.swing.JTable salesRevenueMarketjTable;
    // End of variables declaration//GEN-END:variables
}
