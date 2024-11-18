/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Market.Market;
import Business.Market.MarketOffer;
import Business.Person.Person;
import Business.Person.SalesPerson;
import Business.Users.User;
import Business.customer.Customer;
import Business.sales.OrderItems;
import Business.sales.OrderItemsCat;
import Business.sales.PurchaseOrder;
import Business.sales.PurchaseOrderCat;
import Business.supplier.Product;
import Business.supplier.Supplier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author group-11
 */
public class ConfigureABusiness {
    public void populateUsers(Business business) throws FileNotFoundException, UnsupportedEncodingException{
        String address = "users.csv";
        int i =0;
        Scanner scan = new Scanner(new File(address));
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] la = line.split(",");
                    User user = business.getUserCat().addUser();
                    user.setUserName(la[1]);
                    user.setPerson(business.getPersonDirectory().getPersonDirectory().get(i++));
                    String password = business.getUserCat().get_SHA_512_SecurePassword(la[2], "Fancy");
                    user.setPassword(password);
                    user.setAuth(la[3]);
                    user.setActive(Boolean.parseBoolean(la[4]));
                    System.out.println("Users loaded");
                }
    }
    public void populatePersons(Business business) throws FileNotFoundException, UnsupportedEncodingException{
         String address = "persons.csv";
        Scanner scan = new Scanner(new File(address));
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] la = line.split(",");
                    Person person = business.getPersonDirectory().addPerson();
                    person.setFullName(la[0]);
                    person.setAddress(la[1]);
                    person.setEmail(la[2]);
                    person.setPhoneNum(Long.parseLong((la[3])));
                    System.out.println("Persons loaded");
                }
    }
    public void populateSalesPersons(Business business) throws FileNotFoundException, UnsupportedEncodingException{
        int i = 0;
        for(int j = 0;j<21;j++){
            Person person = business.getPersonDirectory().getPersonDirectory().get(j);
            System.out.println(person);
            SalesPerson sp = business.getSalesPersonDirectory().addSalesPerson();
            sp.setPerson(person);
            sp.setSalary(15000);
            sp.setTargetPrice(10000);
            System.out.println("SalesPerson loaded");
            MapSalesPersonUser mapSalesPersonUser = business.getMapSalesPersonUserDirectory().addMapSalesPersonUser();
            mapSalesPersonUser.setSalesPerson(sp);
            mapSalesPersonUser.setUser(business.getUserCat().getUserCat().get(i++));
        }   
        
    }
    public void simulateSales(Business business,int i){
        for(int k=0;k<=i;k++){
            Random rand = new Random();
            int  randSupplier = rand.nextInt(3);
            int randProduct = rand.nextInt(4);
            int randMarket = rand.nextInt(3);
            int randCustomer = rand.nextInt(3);
            int randUser = rand.nextInt(10)+5;
            
            
            Supplier supplier = business.getSupplierDirectory().getSupplierDirectory().get(randSupplier);
            
            Market market = business.getMarketDirectory().getMarketDirectory().get(randMarket);
            Customer customer = market.getCustomerDirectory().getCustomerDirectory().get(randCustomer);
            
            MarketOffer mo = business.getMarketOfferCatalog().searchMarketOffer(market);
            PurchaseOrder po = business.getPurchaseOrderCat().addPurchaseOrder();
            User user = business.getUserCat().getUserCat().get(randUser);
            
            po.setCustomer(customer);
            po.setMarket(market);
            po.setUser(user);
            
            double totalRevenue = 0;
            
            for(int n = 0; n< rand.nextInt(4)+1 ; n++){
                Product product = supplier.getProductDirectory().getProduct().get(n);
                OrderItems oi = po.getOrderItemsCat().addOrderItems();
                
                double targetPrice = product.getPrice()*(mo.getTargetPrice()+100)/100;
                double ceilingPrice = product.getPrice()*(mo.getCeilingPrice()+100)/100;
                double floorPrice = product.getPrice()*(mo.getFloorPrice()+100)/100;
                oi.setTarget(targetPrice);
                oi.setCeiling(ceilingPrice);
                oi.setFloor(floorPrice);
                oi.setItemPrice(product.getPrice());
                
                oi.setAvailableQuantity(40);
                
                oi.setSupplier(supplier);
                int itemsQuantity = rand.nextInt(40)+1;
                oi.setReqQantity(itemsQuantity);
                
                oi.setProduct(product);
                if(rand.nextBoolean()){
                    double range = ceilingPrice - targetPrice;
                    oi.setAboveTarget(true);
                    System.out.println("rand.nextInt((int)range:"+String.valueOf(rand.nextInt((int)range)));
                    System.out.println("Floor:"+String.valueOf(floorPrice));
                    System.out.println("Target"+String.valueOf(targetPrice));
                    System.out.println("Ceiling"+String.valueOf(ceilingPrice));
                   
                    //itemsQuantity*(targetPrice+ rand.nextInt((int)range))
                    oi.setTotalPrice(targetPrice+ rand.nextInt((int)range));
                    
                    double totalPrice = oi.getTotalPrice();
                     System.out.println("Actual"+String.valueOf(totalPrice));
                    oi.setCommissionEarned(mo.getCommissionAboveTarget()*totalPrice/100);
                }
                
                else{
                    double range = targetPrice - floorPrice;
                    oi.setAboveTarget(false);
                    oi.setTotalPrice(targetPrice- rand.nextInt((int)range));
                    double totalPrice = oi.getTotalPrice();
                    oi.setCommissionEarned(mo.getCommissionAboveTarget()*totalPrice/100); 
                }
                totalRevenue += oi.getTotalPrice();
            }
            
            
            po.setTotalPrice(totalRevenue);
        }
    }
    public void populateMarket(Business business) throws FileNotFoundException, UnsupportedEncodingException{
         String address = "markets.csv";
        Scanner scan = new Scanner(new File(address));
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    int totalCustomers = 0;
                    String[] la = line.split(",");
                    Market market = business.getMarketDirectory().addMarket();
                    market.setMarketType(la[0]);
                    Customer cus = market.getCustomerDirectory().addCustomer();
                    cus.setCustomerId(1);
                    cus.setCustomerName(la[1]);
                    Customer cus2 = market.getCustomerDirectory().addCustomer();
                    cus2.setCustomerId(2);
                    cus2.setCustomerName(la[2]);
                    Customer cus3 = market.getCustomerDirectory().addCustomer();
                    cus3.setCustomerId(3);
                    cus3.setCustomerName(la[3]);
                    MarketOffer mo = business.getMarketOfferCatalog().addMarketOffer();
                    mo.setMarket(market);
                    mo.setFloorPrice(Double.valueOf(la[4]));
                    mo.setTargetPrice(Double.valueOf(la[5]));
                    mo.setCeilingPrice(Double.valueOf(la[6]));
                    mo.setCommissionBelowTarget(Double.valueOf(la[7]));
                    mo.setCommissionAboveTarget(Double.valueOf(la[8]));
                                        
                    System.out.println("Market loaded");
                }
    }
    public void populateSuppliers(Business business) throws FileNotFoundException, UnsupportedEncodingException{
        String address = "suppliers.csv";
        Scanner scan = new Scanner(new File(address));
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] la = line.split(",");
                    Supplier supplier = business.getSupplierDirectory().addSupplier();
                    supplier.setSupplierName(la[0]);
                    supplier.setActive(Boolean.parseBoolean(la[1]));
                    String addressProduct = "products.csv";
                    Scanner scanProduct = new Scanner(new File(addressProduct));
                    while (scanProduct.hasNextLine()) {
                        String pline = scanProduct.nextLine();
                        String[] pla = pline.split(",");
                        Product product = supplier.getProductDirectory().addProduct();
                        String name = la[2] +" "+ pla[0];
                        product.setProductName(name);
                        System.out.println(pla[1]);
                        product.setPrice(Double.parseDouble(pla[1]));
                        product.setQuantity(Integer.parseInt(pla[2]));
                        product.setAvail(Boolean.parseBoolean(pla[3]));
                    }
                    System.out.println("Suppliers loaded");
                }
    }
    public void populatePurchaseOrderCat(Business business){
        PurchaseOrderCat poc = business.getPurchaseOrderCat();
        PurchaseOrder po = poc.addPurchaseOrder();
        po.setCustomer(business.getMarketDirectory().getMarketDirectory().get(0).getCustomerDirectory().getCustomerDirectory().get(0));
        po.setMarket(business.getMarketDirectory().getMarketDirectory().get(0));
        po.setTotalPrice(100);
        po.setUser(business.getUserCat().getUserfromId(3));
        OrderItemsCat oc = po.getOrderItemsCat();
        OrderItems o = oc.addOrderItems();
        o.setAvailableQuantity(40);
        o.setReqQantity(20);
        o.setCommissionEarned(300);
        o.setAboveTarget(true);
        o.setProduct(business.getSupplierDirectory().getSupplierDirectory().get(0).getProductDirectory().getProduct().get(0));
        o.setSupplier(business.getSupplierDirectory().getSupplierDirectory().get(0));
    }
}
