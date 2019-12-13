package com.nathan.arch.storage;

import com.nathan.arch.domain.model.BookTypeDModel;
import com.nathan.arch.domain.model.ChannelUnitModel;
import com.nathan.arch.domain.model.EpgInfoDModel;
import com.nathan.arch.domain.repository.EpgRepository;
import com.nathan.arch.storage.dvb.ICallbackEpgMethod;
import com.nathan.arch.storage.dvb.impl.EpgMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.List;

public class EpgRepositoryImpl implements EpgRepository,ICallbackEpgMethod.Callback {


    private ICallbackEpgMethod epgMethod;
    private static EpgRepositoryImpl INSTANCE = null;

    public static synchronized EpgRepository getInstance(){
        if (EmptyTool.isEmpty(INSTANCE)){
            INSTANCE = new EpgRepositoryImpl();
        }
        return INSTANCE;
    }
    private EpgRepositoryImpl(){
        epgMethod = new EpgMethodFromDVB(this);
    }


    @Override
    public List<EpgInfoDModel> getEpgListByChannel(ChannelUnitModel pInfo) {
        return null;
    }

    @Override
    public boolean epgBook(EpgInfoDModel evtInfo, BookTypeDModel type) {
        return false;
    }

    @Override
    public boolean epgConflictBook(EpgInfoDModel evtInfo, BookTypeDModel type, int bookId) {
        return false;
    }

    @Override
    public boolean epgCancelBook(EpgInfoDModel evtInfo) {
        return false;
    }


    @Override
    public void showEpgBookConflict(int bookId) {

    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(epgMethod)){
            epgMethod = null;
            INSTANCE = null;
        }
    }
}
