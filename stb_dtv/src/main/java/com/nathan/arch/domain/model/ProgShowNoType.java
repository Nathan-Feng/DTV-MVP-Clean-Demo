package com.nathan.arch.domain.model;

public class ProgShowNoType {

    public static final ProgShowNoType PROG_SHOW_INDEX   = new ProgShowNoType(0);
    public static final ProgShowNoType PROG_SHOW_LCN   = new ProgShowNoType(1);
    public static final ProgShowNoType PROG_SHOW_SERVICE_ID   = new ProgShowNoType(2);

    private int type;
    private ProgShowNoType(int type){
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProgShowNoType{" +
                "type=" + type +
                '}';
    }

    public static String getStringName(int value){
        switch (value){
            case 0:
                return "Index";
            case 1:
                return "LCN";
            case 2:
                return "Service ID";
            default:
                break;
        }
        return "None";
    }
}

