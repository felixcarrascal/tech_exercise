package com.tech.exercise.enums;

/**
 * Created by Félix on 17/04/2016.
 */
public enum BuySellIndicator {

    BUY("B"),SELL("S");

    private String type;

    BuySellIndicator(String type){
        this.type = type;
    }

    public BuySellIndicator getType(String type){
        return BUY.getCode().equals(type) ? BUY : SELL;
    }

    private String getCode(){
        return this.type;
    }

}
