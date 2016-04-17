package com.tech.exercise;

import com.tech.exercise.beans.Stock;
import com.tech.exercise.beans.Trade;
import com.tech.exercise.enums.BuySellIndicator;
import com.tech.exercise.enums.StockType;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Félix on 16/04/2016.
 */
public class SuperSimpleStocks {

    private final static long FIFTEEN_MIN_IN_NANOS = 900000000000L;
    private Map<String, List<Trade>> trades = new HashMap<String, List<Trade>>();

    public BigDecimal getDividendYield(Stock stock, BigDecimal tickerPrice){
        if(stock.getType() == StockType.COMMON){
            return stock.getLastDividend().divide(tickerPrice);
        } else {
            return (stock.getFixedDiviend().multiply(stock.getParValue()).divide(tickerPrice));
        }
    }

    public BigDecimal getPERatio(Stock stock, BigDecimal tickerPrice){
        return tickerPrice.divide(stock.getLastDividend());
    }

    public boolean recordTrade(Stock stock, BigDecimal quantity, BuySellIndicator buySellIndicator, BigDecimal price){
        try{
            List<Trade> stockTrades = trades.get(stock.getSymbol());
            if(stockTrades == null){
                stockTrades = new ArrayList<Trade>();
            }
            stockTrades.add(new Trade(Timestamp.from(Instant.now()), quantity, buySellIndicator, price));
            trades.put(stock.getSymbol(), stockTrades);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public BigDecimal getGBCEAllShareIndex(){
        int nPrices = 0;
        BigDecimal prices = new BigDecimal(0);
        for (Map.Entry<String, List<Trade>> stockTrades :  trades.entrySet()) {
            if(prices.compareTo(new BigDecimal(0)) == 0){
                prices = calculateStockPrice(stockTrades.getValue());
            } else {
                prices = prices.multiply(calculateStockPrice(stockTrades.getValue()));
            }
        }

        return new BigDecimal(Math.pow(prices.doubleValue(), new Double(1 / nPrices)));
    }

    public BigDecimal calculateStockPricePast15Minutes(Stock stock){
        return calculateStockPrice(getPast15MinTrades(stock));
    }

    public BigDecimal calculateStockPrice(List<Trade> trades){
         if(trades.size() == 0) return new BigDecimal(0);

        BigDecimal tradePriceSummatory = new BigDecimal(0);
        BigDecimal quantitySummatory = new BigDecimal(0);

        for (Trade trade : trades) {
            tradePriceSummatory = tradePriceSummatory.add(trade.getPrice());
            quantitySummatory = quantitySummatory.add(trade.getQuantity());
        }

        return (tradePriceSummatory.multiply(BigDecimal.valueOf(trades.size()))).divide(quantitySummatory);
    }

    private List<Trade> getPast15MinTrades(Stock stock){
        Timestamp now = Timestamp.from(Instant.now());

        List<Trade> stockTrades = trades.get(stock.getSymbol());
        if(stockTrades == null){
            return new ArrayList<Trade>();
        }

        return stockTrades.stream().filter(trade -> now.getTime() - trade.getTimestamp().getTime() < FIFTEEN_MIN_IN_NANOS).collect(Collectors.toList());
    }

}
