/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.supplier;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class SupplierDirectory {
    
    private ArrayList<Supplier> supplierDirectory;
    
    public SupplierDirectory(){
        supplierDirectory= new ArrayList<>();
    }
    public ArrayList<Supplier> getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(ArrayList<Supplier> supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }
    public Supplier addSupplier(){
        Supplier supplier = new Supplier();
        supplierDirectory.add(supplier);
        return supplier;
    }
    
    public void deleteSupplier(Supplier supplier)
    {
        supplierDirectory.remove(supplier);
    }
    
    public Supplier searchSupplier(int supplierId)
    {
        for(Supplier supplier : supplierDirectory)
        {
            if(supplier.getSupplierId() == supplierId)
            {
                return supplier;
            }
        }
        return null;
    }
    
    public int searchSupplierId(int supplierId)
    {
        for(Supplier supplier : supplierDirectory)
        {
            if(supplier.getSupplierId() == supplierId)
            {
                return supplierId;
            }
        }
        return 0;
    }
    
    public Supplier searchSupplier(String supplierId)
    {
        for(Supplier supplier : supplierDirectory)
        {
            if(supplier.getSupplierName().equals(supplierId))
            {
                return supplier;
            }
        }
        return null;
    }
}
