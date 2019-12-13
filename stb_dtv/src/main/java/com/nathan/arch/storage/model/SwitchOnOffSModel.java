package com.nathan.arch.storage.model;

public class SwitchOnOffSModel {
    public static SwitchOnOffSModel ON   = new SwitchOnOffSModel(1);
    public static SwitchOnOffSModel OFF= new SwitchOnOffSModel(0);

    private int type;
    private SwitchOnOffSModel(int type){
        this.type = type;
    }

    public int getValue(){
        return type;
    }
}
