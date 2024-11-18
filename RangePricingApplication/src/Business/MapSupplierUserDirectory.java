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
public class MapSupplierUserDirectory {
    
    ArrayList<MapSupplierUser> mapSupplierUserDirectory;
    
    public MapSupplierUserDirectory(){
         mapSupplierUserDirectory = new ArrayList<MapSupplierUser>();
    }
    
    public ArrayList<MapSupplierUser> getMapSupplierUserDirectory() {
        return mapSupplierUserDirectory;
    }

    public void setMapSupplierUserDirectory(ArrayList<MapSupplierUser> mapSupplierUserDirectory) {
        this.mapSupplierUserDirectory = mapSupplierUserDirectory;
    }
    
    public MapSupplierUser addSupplierUser()
    {
    MapSupplierUser s=new MapSupplierUser();
    mapSupplierUserDirectory.add(s);
    return(s);
    
    }
    
    public void deleteSupplierUser(MapSupplierUser s)
    {
    mapSupplierUserDirectory.remove(s);
    }
    public Supplier searchSupplier(User user){
        for(MapSupplierUser ma : mapSupplierUserDirectory){
            if(ma.getUser()==user)
            {
                return ma.getSupplier();
            }
        }
        return null;
        
    }
    
    
}
