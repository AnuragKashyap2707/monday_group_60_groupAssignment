/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.supplier;

/**
 *
 * @author group-11
 */
public class Product {
    
    private int productId;
    private String productName;
    private double price;
    private int quantity;//availale quantity
    private boolean avail;
    private static int count =0;
    
    public Product(){
        count++;
        productId=count;
    }
    public Product(String any){
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvail() {
        return avail;
    }

    public void setAvail(boolean avail) {
        this.avail = avail;
    }
    
    public String toString()
    {
        return String.valueOf(productId);
    }
}
