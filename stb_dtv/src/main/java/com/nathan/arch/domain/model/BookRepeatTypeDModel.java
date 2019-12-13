package com.nathan.arch.domain.model;

public class BookRepeatTypeDModel {
    private int type;
    private BookRepeatTypeDModel(int type){
        this.type = type;
    }

    public static final BookRepeatTypeDModel REPEAT_TYPE_ONCE   = new BookRepeatTypeDModel(1);
    public static final BookRepeatTypeDModel REPEAT_TYPE_DAILY  = new BookRepeatTypeDModel(2);
    public static final BookRepeatTypeDModel REPEAT_TYPE_WEEKLY = new BookRepeatTypeDModel(3);
    public static final BookRepeatTypeDModel REPEAT_TYPE_CRID   = new BookRepeatTypeDModel(4);

    @Override
    public String toString() {
        return "BookRepeatTypeDModel{" +
                "type=" + type +
                '}';
    }
}

