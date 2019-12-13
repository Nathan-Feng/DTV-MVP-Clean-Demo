package com.nathan.arch.domain.model;

/**
 * A sample model. Replace this with your own.
 */
public class EpgInfoDModel {

    private String mEventName;
    private TimeDModel mStartDate;
    private TimeDModel mEndDate;
    private String mParentRate;
    private String mDescription;
    private BookTypeDModel mBookType;

    /**
     * for locate local Epg, not for UI
     */
    private int satId;
    private int progId;
    private int serviceId;
    private int eventId;


    public EpgInfoDModel(){}

    public EpgInfoDModel(String eventName, TimeDModel startDate, TimeDModel endDate,
                         String parentRate, String description, BookTypeDModel bookType,
                         int satId, int progId, int serviceId, int eventId) {
        mEventName = eventName;
        mStartDate = startDate;
        mEndDate = endDate;
        mParentRate = parentRate;
        mDescription = description;
        mBookType = bookType;
        this.satId = satId;
        this.progId = progId;
        this.serviceId = serviceId;
        this.eventId = eventId;
    }

    public EpgInfoDModel(String eventName, TimeDModel startDate, TimeDModel endDate, String parentRate, String destription, BookTypeDModel bookTypeDModel) {
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



    public int getSatId() {
        return satId;
    }

    public void setSatId(int satId) {
        this.satId = satId;
    }

    public int getProgId() {
        return progId;
    }

    public void setProgId(int progId) {
        this.progId = progId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "EpgInfoDModel{" +
                "mEventName='" + mEventName + '\'' +
                ", mStartDate=" + mStartDate +
                ", mEndDate=" + mEndDate +
                ", mParentRate='" + mParentRate + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mBookType=" + mBookType +
                ", satId=" + satId +
                ", progId=" + progId +
                ", serviceId=" + serviceId +
                ", eventId=" + eventId +
                '}';
    }
}
