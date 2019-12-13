package com.nathan.arch.domain.model;

public  class ProgFilterDModel {
    public static final ProgFilterDModel ALL   = new ProgFilterDModel(0);
    public static final ProgFilterDModel TV    = new ProgFilterDModel(1);
    public static final ProgFilterDModel RADIO = new ProgFilterDModel(2);

    private int filter;
    private ProgFilterDModel(int filter){
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "ProgFilterDModel{" +
                "filter=" + filter +
                '}';
    }

    public int getValue() {
        return this.filter;
    }

    public static ProgFilterDModel getFilter(int value) {
        switch(value) {
            case 0:
                return ALL;
            case 1:
                return TV;
            case 2:
                return RADIO;
            default:
                return null;
        }
    }

    public static String getStringName(int value){
        switch (value){
            case 0:
                return "TV+Radio";
            case 1:
                return "TV";
            case 2:
                return "Radio";
            default:
                break;
        }
        return null;
    }
}
