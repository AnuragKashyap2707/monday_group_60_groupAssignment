
package TheBusiness.OrderManagement;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class MasterOrderReport {
    ArrayList<OrderSummary> ordersummarylist;
    
    public MasterOrderReport(){
        
        ordersummarylist = new ArrayList();
        
    }
    public void generateOrderReport(ArrayList<Order> orders){
        ArrayList<Order> orderlist = orders;
        OrderSummary ordersummary ;
        for(Order order: orderlist){
            ordersummary = new OrderSummary(order);
            ordersummarylist.add(ordersummary);
        }         
    }
    
    public OrderSummary getTopProfitableOrder(){ //most profitable order
        OrderSummary currenttoporder = null;
        
        for (OrderSummary os: ordersummarylist){
            if(currenttoporder == null)currenttoporder= os; // initial step 
            else 
                if(os.getOrderProfit()> currenttoporder.getOrderProfit()){
                currenttoporder = os; //we have a new higher total
            }
                }
        return currenttoporder;
    }
}

