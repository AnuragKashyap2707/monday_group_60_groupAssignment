/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.customer;

import Business.Person.Person;

/**
 *
 * @author group-11
 */
public class Customer {
    
    private Person person;
    private int customerId;
    private String customerName;
    private static int count = 0;
    
    public Customer()
    {
        count++;
        customerId = count;
        person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    } 

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String toString()
    {
        return String.valueOf(customerId);
    }
}
