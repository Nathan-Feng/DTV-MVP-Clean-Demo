package com.nathan.arch.storage;

import com.nathan.arch.domain.model.PVRInfoDModel;
import com.nathan.arch.domain.repository.PVRRepository;
import com.nathan.arch.storage.dvb.ICallbackPVRMethod;
import com.nathan.arch.storage.dvb.impl.PVRMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import timber.log.Timber;

/**
 * Created by Nathan on 1/29/16.
 */
public class PVRRepositoryImpl implements PVRRepository,
        ICallbackPVRMethod.Callback
{
    private ICallbackPVRMethod pvrMethodFromDVB ;
    private Callback mCallback;

    private static PVRRepositoryImpl instance = null;
    public static synchronized  PVRRepositoryImpl getInstance(){
        if (instance == null){
            instance=new PVRRepositoryImpl();
        }
        return instance;
    }

    private PVRRepositoryImpl(){
        Timber.d("Nathan new PVRRepositoryImpl :callback");
        pvrMethodFromDVB = new PVRMethodFromDVB(this);
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    @Override
    public boolean startPVR() {
        return pvrMethodFromDVB.startPVR();
    }

    @Override
    public boolean stopPVR() {
        return pvrMethodFromDVB.stopPVR();
    }

    @Override
    public PVRInfoDModel getPVRInfo() {
        String name = pvrMethodFromDVB.getPVRName();
        String time = pvrMethodFromDVB.getPVRTime();
        int id = pvrMethodFromDVB.getPVRNameID();
        PVRInfoDModel model= new PVRInfoDModel();
        model.setProgId(id);
        model.setPVRName(name);
        model.setPVRTotalTime(time);
        return model;
    }

    @Override
    public void showError(String message) {
        if (EmptyTool.isNotEmpty(mCallback)) mCallback.showError(message);
    }

    @Override
    public void showPVRStorageFull() {
        if (EmptyTool.isNotEmpty(mCallback)) mCallback.showPVRStorageFull();
    }

    @Override
    public void showPVRIsRecording() {
        if (EmptyTool.isNotEmpty(mCallback)) mCallback.showPVRIsRecording();
    }

    @Override
    public void detach() {
        if (EmptyTool.isNotEmpty(pvrMethodFromDVB)){
            pvrMethodFromDVB.detach();
            pvrMethodFromDVB = null;
            mCallback = null;
            instance = null;
        }
    }
}
