/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Market.MarketDirectory;
import Business.Market.MarketOfferCatalog;
import Business.Person.PersonDirectory;
import Business.Person.SalesPersonDirectory;
import Business.Users.User;
import Business.Users.UserCat;
import Business.sales.PurchaseOrderCat;
import Business.supplier.SupplierDirectory;

/**
 *
 * @author group-11
 */
public class Business {

    private UserCat userCat;
    private SupplierDirectory supplierDirectory;
    private SalesPersonDirectory salesPersonDirectory;
    private MarketDirectory marketDirectory;
    private PersonDirectory personDirectory;
    private User loggedUser;
    private PurchaseOrderCat purchaseOrderCat;
    private MapCustomerPersonDirectory mapCustomerPersonDirectory;
    private MapSupplierUserDirectory mapSupplierUserDirectory;
    private MapSalesPersonUserDirectory mapSalesPersonUserDirectory;

    private MarketOfferCatalog marketOfferCatalog;

    
    public Business() {

        userCat = new UserCat();
        supplierDirectory = new SupplierDirectory();
        marketDirectory = new MarketDirectory();
        personDirectory = new PersonDirectory();
        marketOfferCatalog = new MarketOfferCatalog();
        mapSupplierUserDirectory=new MapSupplierUserDirectory();
        purchaseOrderCat = new PurchaseOrderCat();
        mapSalesPersonUserDirectory = new MapSalesPersonUserDirectory();
        salesPersonDirectory = new SalesPersonDirectory();
        mapCustomerPersonDirectory = new MapCustomerPersonDirectory();
    }

    public MapCustomerPersonDirectory getMapCustomerPersonDirectory() {
        return mapCustomerPersonDirectory;
    }

    public void setMapCustomerPersonDirectory(MapCustomerPersonDirectory mapCustomerPersonDirectory) {
        this.mapCustomerPersonDirectory = mapCustomerPersonDirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salesPersonDirectory;
    }

    public void setSalesPersonDirectory(SalesPersonDirectory salesPersonDirectory) {
        this.salesPersonDirectory = salesPersonDirectory;
    }

    public MapSalesPersonUserDirectory getMapSalesPersonUserDirectory() {
        return mapSalesPersonUserDirectory;
    }

    public void setMapSalesPersonUserDirectory(MapSalesPersonUserDirectory mapSalesPersonUserDirectory) {
        this.mapSalesPersonUserDirectory = mapSalesPersonUserDirectory;
    }

    public PurchaseOrderCat getPurchaseOrderCat() {
        return purchaseOrderCat;
    }

    public void setPurchaseOrderCat(PurchaseOrderCat purchaseOrderCat) {
        this.purchaseOrderCat = purchaseOrderCat;
    }

    public MapSupplierUserDirectory getMapSupplierUserDirectory() {
        return mapSupplierUserDirectory;
    }

    public void setMapSupplierUserDirectory(MapSupplierUserDirectory mapSupplierUserDirectory) {
        this.mapSupplierUserDirectory = mapSupplierUserDirectory;
    }

    public MapSupplierUserDirectory getmapSupplierUserDirectory() {
        return mapSupplierUserDirectory;
        
    }

    public void setmapSupplierUserDirectory(MapSupplierUserDirectory mapSupplierUserDirectory) {
        this.mapSupplierUserDirectory = mapSupplierUserDirectory;
    }  
    
    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public UserCat getUserCat() {
        return userCat;
    }

    public void setUserCat(UserCat userCat) {
        this.userCat = userCat;
    }

    public MarketDirectory getMarketDirectory() {
        return marketDirectory;
    }

    public void setMarketDirectory(MarketDirectory marketDirectory) {
        this.marketDirectory = marketDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public MarketOfferCatalog getMarketOfferCatalog() {
        return marketOfferCatalog;
    }

    public void setMarketOfferCatalog(MarketOfferCatalog marketOfferCatalog) {
        this.marketOfferCatalog = marketOfferCatalog;
    }
    
}
