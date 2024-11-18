/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Entities;

/**
 *
 * @author group-11
 */
public class Item {
    
    int productId;
    int salesPrice;
    int quantity;

    public Item(int productId, int salesPrice, int quantity) {
        this.productId = productId;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String toString(){
        return "ProductID: "+this.productId+", Sales Price: "+this.salesPrice+", Quantity: "+this.quantity;
    }
}
