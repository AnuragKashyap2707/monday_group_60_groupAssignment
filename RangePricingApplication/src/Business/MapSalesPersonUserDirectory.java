/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.SalesPerson;
import Business.Users.User;
import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class MapSalesPersonUserDirectory {
    ArrayList<MapSalesPersonUser> mapSalesPersonUserDirectory;
    
    public MapSalesPersonUserDirectory(){
        mapSalesPersonUserDirectory=new ArrayList<MapSalesPersonUser>();
    }

    public ArrayList<MapSalesPersonUser> getMapSalesPersonUserDirectory() {
        return mapSalesPersonUserDirectory;
    }

    public void setMapSalesPersonUserDirectory(ArrayList<MapSalesPersonUser> mapSalesPersonUserDirectory) {
        this.mapSalesPersonUserDirectory = mapSalesPersonUserDirectory;
    }
    public MapSalesPersonUser addMapSalesPersonUser(){
        MapSalesPersonUser ma = new MapSalesPersonUser();
        mapSalesPersonUserDirectory.add(ma);
        return ma;
    }
    public void deleteMapSalesPersonUser(MapSalesPersonUser ma){
        mapSalesPersonUserDirectory.remove(ma);
    }
    
    public SalesPerson getSalesPerson(User user)
    {
        for(MapSalesPersonUser sp : mapSalesPersonUserDirectory)
        {
            if(sp.getUser().equals(user))
            {
                return sp.getSalesPerson();
            }
        }
        return null;
    }
}
