package com.nathan.arch.storage;

import com.nathan.arch.domain.model.TimeDModel;
import com.nathan.arch.domain.repository.ClockRepository;
import com.nathan.arch.storage.converters.StorageModelConverter;
import com.nathan.arch.storage.dvb.impl.SubscribeListenerEventFromDVB;
import com.nathan.arch.storage.model.TimeSModel;
import com.nathan.arch.storage.tools.EmptyTool;

import timber.log.Timber;

public class ClockRepositoryImpl implements ClockRepository {

    private Callback mCallback;
    private TimeDModel mTimeDModel = new TimeDModel();

    /**
     * set this class to Singleton
     */
    private static ClockRepositoryImpl instance = null;

    public static synchronized ClockRepositoryImpl getInstance(){
        Timber.d("Nathan ClockRepositoryImpl ==getInstance   ");
        if (instance ==null){
            Timber.d("Nathan ClockRepositoryImpl ==instance ==null ");
            instance = new ClockRepositoryImpl();
        }
        return instance;
    }

    private ClockRepositoryImpl(){
        subScribeListener();
    }

    private void subScribeListener(){
        SubscribeListenerEventFromDVB ss=SubscribeListenerEventFromDVB.getInstance();
        ss.setOnMessageClockCallback(new SubscribeListenerEventFromDVB.MessageClockCallback() {
            @Override
            public void showClock(TimeSModel time) {
                mTimeDModel = StorageModelConverter.convertToTimeDModel(time);
                if (EmptyTool.isNotEmpty(mCallback)) mCallback.showClock(mTimeDModel);
            }
        });

    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public TimeDModel getCurrentDvbClockTime() {
        return mTimeDModel;
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(instance)){
            mCallback = null;
            instance = null;
        }
    }
}
