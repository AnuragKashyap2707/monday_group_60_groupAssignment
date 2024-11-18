/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.supplier.Product;
import Business.supplier.Supplier;

/**
 *
 * @author group-11
 */
public class TopProducts {
    Product product;
    Supplier supplier;
    long quantity;
    double targetTotal;
    double actualTotal;
    double itemPriceTotal;

    public double getItemPriceTotal() {
        return itemPriceTotal;
    }

    public void setItemPriceTotal(double itemPriceTotal) {
        this.itemPriceTotal = itemPriceTotal;
    }

    public double getTargetTotal() {
        return targetTotal;
    }

    public void setTargetTotal(double targetTotal) {
        this.targetTotal = targetTotal;
    }

    public double getActualTotal() {
        return actualTotal;
    }

    public void setActualTotal(double actualTotal) {
        this.actualTotal = actualTotal;
    }

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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
