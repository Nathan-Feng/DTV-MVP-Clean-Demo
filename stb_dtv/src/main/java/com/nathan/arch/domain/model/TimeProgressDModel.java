package com.nathan.arch.domain.model;

public class TimeProgressDModel {
    private String mStartTime;

    private String mPlayTime;

    private String mTotalTime;

    private int mPercent;
    private TimeDModel mStartTimeDModel;
    private TimeDModel mPlayTimeDModel;
    private TimeDModel mNowTimeDModel;



    private long mDurationMs;
    private TimeDModel mEndTimeDModle;

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

    public TimeDModel getStartTimeDModel() {
        return mStartTimeDModel;
    }

    public void setStartTimeDModel(TimeDModel startTimeDModel) {
        mStartTimeDModel = startTimeDModel;
    }

    public TimeDModel getPlayTimeDModel() {
        return mPlayTimeDModel;
    }

    public void setPlayTimeDModel(TimeDModel playTimeDModel) {
        mPlayTimeDModel = playTimeDModel;
    }

    public TimeDModel getNowTimeDModel() {
        return mNowTimeDModel;
    }

    public void setNowTimeDModel(TimeDModel nowTimeDModel) {
        mNowTimeDModel = nowTimeDModel;
    }

    public TimeDModel getEndTimeDModle() {
        return mEndTimeDModle;
    }

    public void setEndTimeDModle(TimeDModel endTimeDModle) {
        mEndTimeDModle = endTimeDModle;
    }


    public long getDuration() {
        return mDurationMs;
    }

    public void setDuration(long duration) {
        mDurationMs = duration;
    }
}
