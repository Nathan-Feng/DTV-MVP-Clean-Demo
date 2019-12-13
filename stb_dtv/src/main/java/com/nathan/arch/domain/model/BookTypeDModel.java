package com.nathan.arch.domain.model;

public class BookTypeDModel {
    public static BookTypeDModel BOOK_TYPE_NONE   = new BookTypeDModel(0);
    public static BookTypeDModel BOOK_TYPE_PLAY   = new BookTypeDModel(1);
    public static BookTypeDModel BOOK_TYPE_RECORD = new BookTypeDModel(2);
    public static BookTypeDModel BOOK_TYPE_ALL = new BookTypeDModel(3);
    private int type;
    private BookTypeDModel(int type){
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookTypeDModel{" +
                "type=" + type +
                '}';
    }
}
