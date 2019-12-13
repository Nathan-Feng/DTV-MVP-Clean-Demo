package com.nathan.arch.domain.model;

public class DVBSearchTypeDModel {

    public static final DVBSearchTypeDModel MANUAL_SEARCH = new DVBSearchTypeDModel(1);
    public static final DVBSearchTypeDModel AUTO_SEARCH   = new DVBSearchTypeDModel(2);

    private int type;
    private DVBSearchTypeDModel(int type){
        this.type = type;
    }

    @Override
    public String toString() {
        return "DVBSearchTypeDModel{" +
                "type=" + type +
                '}';
    }

    public int getType() {
        return type;
    }
}
