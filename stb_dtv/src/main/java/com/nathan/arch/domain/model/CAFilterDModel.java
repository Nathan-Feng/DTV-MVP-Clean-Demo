package com.nathan.arch.domain.model;


public class CAFilterDModel {

    private int type;
    private CAFilterDModel(int type){
        this.type = type;
    }

    public static final CAFilterDModel ALL  = new CAFilterDModel(0);
    public static final CAFilterDModel FREE = new CAFilterDModel(1);
    public static final CAFilterDModel CA   = new CAFilterDModel(2);

    @Override
    public String toString() {
        return "CAFilterDModel{" +
                "type=" + type +
                '}';
    }
    public int getValue() {
        return this.type;
    }

    public static CAFilterDModel getFilter(int value) {
        switch(value) {
            case 0:
                return ALL;
            case 1:
                return FREE;
            case 2:
                return CA;
            default:
                return null;
        }
    }

    public static String getStringName(int value){
        switch (value){
            case 0:
                return "ALL";
            case 1:
                return "FREE";
            case 2:
                return "CA";
            default:
                break;
        }
        return null;
    }
}
