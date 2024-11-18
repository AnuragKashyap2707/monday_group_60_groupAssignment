/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.sales;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class OrderItemsCat {
    ArrayList<OrderItems> orderItemsCat;

    public ArrayList<OrderItems> getOrderItemsCat() {
        return orderItemsCat;
    }

    public void setOrderItemsCat(ArrayList<OrderItems> orderItemsCat) {
        this.orderItemsCat = orderItemsCat;
    }
    
    public OrderItemsCat(){
        orderItemsCat = new ArrayList<>();
    }
    
    public OrderItems addOrderItems(){
        OrderItems ot = new OrderItems();
        orderItemsCat.add(ot);
        return ot;
    }
    public void deleteOrderItems(OrderItems ot){
        orderItemsCat.remove(ot);
    }
}
