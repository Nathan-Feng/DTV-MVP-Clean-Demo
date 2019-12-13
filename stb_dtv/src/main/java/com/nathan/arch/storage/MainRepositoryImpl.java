package com.nathan.arch.storage;

import android.content.Context;
import android.view.SurfaceHolder;

import com.nathan.arch.domain.repository.MainRepository;
import com.nathan.arch.domain.repository.StorageManagerRepository;
import com.nathan.arch.storage.androidapi.StorageManagerRepositoryImpl;
import com.nathan.arch.storage.dvb.impl.SubscribeListenerEventFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import timber.log.Timber;

/**
 * Created by Nathan on 1/29/16.
 */
public class MainRepositoryImpl implements MainRepository {
    private Context mContext;
    private static  MainRepositoryImpl instance = null;
    private StorageManagerRepository mRepository;

    /**
     * set this class to Singleton
     */
    public static synchronized  MainRepositoryImpl getInstance(Context context){
        if (instance == null){
            instance = new MainRepositoryImpl(context);
        }
        return instance;
    }

    public static MainRepositoryImpl getInstance(){
        if (instance == null){
            Timber.d("Nathan getInstance instance==null:");
        }
        return instance;
    }

    private  MainRepositoryImpl(Context context){
        Timber.d("Nathan MainRepositoryImpl context:"+(context==null));
        this.mContext =context;
        initDVB();
        //init USB receiver
        StorageManagerRepositoryImpl.getInstance(context);
    }



    private void initDVB() {

    }


    @Override
    public void setSurfaceHolder(SurfaceHolder holder){

    }

    @Override
    public void resume() {

    }


    @Override
    public void detach() {
        SubscribeListenerEventFromDVB.getInstance().detach();
        if (EmptyTool.isNotEmpty(instance)){
            instance = null;
            mContext = null;
        }
        if (EmptyTool.isNotEmpty(mRepository)){
            mRepository.detach();
            mRepository = null;
        }

        if (EmptyTool.isNotEmpty(ChannelBookMonitorRepositoryImpl.getInstance())){
            ChannelBookMonitorRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(ChannelBookRepositoryImpl.getInstance())){
            ChannelBookRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(ChannelFavManagerRepositoryImpl.getInstance())){
            ChannelFavManagerRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(ChannelManagerRepositoryImpl.getInstance())){
            ChannelManagerRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(ClockRepositoryImpl.getInstance())){
            ClockRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(DVBSearchRepositoryImpl.getInstance())){
            DVBSearchRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(EpgRepositoryImpl.getInstance())){
            EpgRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(MultiAudioSubTTXRecorderRepositoryImpl.getInstance())){
            MultiAudioSubTTXRecorderRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(MultiAudioSubTTXRepositoryImpl.getInstance())){
            MultiAudioSubTTXRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(PlayRepositoryImpl.getInstance())){
            PlayRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(PropertyConfigRepositoryImpl.getInstance())){
            PropertyConfigRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(PVRRepositoryImpl.getInstance())){
            PVRRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(RecorderRepositoryImpl.getInstance())){
            RecorderRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(TimeShiftRepositoryImpl.getInstance())){
            TimeShiftRepositoryImpl.getInstance().detach();
        }
        if (EmptyTool.isNotEmpty(StorageManagerRepositoryImpl.getInstance())){
            StorageManagerRepositoryImpl.getInstance().detach();
        }
    }
}
