/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.sales;

import Business.Market.Market;
import Business.Users.User;
import Business.customer.Customer;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author group-11
 */
public class PurchaseOrder {
    User user;
    OrderItemsCat orderItemsCat;

    Customer customer;
    Market market;
    double totalPrice;
    Date date;
    static int count = 0;
    int purId;
    
    
    public PurchaseOrder(){
        count++;
        purId = count;
        date = new Date();
        orderItemsCat = new OrderItemsCat();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderItemsCat getOrderItemsCat() {
        return orderItemsCat;
    }

    public void setOrderItemsCat(OrderItemsCat orderItemsCat) {
        this.orderItemsCat = orderItemsCat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString()
    {
        return String.valueOf(purId);
    }
    
    public int getPurId() {
        return purId;
    }

    public void setPurId(int purId) {
        this.purId = purId;
    }
}
