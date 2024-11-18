/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.supplier;

import Business.customer.CustomerDirectory;

/**
 *
 * @author group-11
 */
public class Supplier {
    
    private int supplierId;
    private String supplierName;
    private boolean active;
    private ProductDirectory productDirectory;
    private static int count = 0;
    
    public Supplier(){
        count++;
        supplierId=count;
        productDirectory = new ProductDirectory();
    }
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public ProductDirectory getProductDirectory() {
        return productDirectory;
    }

    public void setProductDirectory(ProductDirectory productDirectory) {
        this.productDirectory = productDirectory;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public String toString()
    {
        return String.valueOf(getSupplierId());
    }
}
