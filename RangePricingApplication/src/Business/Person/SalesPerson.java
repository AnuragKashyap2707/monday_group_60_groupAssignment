/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author group-11
 */
public class SalesPerson {
    
    private Person person;
    private int salesPersonId;
    private double salary;
    private int totalNumberOfSales;
    private int totalNumberofSalesAboveTarget;
    private double targetPrice;
    private boolean isTargetAchieved;
    private static int count = 0;
    
    public SalesPerson()
    {
        count++;
        salesPersonId = count;
        person = new Person();
        totalNumberOfSales = 0;
        salary = 0;
        totalNumberofSalesAboveTarget = 0;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getTotalNumberOfSales() {
        return totalNumberOfSales;
    }

    public void setTotalNumberOfSales(int totalNumberOfSales) {
        this.totalNumberOfSales = totalNumberOfSales;
    }

    public int getTotalNumberofSalesAboveTarget() {
        return totalNumberofSalesAboveTarget;
    }

    public void setTotalNumberofSalesAboutTarget(int totalNumberofSalesAboveTarget) {
        this.totalNumberofSalesAboveTarget = totalNumberofSalesAboveTarget;
    }
    
    public int getTotalNumberOfSalesBelowTarget(int totalNumberofSalesBelowTarget)
    {
        return totalNumberOfSales - totalNumberofSalesAboveTarget;
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public boolean isIsTargetAchieved() {
        return isTargetAchieved;
    }

    public void setIsTargetAchieved(boolean isTargetAchieved) {
        this.isTargetAchieved = isTargetAchieved;
    }
    
    public String toString()
    {
        return String.valueOf(salesPersonId);
    }
}
