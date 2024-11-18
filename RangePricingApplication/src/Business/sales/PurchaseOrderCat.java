/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.sales;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class PurchaseOrderCat {
    ArrayList<PurchaseOrder> purchaseOrderCat;
    
    public PurchaseOrderCat(){
        purchaseOrderCat = new ArrayList<>();
    }

    public ArrayList<PurchaseOrder> getPurchaseOrderCat() {
        return purchaseOrderCat;
    }

    public void setPurchaseOrderCat(ArrayList<PurchaseOrder> purchaseOrderCat) {
        this.purchaseOrderCat = purchaseOrderCat;
    }
    
    public PurchaseOrder addPurchaseOrder(){
        PurchaseOrder po = new PurchaseOrder();
        purchaseOrderCat.add(po);
        return po;
    }
    public void deletePurchaseOrder(PurchaseOrder po){
        purchaseOrderCat.remove(po);
    }

    public void deleteAllPurchaseOrder() {
        purchaseOrderCat = null;
        purchaseOrderCat = new ArrayList<>();
    }
}
