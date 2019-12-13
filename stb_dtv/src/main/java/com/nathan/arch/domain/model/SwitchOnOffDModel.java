package com.nathan.arch.domain.model;

public class SwitchOnOffDModel {
    public static SwitchOnOffDModel ON   = new SwitchOnOffDModel(1);
    public static SwitchOnOffDModel OFF= new SwitchOnOffDModel(0);

    private int type;
    private SwitchOnOffDModel(int type){
        this.type = type;
    }

    public int getValue(){
        return type;
    }

    @Override
    public String toString() {
        return "SwitchOnOffDModel{" +
                "type=" + type +
                '}';
    }
}
