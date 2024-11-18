/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.sales;

import Business.supplier.Product;
import Business.supplier.Supplier;

/**
 *
 * @author group-11
 */
public class OrderItems {
    Product product;
    Supplier supplier;
    int availableQuantity;
    int reqQantity;
    double totalPrice;
    boolean aboveTarget;
    double target;
    double ceiling;
    double floor;
    double itemPrice;

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

    public double getFloor() {
        return floor;
    }

    public void setFloor(double floor) {
        this.floor = floor;
    }

    public OrderItems()
    {
        product = new Product();
        supplier = new Supplier();
    }
    
    public boolean isAboveTarget() {
        return aboveTarget;
    }

    public void setAboveTarget(boolean aboveTarget) {
        this.aboveTarget = aboveTarget;
    }

    public double getCommissionEarned() {
        return commissionEarned;
    }

    public void setCommissionEarned(double commissionEarned) {
        this.commissionEarned = commissionEarned;
    }
    double commissionEarned;
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getReqQantity() {
        return reqQantity;
    }

    public void setReqQantity(int reqQantity) {
        this.reqQantity = reqQantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
