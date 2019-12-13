package com.nathan.arch.storage;

import com.nathan.arch.domain.model.BookParamDModel;
import com.nathan.arch.domain.repository.ChannelBookMonitorRepository;
import com.nathan.arch.domain.repository.ChannelBookRepository;
import com.nathan.arch.domain.repository.PlayRepository;
import com.nathan.arch.storage.dvb.impl.ChannelBookMethodFromDVB;
import com.nathan.arch.storage.dvb.impl.SubscribeListenerEventFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import timber.log.Timber;

public class ChannelBookMonitorRepositoryImpl implements ChannelBookMonitorRepository,
        ChannelBookMethodFromDVB.Callback
{

    private Callback mCallback;
    private ChannelBookRepository mChannelBookRepository;
    private PlayRepository mPlayRepository;

    /**
     * set this class to Singleton
     */
    private static ChannelBookMonitorRepositoryImpl instance = null;

    public static synchronized ChannelBookMonitorRepositoryImpl getInstance(){
        Timber.d("Nathan ChannelBookMonitorRepositoryImpl ==getInstance   ");
        if (instance ==null){
            Timber.d("Nathan ChannelBookMonitorRepositoryImpl ==instance ==null ");
            instance = new ChannelBookMonitorRepositoryImpl();
        }
        return instance;
    }

    private ChannelBookMonitorRepositoryImpl(){
        subScribeListener();
        mChannelBookRepository = ChannelBookRepositoryImpl.getInstance();
        mPlayRepository = PlayRepositoryImpl.getInstance();
    }

    private void subScribeListener(){
        SubscribeListenerEventFromDVB ss=SubscribeListenerEventFromDVB.getInstance();
        ss.setOnMessageBookMonitorCallback(new SubscribeListenerEventFromDVB.MessageBookMonitorCallback(){

            @Override
            public void showBookRecAlarm() {
                if (EmptyTool.isNotEmpty(mCallback)){
                    BookParamDModel bookInfo = mChannelBookRepository.getBookHintGoingTask();
                    if (EmptyTool.isNotEmpty(bookInfo)){
                        mCallback.showBookRecAlarm(bookInfo);
                    }
                }
            }

            @Override
            public void showBookRecStart() {
                if (EmptyTool.isNotEmpty(mCallback)){
                    mCallback.showBookRecStart();
                }
            }

            @Override
            public void showBookPlayAlarm() {
                if (EmptyTool.isNotEmpty(mCallback)){
                    BookParamDModel bookInfo = mChannelBookRepository.getBookHintGoingTask();
                    if (EmptyTool.isNotEmpty(bookInfo)){
                        mCallback.showBookPlayAlarm(bookInfo);
                    }
                }
            }
        });

    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(instance)){
            instance = null;
            mCallback = null;
            mChannelBookRepository = null;
        }
    }

    @Override
    public void showChannelBookConflict(int bookId) {

    }

    @Override
    public void showReBookConflict(int bookId) {

    }
}
