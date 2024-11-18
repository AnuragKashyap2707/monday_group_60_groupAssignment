/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class MarketOfferCatalog {
    
    private ArrayList<MarketOffer> marketOfferCatalog;
    
    public MarketOfferCatalog()
    {
        marketOfferCatalog = new ArrayList<MarketOffer>();
    }

    public ArrayList<MarketOffer> getMarketOfferCatalog() {
        return marketOfferCatalog;
    }

    public void setMarketOfferCatalog(ArrayList<MarketOffer> marketOfferCatalog) {
        this.marketOfferCatalog = marketOfferCatalog;
    }
    
    public MarketOffer addMarketOffer(){
        MarketOffer mo = new MarketOffer();
        marketOfferCatalog.add(mo);
        return mo;
    }
    public MarketOffer searchMarketOffer(Market market)
    {
        for(MarketOffer marketOffer : marketOfferCatalog)
        {
            if(marketOffer.getMarket()==market)
            {
                return marketOffer;
            }
        }
        return null;
    }
    
}
