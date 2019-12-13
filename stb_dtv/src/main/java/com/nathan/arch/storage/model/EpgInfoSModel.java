package com.nathan.arch.storage.model;

import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.model.TimeDModel;

/**
 * A sample model. Replace this with your own.
 */
public class EpgInfoSModel {

    private String mEventName;
    private TimeDModel mStartDate;
    private TimeDModel mEndDate;
    private String mParentRate;
    private String mDescription;
    private BookTypeDModel mBookType;


    public EpgInfoSModel(){}

    public EpgInfoSModel(String mEventName, TimeDModel mStartDate, TimeDModel mEndDate, String mParentRate) {
        this.mEventName = mEventName;
        this.mStartDate = mStartDate;
        this.mEndDate = mEndDate;
        this.mParentRate = mParentRate;
    }

    public EpgInfoSModel(String eventName, TimeDModel startDate, TimeDModel endDate, String parentRate, String destription, BookTypeDModel bookTypeDModel) {
        mEventName = eventName;
        mStartDate = startDate;
        mEndDate = endDate;
        mParentRate = parentRate;
        mDescription = destription;
        mBookType = bookTypeDModel;
    }

    public BookTypeDModel getBookTypeDModel() {
        return mBookType;
    }

    public void setBookTypeDModel(BookTypeDModel bookTypeDModel) {
        mBookType = bookTypeDModel;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }


    public String getEventName() {
        return mEventName;
    }

    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    public TimeDModel getStartDate() {
        return mStartDate;
    }

    public void setStartDate(TimeDModel startDate) {
        mStartDate = startDate;
    }

    public TimeDModel getEndDate() {
        return mEndDate;
    }

    public void setEndDate(TimeDModel endDate) {
        mEndDate = endDate;
    }

    public String getParentRate() {
        return mParentRate;
    }

    public void setParentRate(String parentRate) {
        mParentRate = parentRate;
    }
}
