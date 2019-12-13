package com.nathan.arch.domain.model;

public class PropertySwitchConfigDModel {
    public static final PropertySwitchConfigDModel PARENT_LOCK = new PropertySwitchConfigDModel(100);
    public static final PropertySwitchConfigDModel MENU_LOCK = new PropertySwitchConfigDModel(101);

    public static final PropertySwitchConfigDModel TIMESHIFT_ALWAYS = new PropertySwitchConfigDModel(102);

    public static final PropertySwitchConfigDModel UTC_TOT_ENABLE = new PropertySwitchConfigDModel(103);
    public static final PropertySwitchConfigDModel UTC_TDT_ENABLE = new PropertySwitchConfigDModel(104);

    public static final PropertySwitchConfigDModel ANTENNA_POWER  = new PropertySwitchConfigDModel(105);
    public static final PropertySwitchConfigDModel SUBTITLE_ALWAYS  = new PropertySwitchConfigDModel(106);

    private int type;
    private PropertySwitchConfigDModel(int type){
        this.type = type;
    }

    public int getValue(){
        return type;
    }

    @Override
    public String toString() {
        return "PropertySwitchConfigDModel{" +
                "type=" + type +
                '}';
    }
}
