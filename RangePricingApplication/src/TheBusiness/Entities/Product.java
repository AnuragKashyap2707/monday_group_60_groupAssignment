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
public class Product {
    private int productID;
    private double min;
    private double max;
    private double target;
    
    
    public Product(double min, double max, double target, int id){
        this.max = max;
        this.min = min;
        this.target = target;
        this.productID = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }
    
    public String toString(){
        return "Product ID: "+this.productID+", Min: "+this.min+", Max: "+this.max+", Target: "+this.target+"\n";
    }
}
