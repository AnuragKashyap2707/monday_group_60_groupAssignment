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
import java.io.IOException;

/**
 *
 * @author kasai
 */
public class DataEntry {
    
    public static void main(String args[]) throws IOException{
        
        DataGenerator generator = DataGenerator.getInstance();
        DataStore dataStore = DataStore.getInstance(); 
        AnalysisHelper helper = new AnalysisHelper();
        
        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        
        DataReader orderReader = new DataReader(generator.getOrderFilePath());
        String[] orderRow;
        printRow(orderReader.getFileHeader());
        int k=0;
        while((orderRow = orderReader.getNextRow()) != null){
            k++;
            if(k<=10)
                printRow(orderRow);
            Item item = new Item(Integer.parseInt(orderRow[2]),Integer.parseInt(orderRow[6]),Integer.parseInt(orderRow[3]));
            dataStore.getItems().put(Integer.parseInt(orderRow[1]), item);
            Order order = new Order(Integer.parseInt(orderRow[0]), Integer.parseInt(orderRow[4]), Integer.parseInt(orderRow[5]), item);
            dataStore.getOrders().put(Integer.parseInt(orderRow[0]), order);
            
            //Customers
            
            if(dataStore.getCustomers().containsKey(Integer.parseInt(orderRow[5]))){
                dataStore.getCustomers().get(Integer.parseInt(orderRow[5])).getOrderList().add(order);
            }else{
                Customer customer = new Customer(Integer.parseInt(orderRow[5]));
                customer.getOrderList().add(order);
                dataStore.getCustomers().put(Integer.parseInt(orderRow[5]), customer);
            }
            //Sales Person
            if(dataStore.getSalesPersons().containsKey(Integer.parseInt(orderRow[4]))){
                dataStore.getSalesPersons().get(Integer.parseInt(orderRow[4])).getOrderList().add(order);
            }else{
                SalesPerson s = new SalesPerson(Integer.parseInt(orderRow[4]));
                s.getOrderList().add(order);
                dataStore.getSalesPersons().put(Integer.parseInt(orderRow[4]), s);
            }
                   
        }

        System.out.println("_____________________________________________________________");
        System.out.println(dataStore.getOrders());
        DataReader productReader = new DataReader(generator.getProductCataloguePath());
        String[] prodRow;
        printRow(productReader.getFileHeader());
        while((prodRow = productReader.getNextRow()) != null){
//            printRow(prodRow);
            Product p = new Product(Integer.parseInt(prodRow[1]), Integer.parseInt(prodRow[2]), Integer.parseInt(prodRow[3]),Integer.parseInt(prodRow[0]));
            dataStore.getProducts().put(Integer.parseInt(prodRow[0]), p);
        }
        System.out.println("_____________________________________________________________");
        System.out.println(dataStore.getProducts());
         
        
        
        //  QUESTION 1 - Top 3 Best Negotiated Products
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        System.out.println("QUESTION 1 - Our Top 3 best Negotiated Products");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        //----------------------FUNCTION CALL-----------------------------------
        helper.top3NegotiatedProducts(dataStore);
        //----------------------------------------------------------------------
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        
        
         //  QUESTION 2 - Our Top 3 Customers without Quantity in consideration
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        System.out.println("QUESTION 2 - Our Top 3 Customers without Quantity in consideration");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        //----------------------FUNCTION CALL-----------------------------------
        helper.top3Customers(dataStore,0);
        //----------------------------------------------------------------------
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        
        
        System.out.println("QUESTION 2 - Our Top 3 Customers with Quantity in consideration");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        //----------------------FUNCTION CALL-----------------------------------
        helper.top3Customers(dataStore,1);
        //----------------------------------------------------------------------
         System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        
        //  QUESTION 3 - Our Top 3 Best Sales Person
        
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        System.out.println("QUESTION 3 - Our Top 3 Best Sales Person");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        //----------------------FUNCTION CALL-----------------------------------
        helper.top3SalesPerson(dataStore);
        //----------------------------------------------------------------------
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");

        //  QUESTION 4 - Our Total Revenue for the Year
        
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        System.out.println("QUESTION 4 - Our Total Revenue for the Year");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
        //----------------------FUNCTION CALL-----------------------------------
        helper.totalRevenue(dataStore);
        //----------------------------------------------------------------------
        System.out.println("");
        for(int i=0;i<100;i++)
            System.out.print("-");
        System.out.println("");
         
        
        generator.generateOriginalStatsFile(helper.computeStats(dataStore));
        
        helper.modifyData();
         
    }
    
    
    
    public static void printRow(String[] row){
        for (String row1 : row) {
            System.out.print(row1 + ", ");
        }
        System.out.println("");
    }
    
}
