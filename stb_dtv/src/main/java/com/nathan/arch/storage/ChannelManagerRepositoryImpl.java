package com.nathan.arch.storage;

import com.nathan.arch.domain.model.ChannelSortTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.repository.ChannelManagerRepository;
import com.nathan.arch.storage.dvb.ICallbackChannelManagerMethod;
import com.nathan.arch.storage.dvb.impl.ChannelManagerMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

import timber.log.Timber;

public class ChannelManagerRepositoryImpl implements ChannelManagerRepository,
        ICallbackChannelManagerMethod.Callback {

    private ICallbackChannelManagerMethod methodFromDVB;
    private Callback mCallback;

    /**
     * set this class to Singleton
     */
    private static ChannelManagerRepositoryImpl instance = null;

    public static synchronized ChannelManagerRepositoryImpl getInstance(){
        Timber.d("Nathan ChannelManagerRepositoryImpl ==getInstance   ");
        if (instance ==null){
            Timber.d("Nathan ChannelManagerRepositoryImpl ==instance ==null ");
            instance = new ChannelManagerRepositoryImpl();
        }
        return instance;
    }

    private ChannelManagerRepositoryImpl(){
        methodFromDVB = new ChannelManagerMethodFromDVB(this);
    }




    @Override
    public void showError(String message) {

    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public List<ChannelUnitModel> getALLTVProgList() {
      return null;
    }

    @Override
    public List<ChannelUnitModel> getALLRadioProgList() {
        return null;
    }

    @Override
    public ChannelUnitModel getChannelByShowNo(int showNo) {
        return null;
    }

    @Override
    public ChannelUnitModel getChannelByUniqueIndex(int progIndex) {
        return null;
    }


    @Override
    public List<String> getProgGroupList() {
        return methodFromDVB.getProgGroupList();
    }

    @Override
    public boolean setProgDelFlag(ChannelUnitModel channelUnit, boolean bDel) {
       return false;
    }

    @Override
    public boolean setProgHideFlag(ChannelUnitModel progInfo, boolean bHide) {
        return false;
    }

    @Override
    public boolean setProgLockFlag(ChannelUnitModel progInfo, boolean bLock) {
        return false;
    }

    @Override
    public boolean setProgSortType(ChannelSortTypeDModel sort) {
        return false;
    }

    @Override
    public ChannelSortTypeDModel getProgSortType() {
        return null;
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(methodFromDVB)){
            methodFromDVB.detach();
            methodFromDVB = null;
            mCallback = null;
            instance = null;
        }
    }

}
