/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Entities;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class SalesPerson {
    private int salesID;
    private ArrayList<Order> orderList;

    public SalesPerson(int salesID){
        this.salesID = salesID;
        orderList = new ArrayList<>();
    }
    
    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    @Override
    public String toString(){
        return "SalesID: "+this.salesID+", Orders:"+this.orderList+"\n";
    } 
}
