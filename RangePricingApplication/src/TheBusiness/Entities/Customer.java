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
public class Customer {
    private int customerID;
    private ArrayList<Order> orderList;

    public Customer(int customerID){
        this.customerID = customerID;
        orderList = new ArrayList<>();
    }
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    @Override
    public String toString(){
        return "CustomerID: "+this.customerID+", Orders:"+this.orderList+"\n";
    } 
    
}
