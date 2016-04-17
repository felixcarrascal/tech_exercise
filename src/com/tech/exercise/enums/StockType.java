package com.tech.exercise.enums;

/**
 * Created by Félix on 16/04/2016.
 */
public enum StockType {
    COMMON("C"),PREFERRED("P");

    private String type;

    StockType(String type){
        this.type = type;
    }

    public StockType getType(String type){
        return COMMON.getCode().equals(type) ? COMMON : PREFERRED;
    }

    private String getCode(){
        return this.type;
    }
}
