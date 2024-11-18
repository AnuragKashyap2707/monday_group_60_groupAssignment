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
public class MarketDirectory {
    
    private ArrayList<Market> marketDirectory;
    
    public MarketDirectory()
    {
        marketDirectory = new ArrayList<Market>();
    }

    public ArrayList<Market> getMarketDirectory() {
        return marketDirectory;
    }

    public void setMarketDirectory(ArrayList<Market> marketDirectory) {
        this.marketDirectory = marketDirectory;
    }
    
    public Market addMarket()
    {
        Market market = new Market();
        marketDirectory.add(market);
        return market;
    }
    
    public void deleteMarket(Market market)
    {
        marketDirectory.remove(market);
    }
    
    public Market searchMarket(int marketId)
    {
        for(Market market : marketDirectory)
        {
            if(market.getMarketId() == marketId)
            {
                return market;
            }
        }
        return null;
    }
    public Market searchMarket(String marketId)
    {
        for(Market market : marketDirectory)
        {
            if(market.getMarketType()== marketId)
            {
                return market;
            }
        }
        return null;
    }
}
