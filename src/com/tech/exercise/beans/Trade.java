package com.tech.exercise.beans;

import com.tech.exercise.enums.BuySellIndicator;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Félix on 17/04/2016.
 */
public class Trade {

    protected static final char INDICATOR_BUY = 'B';
    protected static final char INDICATOR_SELL = 'S';

    private Timestamp timestamp;
    private BigDecimal quantity;
    private BuySellIndicator buySellIndicator;
    private BigDecimal price;

    public Trade(Timestamp timestamp, BigDecimal quantity, BuySellIndicator buySellIndicator, BigDecimal price) {
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.buySellIndicator = buySellIndicator;
        this.price = price;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BuySellIndicator getBuySellIndicator() {
        return buySellIndicator;
    }

    public void setBuySellIndicator(BuySellIndicator buySellIndicator) {
        this.buySellIndicator = buySellIndicator;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
