/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import TheBusiness.Entities.Customer;
import TheBusiness.Entities.Item;
import TheBusiness.Entities.Order;
import TheBusiness.Entities.Product;
import TheBusiness.Entities.SalesPerson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author priyamsuthar
 */
public class DataStore {
    private static DataStore dataStore;
    
    private Map<Integer, Product> products;
    private Map<Integer, Item> items;
    private Map<Integer, Order> orders;
    private Map<Integer, Customer> customers;
    private Map<Integer, SalesPerson> salesPersons;
    private DataStore(){
        products = new HashMap<>();
        items = new HashMap<>();
        orders = new HashMap<>();
        customers = new HashMap<>();
        salesPersons = new HashMap<>();
    }
    
    public static DataStore getInstance(){
        if(dataStore == null)
            dataStore = new DataStore();
        return dataStore;
    }

    public static DataStore getDataStore() {
        return dataStore;
    }

    public static void setDataStore(DataStore dataStore) {
        DataStore.dataStore = dataStore;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    public Map<Integer, SalesPerson> getSalesPersons() {
        return salesPersons;
    }

    public void setSalesPersons(Map<Integer, SalesPerson> salesPersons) {
        this.salesPersons = salesPersons;
    }
    
    
    
}
