package com.nathan.arch.domain.model;

/**
 * Live channel book Params
 */
public class BookParamDModel {
    /**
     * book type ,see BookTypeDModel
     */
    private BookTypeDModel eBookType;
    /**
     *
     */
    private BookRepeatTypeDModel eBookRepeatType;
    /**
     *
     */
    private TimeDModel timeDModel;
    /**
     *
     */
    private int mBookDurSecond;

    private String mBookName;

    private int mBookId;

    private int mEventId;

    private String eventName;

    /**
     * if true: you can get eventName,
     */
    private boolean bookTypeFromEpg;


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public boolean isBookTypeFromEpg() {
        return bookTypeFromEpg;
    }

    public void setBookTypeFromEpg(boolean bookTypeFromEpg) {
        this.bookTypeFromEpg = bookTypeFromEpg;
    }


    public int getBookId() {
        return mBookId;
    }

    public void setBookId(int bookId) {
        mBookId = bookId;
    }



    public String getBookName() {
        return mBookName;
    }

    public void setBookName(String bookName) {
        mBookName = bookName;
    }



    public BookTypeDModel getBookType() {
        return eBookType;
    }

    public void setBookType(BookTypeDModel eBookType) {
        this.eBookType = eBookType;
    }

    public BookRepeatTypeDModel getBookRepeatType() {
        return eBookRepeatType;
    }

    public void setBookRepeatType(BookRepeatTypeDModel eBookRepeatType) {
        this.eBookRepeatType = eBookRepeatType;
    }

    public TimeDModel getTimeDModel() {
        return timeDModel;
    }

    public void setTimeDModel(TimeDModel timeDModel) {
        this.timeDModel = timeDModel;
    }

    public int getBookDurSecond() {
        return mBookDurSecond;
    }

    public void setBookDurSecond(int bookDurSecond) {
        mBookDurSecond = bookDurSecond;
    }

    public int getEventId() {
        return mEventId;
    }

    public void setEventId(int eventId) {
        mEventId = eventId;
    }
}
