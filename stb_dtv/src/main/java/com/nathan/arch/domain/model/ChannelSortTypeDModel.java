package com.nathan.arch.domain.model;

public class ChannelSortTypeDModel {
    public static final ChannelSortTypeDModel NUMERIC    = new ChannelSortTypeDModel(0);
    public static final ChannelSortTypeDModel ABC  = new ChannelSortTypeDModel(1);
    public static final ChannelSortTypeDModel CBA  = new ChannelSortTypeDModel(2);
    public static final ChannelSortTypeDModel FREE_CAS  = new ChannelSortTypeDModel(3);
    public static final ChannelSortTypeDModel CAS_FREE = new ChannelSortTypeDModel(4);
    public static final ChannelSortTypeDModel TP   = new ChannelSortTypeDModel(5);

    public static final ChannelSortTypeDModel SERVICE_ID      = new ChannelSortTypeDModel(6);
    public static final ChannelSortTypeDModel LOGIC_NO   = new ChannelSortTypeDModel(7);
    public static final ChannelSortTypeDModel PROVIDER   = new ChannelSortTypeDModel(8);
    public static final ChannelSortTypeDModel NONE   = new ChannelSortTypeDModel(-1);

    private int value;
    private ChannelSortTypeDModel(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "ChannelSortTypeDModel{" +
                "value=" + value +
                '}';
    }


    public static String getStringName(int value){
        switch (value){
            case 0:
                return "NUMBERIC";
            case 1:
                return "ABC";
            case 2:
                return "CBA";
            case 3:
                return "FREECAS";
            case 4:
                return "CASFREE";
            case 5:
                return "TP";
            case 6:
                return "SERVID";
            case 7:
                return "LOGICNO";
            case 8:
                return "PROVIDER";
            case -1:
                return "NONE";
            default:
                break;
        }
        return null;
    }
}
