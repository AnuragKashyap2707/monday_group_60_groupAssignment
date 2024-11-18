/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class MapCustomerPersonDirectory {
    ArrayList<MapCustomerPerson> mapCustomerPersonDirectory;
    
    public MapCustomerPersonDirectory(){
        mapCustomerPersonDirectory = new ArrayList<MapCustomerPerson>();
    }
    public MapCustomerPerson addMapCustomerPerson(){
        MapCustomerPerson a = new MapCustomerPerson();
        mapCustomerPersonDirectory.add(a);
        return a;
    }
    public void deleteMapCustomerPerson(MapCustomerPerson a){
        mapCustomerPersonDirectory.remove(a);
    }

    public ArrayList<MapCustomerPerson> getMapCustomerPersonDirectory() {
        return mapCustomerPersonDirectory;
    }

    public void setMapCustomerPersonDirectory(ArrayList<MapCustomerPerson> mapCustomerPersonDirectory) {
        this.mapCustomerPersonDirectory = mapCustomerPersonDirectory;
    }
}
