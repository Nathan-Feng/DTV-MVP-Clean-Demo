package com.nathan.arch.domain.model;

public class StorageDModel {

    private String mName;
    private String mPath;
    private String mTotalVolumes;
    private String mFreeVolumes;


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public String getTotalVolumes() {
        return mTotalVolumes;
    }

    public void setTotalVolumes(String totalVolumes) {
        mTotalVolumes = totalVolumes;
    }

    public String getFreeVolumes() {
        return mFreeVolumes;
    }

    @Override
    public String toString() {
        return "StorageDModel{" +
                "mName='" + mName + '\'' +
                ", mPath='" + mPath + '\'' +
                ", mTotalVolumes='" + mTotalVolumes + '\'' +
                ", mFreeVolumes='" + mFreeVolumes + '\'' +
                '}';
    }

    public void setFreeVolumes(String freeVolumes) {
        mFreeVolumes = freeVolumes;
    }


}
