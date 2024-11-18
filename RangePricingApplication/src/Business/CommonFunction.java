/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Market.Market;
import Business.Market.MarketOffer;
import Business.sales.OrderItems;
import Business.sales.PurchaseOrder;

/**
 *
 * @author group-11
 */
public class CommonFunction {
    public double getTarget(Business business,Market market, PurchaseOrder po){
        double target = 0;
        MarketOffer mo = business.getMarketOfferCatalog().searchMarketOffer(market);
        for(OrderItems oi : po.getOrderItemsCat().getOrderItemsCat()){
            target+= oi.getProduct().getPrice()*(mo.getTargetPrice()+100)/100;
        }
        return target;
    }
    public double getFloor(Business business,Market market, PurchaseOrder po){
        double target = 0;
        MarketOffer mo = business.getMarketOfferCatalog().searchMarketOffer(market);
        for(OrderItems oi : po.getOrderItemsCat().getOrderItemsCat()){
            target+= oi.getProduct().getPrice()*(mo.getFloorPrice()+100)/100;
        }
        return target;
    }
    public double getCeling(Business business,Market market, PurchaseOrder po){
        double target = 0;
        MarketOffer mo = business.getMarketOfferCatalog().searchMarketOffer(market);
        for(OrderItems oi : po.getOrderItemsCat().getOrderItemsCat()){
            target+= oi.getProduct().getPrice()*(mo.getCeilingPrice()+100)/100;
        }
        return target;
    }
    public double getTotalTarget(Business business, PurchaseOrder po){
        double totalTarget = 0;
         for(OrderItems ot : po.getOrderItemsCat().getOrderItemsCat())
            {
                totalTarget+= (ot.getTarget()*ot.getReqQantity());
                
            }
         return totalTarget;
    }
   
}
