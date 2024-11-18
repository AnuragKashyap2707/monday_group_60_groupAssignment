/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Users.User;
import Business.supplier.Supplier;
import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class MapSupplierUser {
    
   User user;
   Supplier supplier;
   int mapSupplierUserId;
   static int count=0;

    public int getMapSupplierUserId() {
        return mapSupplierUserId;
    }

    public void setMapSupplierUserId(int mapSupplierUserId) {
        this.mapSupplierUserId = mapSupplierUserId;
    }
   
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
   @Override
    public String toString()
    {
    return String.valueOf(getSupplier().getSupplierId());
    }
    
}
