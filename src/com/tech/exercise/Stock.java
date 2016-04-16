package com.tech.exercise;

import java.math.BigDecimal;

/**
 * Created by Félix on 16/04/2016.
 */
public class Stock {

    private String symbol;
    private StockType type;
    private BigDecimal lastDividend;
    private BigDecimal fixedDiviend;
    private BigDecimal parValue;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public BigDecimal getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(BigDecimal lastDividend) {
        this.lastDividend = lastDividend;
    }

    public BigDecimal getFixedDiviend() {
        return fixedDiviend;
    }

    public void setFixedDiviend(BigDecimal fixedDiviend) {
        this.fixedDiviend = fixedDiviend;
    }

    public BigDecimal getParValue() {
        return parValue;
    }

    public void setParValue(BigDecimal parValue) {
        this.parValue = parValue;
    }
}
