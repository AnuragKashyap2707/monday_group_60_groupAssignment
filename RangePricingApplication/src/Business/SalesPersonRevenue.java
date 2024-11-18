/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.SalesPerson;
import Business.Users.User;

/**
 *
 * @author group-11
 */
public class SalesPersonRevenue {
    User user;
    double revenue;
    double targetTotal;

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
public double getTargetTotal() {
        return targetTotal;
    }

    public void setTargetTotal(double targetTotal) {
        this.targetTotal = targetTotal;
    }


}
