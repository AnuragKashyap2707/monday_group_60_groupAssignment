/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import Business.customer.Customer;
import Business.customer.CustomerDirectory;
import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class Market {
 
    private String marketType;
    private int marketId;
    private CustomerDirectory customerDirectory;
    private static int count = 0;
    private int totalCustomers = 0;
    
    public Market()
    {
        count++;
        marketId = count;
        customerDirectory = new CustomerDirectory();
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public int getTotalCustomers() {
        
        for(Customer customer : customerDirectory.getCustomerDirectory())
        {
            totalCustomers ++;
        }
        return totalCustomers;
    }

    
    @Override
    public String toString()
    {
        return String.valueOf(marketId);
    }
    

}
