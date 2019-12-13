package com.nathan.arch.storage.model;

public class TimeProgressSModel {
    private String mStartTime;

    private String mPlayTime;

    private String mTotalTime;

    private int mPercent;


    private TimeSModel mStartTimeSModel;
    private TimeSModel mPlayTimeSModel;
    private TimeSModel mNowTimeSModel;

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    public String getPlayTime() {
        return mPlayTime;
    }

    public void setPlayTime(String playTime) {
        mPlayTime = playTime;
    }

    public String getTotalTime() {
        return mTotalTime;
    }

    public void setTotalTime(String totalTime) {
        mTotalTime = totalTime;
    }

    public int getPercent() {
        return mPercent;
    }

    public void setPercent(int percent) {
        mPercent = percent;
    }

    public TimeSModel getStartTimeSModel() {
        return mStartTimeSModel;
    }

    public void setStartTimeSModel(TimeSModel startTimeSModel) {
        mStartTimeSModel = startTimeSModel;
    }

    public TimeSModel getPlayTimeSModel() {
        return mPlayTimeSModel;
    }

    public void setPlayTimeSModel(TimeSModel playTimeSModel) {
        mPlayTimeSModel = playTimeSModel;
    }

    public TimeSModel getNowTimeSModel() {
        return mNowTimeSModel;
    }

    public void setNowTimeSModel(TimeSModel nowTimeSModel) {
        mNowTimeSModel = nowTimeSModel;
    }
}
