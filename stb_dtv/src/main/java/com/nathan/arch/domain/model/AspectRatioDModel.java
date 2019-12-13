package com.nathan.arch.domain.model;

public  class AspectRatioDModel {
    public static final AspectRatioDModel PAN_SCAN   = new AspectRatioDModel(0);
    public static final AspectRatioDModel COMBINED    = new AspectRatioDModel(1);
    public static final AspectRatioDModel LETTER_BOX = new AspectRatioDModel(2);
    public static final AspectRatioDModel IGNORE = new AspectRatioDModel(3);
    private int type;
    private AspectRatioDModel(int type){
        this.type = type;
    }
}
