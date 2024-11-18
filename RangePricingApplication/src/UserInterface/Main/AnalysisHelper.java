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
import TheBusiness.Entities.StatsProduct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author priyamsuthar
 */
public class AnalysisHelper {
    
    
    private final String ORIGINAL_FILE_PATH = "./OriginalStatsData.csv";
    private final String PROD_CAT_PATH = "./ProductCatalogue.csv";
    private final String UPDATED_PROD_CAT_PATH = "./UpdatedProductCatalogue.csv";
    private final String MODIFIED_FILE_PATH = "./ModifiedStatsData.csv";
    private final String PRODUCT_HEADER = "Product-Id,Min-Price,Max-Price,Target-Price";
    private final String MODIFIED_HEADER = "Product-Id,Average-SalesPrice,Modfied-Target-Price, Difference, Error-Percentage,Section";
    private final String LINE_BREAK = "\n";
    private FileWriter writer;
    private File file;
    
    public void top3NegotiatedProducts(DataStore dataStore){
        
        //Storing the SalesQuantity of the Products sold above Target Price in a HashMap
        
        Map<Integer, Integer> products = new HashMap<>();
        Map<Integer, Integer> productTotalQuantity = new HashMap<>();
        for(Map.Entry<Integer,Order> entry:dataStore.getOrders().entrySet()){
            Item i = entry.getValue().getItem();
            if(i.getSalesPrice() > dataStore.getProducts().get(i.getProductId()).getTarget()){
                //Calculate the Total Sales Quantity and store in the Product HashMap with ID
                //int profit;
                //profit = i.getQuantity()*(i.getSalesPrice()-dataStore.getProducts().get(i.getProductId()).getTarget());
                int salesQuantity = i.getQuantity();
                if(products.containsKey(i.getProductId())){
                    int p = products.get(i.getProductId());
                    int value = p+salesQuantity;
                    products.put(i.getProductId(), value);
                }else{
                    products.put(i.getProductId(), salesQuantity);
                }
            }else{
                if(!products.containsKey(i.getProductId()))
                    products.put(i.getProductId(), 0);
               
            }
             if(productTotalQuantity.containsKey(i.getProductId())){
                    int quantity = i.getQuantity();
                    int real = productTotalQuantity.get(i.getProductId()) + quantity;
                    productTotalQuantity.put(i.getProductId(), real);
                }else{
                    productTotalQuantity.put(i.getProductId(), i.getQuantity());
                }
            
        }
        //Sort the Products based on the salesQuantity
        List<Map.Entry<Integer, Integer> > list =  new LinkedList<Map.Entry<Integer, Integer> >(products.entrySet()); 
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2 ){
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        
        List<Product> result = new ArrayList<>();
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        List<Integer> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> aa : list) {       //Storing Sorted Values
            temp.put(aa.getKey(), aa.getValue()); 
            arr.add(aa.getValue());
        } 
        
        int[] top3 = new int[3];
        findTop3(arr, top3);
        
        //Converting to hash set
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<3;i++){
            hs.add(top3[i]);
        }
        
        Map<Integer, Integer> total = new HashMap<>();
             
        for (Map.Entry<Integer, Integer> aa : list) {        
            if(hs.contains(aa.getValue())){
                result.add(dataStore.getProducts().get(aa.getKey()));
                total.put(aa.getKey(),aa.getValue());
            }
                
        } 
        
        System.out.println(temp+"\n");
        int i=0;
        
        
        
        for(Product p : result){
            int pID = p.getProductID();
            
            int index = findIndex(top3, total.get(pID));
            System.out.println("Rank-"+(index+1));
            System.out.println("   "+p);
            System.out.println("   Total Sales Quantity: "+productTotalQuantity.get(pID));
            System.out.println("   Sales Quantity [Above Target Price]: " + total.get(pID));
            System.out.println("\n");
            
            i++;
        }
    }
    
    private int findIndex(int []top3, int value){
        for(int i=0;i<top3.length;i++){
            if(top3[i]==value)
                return i;
        }
        return -1;
    }

    private void findTop3(List<Integer> arr, int[] top3) {
       top3[0] = arr.get(0);
       int i=0;
       int j=1;
       while(true){
           if(top3[i]!=arr.get(j)){
               top3[++i] = arr.get(j);
               if(i==2)
                   break;  
           }
           j++;
       }
//        System.out.println("Top 3:");
//       for(Integer number: top3){
//           System.out.println(number);
//       }
    }
    
    public void top3Customers(DataStore dataStore,int flag)
    {
        Map<Integer, Integer> customers = new HashMap<>();
        for(Map.Entry<Integer,Customer> entry:dataStore.getCustomers().entrySet()){
            int customerValue=0;
            for(Order order: entry.getValue().getOrderList())
            {
                Item item = order.getItem();
                Product product= dataStore.getProducts().get(item.getProductId());
                if(item.getSalesPrice()>product.getTarget())
                {
                    if(flag==0)
                        customerValue=(int) (customerValue+item.getSalesPrice()-product.getTarget());
                    else
                        customerValue=(int) (customerValue+((item.getSalesPrice()-product.getTarget())*item.getQuantity()));
                }
            }
//            System.out.println(entry.getKey()+" : "+customerValue);
            customers.put(entry.getKey(), customerValue);
        }
        
         List<Map.Entry<Integer, Integer> > list =  new LinkedList<Map.Entry<Integer, Integer> >(customers.entrySet()); 
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2 ){
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        
        int value=list.get(0).getValue();
        int count=0;
        System.out.println("Rank-1");
        for(Map.Entry<Integer,Integer> entry:list)
        {
            if(entry.getValue()!=value)
            {
                value=entry.getValue();
                count++;
                if(count<3)
                {
                    System.out.println("\n");
                    int rank=count+1;
                    System.out.println("Rank-"+rank);
                }
            }
            if(count==3)
                break;
            System.out.println("Customer ID: "+entry.getKey()+","+" Customer Value: "+entry.getValue());
        }
    }
    
    public void totalRevenue(DataStore dataStore)
    {
       int profit=0;
       for(Map.Entry<Integer,SalesPerson> entry:dataStore.getSalesPersons().entrySet()){
            for(Order order: entry.getValue().getOrderList())
            {
                Item item = order.getItem();
                Product product= dataStore.getProducts().get(item.getProductId());
                if(item.getSalesPrice()>product.getTarget())
                {
                    profit=(int) (profit+((item.getSalesPrice()-product.getTarget())*item.getQuantity()));
                }
                
            }
        }
        System.out.println("Total Revenue: "+profit);
    }
//public void totalMarginalRevenueByMarket(DataStore dataStore) {
//    Map<String, Integer> marketRevenue = new HashMap<>();
//
//    for(Map.Entry<Integer, SalesPerson> entry : dataStore.getSalesPersons().entrySet()) {
//        for(Order order : entry.getValue().getOrderList()) {
//            Item item = order.getItem();
//            Product product = dataStore.getProducts().get(item.getProductId());
//            String market = product.getMarket(); // Assuming a method to get the market of the product
//
//            // Calculate the marginal revenue for this item
//            int marginalRevenue = (item.getSalesPrice() - product.getTarget()) * item.getQuantity();
//
//            // Add or subtract the marginal revenue from the market's total, depending on if it's positive or negative
//            marketRevenue.put(market, marketRevenue.getOrDefault(market, 0) + marginalRevenue);
//        }
//    }
//
//    // Display the total marginal revenue for each market
//    for(Map.Entry<String, Integer> marketEntry : marketRevenue.entrySet()) {
//        String status = marketEntry.getValue() >= 0 ? "above" : "below";
//        System.out.println("Market " + marketEntry.getKey() + " is " + status + " expected target with a total marginal revenue of: " + marketEntry.getValue());
//    }
//}


    
    public void top3SalesPerson(DataStore dataStore){
        
        //Storing the profit of the each Sales Person in a HashMap
        Map<Integer, Integer> salesPersonProfit = new HashMap<>();
        for(Map.Entry<Integer,SalesPerson> salesPerson : dataStore.getSalesPersons().entrySet()){
            
            SalesPerson sp = salesPerson.getValue();
            
            for(Order order : sp.getOrderList()){
                
                Item i = order.getItem();
                
                //Calculate the profit of each order and store in the HashMap to the associated Sales Person
                if(i.getSalesPrice() > dataStore.getProducts().get(i.getProductId()).getTarget()){
                    int profit;
                    profit = (int) (i.getQuantity()*(i.getSalesPrice()-dataStore.getProducts().get(i.getProductId()).getTarget()));
                    if(salesPersonProfit.containsKey(sp.getSalesID())){
                        
                        int currentProfit = salesPersonProfit.get(sp.getSalesID());
                        int newProfit = currentProfit + profit;
                        salesPersonProfit.put(sp.getSalesID(), newProfit);
                    }
                    else{
                        salesPersonProfit.put(sp.getSalesID(), profit);
                    }
                }
                
                else{
                    if(!salesPersonProfit.containsKey(sp.getSalesID()))
                        salesPersonProfit.put(sp.getSalesID(), 0);
                }
                
                
//                //Calculate the profit of each order and store in the HashMap to the associated Sales Person
//          
//                    int profit;
//                    profit = i.getQuantity()*(i.getSalesPrice()-dataStore.getProducts().get(i.getProductId()).getTarget());
//                    if(salesPersonProfit.containsKey(sp.getSalesID())){
//                        
//                        int currentProfit = salesPersonProfit.get(sp.getSalesID());
//                        int newProfit = currentProfit + profit;
//                        salesPersonProfit.put(sp.getSalesID(), newProfit);
//                    }
//                    else{
//                        salesPersonProfit.put(sp.getSalesID(), profit);
//                    }
            }
        }
            
        //Sort the Sales Person  based on the profit.
        List<Map.Entry<Integer, Integer> > list =  new LinkedList<Map.Entry<Integer, Integer> >(salesPersonProfit.entrySet()); 
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2 ){
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        
        List<SalesPerson> result = new ArrayList<>();
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        List<Integer> arr = new ArrayList<>();
        
        //Storing Sorted Values in LinkedHashMap
        for (Map.Entry<Integer, Integer> aa : list) {       
            temp.put(aa.getKey(), aa.getValue()); 
            arr.add(aa.getValue());
        } 
        
        int[] top3 = new int[3];
        findTop3(arr, top3);
        
        //Converting to Hash Set
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<3;i++){
            hs.add(top3[i]);
        }
        
        for (Map.Entry<Integer, Integer> aa : list) {        
            if(hs.contains(aa.getValue()))
                result.add(dataStore.getSalesPersons().get(aa.getKey()));
        } 
        
        
        int value=list.get(0).getValue();
        int count=0;
        System.out.println("Rank-1");
        for(Map.Entry<Integer,Integer> entry:list)
        {
            if(entry.getValue()!=value)
            {
                value=entry.getValue();
                count++;
                if(count<3)
                {
                    System.out.println("\n");
                    int rank=count+1;
                    System.out.println("Rank-"+rank);
                }
            }
            if(count==3)
                break;
            System.out.println("Supplier ID: "+entry.getKey()+","+" Total Profit: "+entry.getValue());
        }
        
//        System.out.println(temp+"\n");
//        int i=0;
//        for(SalesPerson sp : result){
//            
//            int index = findIndex(top3, top3[i]);
//            System.out.println("Rank "+(index+1));
//            System.out.println(i+1 + ". " + "Supplier ID: " +sp.getSalesID()+ " ");
//            System.out.println("   " + "Total Orders: " + sp.getOrderList().size()+ " ");
//            System.out.println("   " +"Total Profit: "+ top3[i]);
//            
//            i++;
//        }
    }
    
    
    //compute the original stats
    public Map<Integer, StatsProduct> computeStats(DataStore dataStore){
        Map<Integer, StatsProduct> result = new HashMap<>();
        //Compute average sale price for each product
        for(Map.Entry<Integer, Product> entry : dataStore.getProducts().entrySet()){
            int productID = entry.getKey();
            int totalSales=0;
            int totalQuantity = 0;
            for(Map.Entry<Integer, Order> orders: dataStore.getOrders().entrySet()){
                if(orders.getValue().getItem().getProductId()==productID){
                    int sales = (orders.getValue().getItem().getSalesPrice())*(orders.getValue().getItem().getQuantity());
                    totalSales += sales;
                    totalQuantity += orders.getValue().getItem().getQuantity();
                }
            }
            double averageSales = totalSales/totalQuantity;
            double difference = Math.abs(averageSales-entry.getValue().getTarget());
            String section;
            if(averageSales-entry.getValue().getTarget()<=0)
                section = "Low";
            else
                section = "High";
            StatsProduct sp = new StatsProduct(entry.getValue(), averageSales, difference, section);
            result.put(productID, sp);
        }
        List<Map.Entry<Integer, StatsProduct> > list =  new LinkedList<Map.Entry<Integer, StatsProduct> >(result.entrySet()); 
        Collections.sort(list,new Comparator<Map.Entry<Integer,StatsProduct>>(){
            @Override
            public int compare(Map.Entry<Integer,StatsProduct> o1,Map.Entry<Integer,StatsProduct> o2 ){
                return (int) Math.ceil(o2.getValue().getDifference()-o1.getValue().getDifference());
            }
        });
        Collections.sort(list,new Comparator<Map.Entry<Integer,StatsProduct>>(){
            @Override
            public int compare(Map.Entry<Integer,StatsProduct> o1,Map.Entry<Integer,StatsProduct> o2 ){
                return  (o1.getValue().getSection().compareTo(o2.getValue().getSection()));
            }
        });
       HashMap<Integer, StatsProduct> final_result = new LinkedHashMap<Integer, StatsProduct>(); 
  
        for (Map.Entry<Integer, StatsProduct> a : list) { 
            final_result.put(a.getKey(), a.getValue()); 
        }
        return final_result;
    }
    
    
    public void modifyData() throws FileNotFoundException, IOException{
        Map<Integer, Product> products = new HashMap<>();
        Map<Integer,StatsProduct> modifiedStats=new HashMap<>();
        DataReader originalStatsReader = new DataReader(ORIGINAL_FILE_PATH);
        DataReader productCatalogueReader = new DataReader(PROD_CAT_PATH);
        String[] row;
        //printRow(originalStatsReader.getFileHeader());
        
        List<Product> ap = new ArrayList<Product>();
        while((row = productCatalogueReader.getNextRow())!=null){
                Product p = new Product(Double.parseDouble(row[1]),Double.parseDouble(row[2]),Double.parseDouble(row[3]),Integer.parseInt(row[0]));
                ap.add(p);
        }
        
        
        
        while((row = originalStatsReader.getNextRow())!=null){
            String prodRow[];
            
            int productID = Integer.parseInt(row[0]);
            //System.out.println(productID);
            double averageSalesPrice = Double.parseDouble(row[1]);
            double targetPrice = Double.parseDouble(row[2]);
            double difference = Double.parseDouble(row[3]);
            double modifiedTargetPrice=targetPrice;
            double changeValue=0;
            double newMin=0;
            double newMax=0;
            String section = row[4];
            
            if((difference/averageSalesPrice) > 0.05){
                //check section
                
                if(section.equalsIgnoreCase("high")){
                    
                    modifiedTargetPrice=averageSalesPrice*0.95;
                    changeValue=modifiedTargetPrice-targetPrice;
                    for(Product p : ap){
                        if(p.getProductID()==productID)
                        {
                            double minPrice=Double.parseDouble(row[1]);
                            double maxPrice=Double.parseDouble(row[2]);
                            newMin=minPrice+changeValue;
                            newMax=maxPrice+changeValue;
                            break;
                        }
                    }
                    
                }
                else{
                    
                        modifiedTargetPrice=averageSalesPrice*1.05;
                        changeValue=modifiedTargetPrice-targetPrice;
                        for(Product p : ap){
                        if(p.getProductID()==productID)
                        {
                            double minPrice=Double.parseDouble(row[1]);
                            double maxPrice=Double.parseDouble(row[2]);
                            newMin=minPrice+changeValue;
                            newMax=maxPrice+changeValue;
                            break;
                        }
                    }
                }
            }
            else 
            {
                
                for(Product p : ap){
                        if(p.getProductID()==productID)
                        {
                            double minPrice=Double.parseDouble(row[1]);
                            double maxPrice=Double.parseDouble(row[2]);
                            newMin=minPrice;
                            newMax=maxPrice;
                            break;
                        }
                    }
            }
            difference=Math.abs(averageSalesPrice-modifiedTargetPrice);
            Product product = new Product(newMin,newMax,modifiedTargetPrice,productID);
            StatsProduct sp = new StatsProduct(product,averageSalesPrice,difference,section);
            products.put(productID,product);
            modifiedStats.put(productID, sp);
        }
        
        List<Map.Entry<Integer, StatsProduct> > list =  new LinkedList<Map.Entry<Integer, StatsProduct> >(modifiedStats.entrySet()); 
        Collections.sort(list,new Comparator<Map.Entry<Integer,StatsProduct>>(){
            @Override
            public int compare(Map.Entry<Integer,StatsProduct> o1,Map.Entry<Integer,StatsProduct> o2 ){
                return (int) (o2.getValue().getDifference()-o1.getValue().getDifference());
            }
        });
        Collections.sort(list,new Comparator<Map.Entry<Integer,StatsProduct>>(){
            @Override
            public int compare(Map.Entry<Integer,StatsProduct> o1,Map.Entry<Integer,StatsProduct> o2 ){
                return  (o1.getValue().getSection().compareTo(o2.getValue().getSection()));
            }
        });
       HashMap<Integer, StatsProduct> final_modifiedStats = new LinkedHashMap<Integer, StatsProduct>(); 
  
        for (Map.Entry<Integer, StatsProduct> a : list) { 
            final_modifiedStats.put(a.getKey(), a.getValue()); 
        }
        generateProductsFile(products);
        generateModifiedFile(final_modifiedStats);
        
    }
    
    private void generateProductsFile(Map<Integer, Product> products) throws IOException{
        //generate Product file
        
        try {
            
            file = new File(UPDATED_PROD_CAT_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("Updated Product Catalogue Created");
            writer = new FileWriter(file);
        
            writer.append(PRODUCT_HEADER);
            writer.append(LINE_BREAK);
        
            generateProductsColumns(products);
            
            
        }finally{
            
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        
        
    }
    
    private void generateModifiedFile(Map<Integer, StatsProduct> modifiedStats) throws IOException{
        //generate Product file
        
        try {
            
            file = new File(MODIFIED_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("Updated Stats File Created");
            writer = new FileWriter(file);
        
            writer.append(MODIFIED_HEADER);
            writer.append(LINE_BREAK);
        
            generateModifiedStatsColumns(modifiedStats);
            
            
        }finally{
            
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        
        
    }
    
    private void generateProductsColumns(Map<Integer, Product> products) throws IOException{
        
        //the loop for orders
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("QUESTION 5 - Updated price ranges for product, so prices perform at optimum levels (higher and lower targets).");
        System.out.println("----------------------------------------------------------------------------------------------------");
       
        System.out.println("");
        System.out.println("Updated Product Catalogue");
        System.out.println("");
        System.out.println("Product-Id,floor-Price,ceiling-Price,Target-Price");
        List<Map.Entry<Integer, Product> > list =  new LinkedList<Map.Entry<Integer, Product> >(products.entrySet()); 
        Collections.sort(list,new Comparator<Map.Entry<Integer,Product>>(){
            @Override
            public int compare(Map.Entry<Integer,Product> o1,Map.Entry<Integer,Product> o2 ){
                return (o1.getKey().compareTo(o2.getKey()));
            }
        });
        for(Map.Entry<Integer,Product> entry : list)
        {
            //items for a order.
            double minPrice = entry.getValue().getMin();
            double maxPrice = entry.getValue().getMax();
            double targetPrice=entry.getValue().getTarget();
            int productId=entry.getValue().getProductID();
             
            String column = productId+","+minPrice+","+maxPrice+","+targetPrice;
                
            System.out.println(column);    
            writer.append(column);
            writer.append(LINE_BREAK);
        }
        
    }
    
    private void generateModifiedStatsColumns(Map<Integer, StatsProduct> modifiedStats) throws IOException{
        
        //the loop for orders
        System.out.println("");
        System.out.println("Updated Stats file with new pricing strategy");
        System.out.println("");
        System.out.println(MODIFIED_HEADER);
        
        for(Map.Entry<Integer,StatsProduct> entry : modifiedStats.entrySet())
        {
            //items for a order.
            double averageSalesPrice = entry.getValue().getAvgSalesPrice();
            double difference = entry.getValue().getDifference();
            String section = entry.getValue().getSection();
            double targetPrice=entry.getValue().getProduct().getTarget();
            int productId=entry.getValue().getProduct().getProductID();
            double error=((targetPrice-averageSalesPrice)/averageSalesPrice)*100;
             
            String column = productId+","+averageSalesPrice+","+targetPrice+","+String.format("%.2f", difference)+","+String.format("%.2f", error)+","+section;
                
            System.out.println(column);    
            writer.append(column);
            writer.append(LINE_BREAK);
        }
        
    }
}
