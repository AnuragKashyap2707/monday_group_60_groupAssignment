/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class SalesPersonDirectory {
    ArrayList<SalesPerson> salesPersonDirectory;

    
    
    public SalesPersonDirectory(){
        salesPersonDirectory = new ArrayList<>();
    }

    public ArrayList<SalesPerson> getSalesPersonDirectory() {
        return salesPersonDirectory;
    }
    public void setSalesPersonDirectory(ArrayList<SalesPerson> salesPersonDirectory) {
        this.salesPersonDirectory = salesPersonDirectory;
    }
    
    public SalesPerson addSalesPerson(){
        SalesPerson sa = new SalesPerson();
        salesPersonDirectory.add(sa);
        return sa;
    }
    public void deleteSalesPerson(SalesPerson sa){
        salesPersonDirectory.remove(sa);
    }
    
    public SalesPerson searchSalesPerson(int salesPersonId)
    {
        for(SalesPerson salesPerson : salesPersonDirectory)
        {
            if(salesPerson.getSalesPersonId() == salesPersonId)
            {
                return salesPerson;
            }
        }
        return null;
    }
}
