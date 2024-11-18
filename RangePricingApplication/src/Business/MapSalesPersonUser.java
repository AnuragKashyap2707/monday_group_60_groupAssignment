/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.SalesPerson;
import Business.Users.User;

/**
 *
 * @author group-11
 */
public class MapSalesPersonUser {
   User user;
   SalesPerson salesPerson;
   int mapSalesPersonUserId;
   static int count=0;
   
   public MapSalesPersonUser(){
       count++;
       mapSalesPersonUserId = count;
   }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    public int getMapSalesPersonUserId() {
        return mapSalesPersonUserId;
    }

    public void setMapSalesPersonUserId(int mapSalesPersonUserId) {
        this.mapSalesPersonUserId = mapSalesPersonUserId;
    }
   
    public String toString()
    {
        return String.valueOf(getSalesPerson().getSalesPersonId());
    }
}
