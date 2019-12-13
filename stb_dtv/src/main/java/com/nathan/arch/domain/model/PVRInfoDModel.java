package com.nathan.arch.domain.model;

public class PVRInfoDModel {

    private String mPVRName;
    private String mPVRTotalTime;
    private int mProgId;

    public String getPVRName() {
        return mPVRName;
    }

    public void setPVRName(String mPVRName) {
        this.mPVRName = mPVRName;
    }

    public String getPVRTotalTime() {
        return mPVRTotalTime;
    }

    public void setPVRTotalTime(String mPVRTotalTime) {
        this.mPVRTotalTime = mPVRTotalTime;
    }

    public int getProgId() {
        return mProgId;
    }

    public void setProgId(int mProgId) {
        this.mProgId = mProgId;
    }

    @Override
    public String toString() {
        return "PVRInfoDModel{" +
                "mPVRName='" + mPVRName + '\'' +
                ", mPVRTotalTime='" + mPVRTotalTime + '\'' +
                ", mProgId=" + mProgId +
                '}';
    }
}
