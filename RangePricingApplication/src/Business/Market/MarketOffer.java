/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import Business.supplier.Product;

/**
 *
 * @author group-11
 */
public class MarketOffer {
    
    private double targetPrice;
    private double floorPrice;
    private double ceilingPrice;
    private double commissionAboveTarget;
    private double commissionBelowTarget;
    private Market market;
    
    public MarketOffer()
    {
        market = new Market();
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public double getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(double ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public double getCommissionAboveTarget() {
        return commissionAboveTarget;
    }

    public void setCommissionAboveTarget(double commissionAboveTarget) {
        this.commissionAboveTarget = commissionAboveTarget;
    }

    public double getCommissionBelowTarget() {
        return commissionBelowTarget;
    }

    public void setCommissionBelowTarget(double commissionBelowTarget) {
        this.commissionBelowTarget = commissionBelowTarget;
    }
}
