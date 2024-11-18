/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.Person;
import Business.customer.Customer;

/**
 *
 * @author group-11
 */
public class MapCustomerPerson {
    int mapCusPerId;
    Customer customer;
    Person person;
    
    static int count = 0;
    public MapCustomerPerson(){
        count++;
        mapCusPerId=count;
    }

    public int getMapCusPerId() {
        return mapCusPerId;
    }

    public void setMapCusPerId(int mapCusPerId) {
        this.mapCusPerId = mapCusPerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MapCustomerPerson.count = count;
    }
}
