/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.customer;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class CustomerDirectory {
    
    private ArrayList<Customer> customerDirectory;
    
    public CustomerDirectory()
    {
        customerDirectory = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(ArrayList<Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
    public Customer addCustomer()
    {
        Customer customer  = new Customer();
        customerDirectory.add(customer);
        return customer;
    }
    
    public void deleteCustomer(Customer customer)
    {
        customerDirectory.remove(customer);
    }
    
    public Customer searchCustomer(int customerId)
    {
        for(Customer customer : customerDirectory)
        {
            if(customer.getCustomerId() == customerId)
            {
                return customer;
            }
        }
        return null;
    }
    public Customer searchCustomer(String customerId)
    {
        for(Customer customer : customerDirectory)
        {
            if(customer.getCustomerName().endsWith(customerId))
            {
                return customer;
            }
        }
        return null;
    }
}
