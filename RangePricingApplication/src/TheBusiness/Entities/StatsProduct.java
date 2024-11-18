/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Entities;

/**
 *
 * @author group-11
 */
public class StatsProduct {
    private Product product;
    private double avgSalesPrice;
    private double difference;
    private String section;
    
    public StatsProduct(Product product, double avgSalesPrice, double difference, String section){
        this.product = product;
        this.avgSalesPrice = avgSalesPrice;
        this.difference = difference;        
        this.section = section;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAvgSalesPrice() {
        return avgSalesPrice;
    }

    public void setAvgSalesPrice(double avgSalesPrice) {
        this.avgSalesPrice = avgSalesPrice;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    
    public String toString(){
        return "Product: "+this.product+", Average Sales Price: "+this.avgSalesPrice+", Difference: "+this.difference+"\n";
    }
    
}
