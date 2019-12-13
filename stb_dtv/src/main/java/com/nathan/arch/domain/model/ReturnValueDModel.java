package com.nathan.arch.domain.model;


public class ReturnValueDModel {

    private int ret;
    private ReturnValueDModel(int ret){
        this.ret = ret;
    }

    public static final ReturnValueDModel SUCCESS  = new ReturnValueDModel(0);
    public static final ReturnValueDModel FAILED = new ReturnValueDModel(1);

    @Override
    public String toString() {
        return "ReturnValueDModel{" +
                "ret=" + ret +
                '}';
    }
}
