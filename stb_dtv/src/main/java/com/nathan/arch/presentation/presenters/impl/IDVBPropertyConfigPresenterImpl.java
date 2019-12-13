package com.nathan.arch.presentation.presenters.impl;

import com.nathan.arch.domain.interactors.config.PropertyConfigInteractor;
import com.nathan.arch.domain.interactors.config.impl.PropertyConfigInteractorImpl;
import com.nathan.arch.domain.model.PropertyGroupConfigDModel;
import com.nathan.arch.domain.model.PropertySwitchConfigDModel;
import com.nathan.arch.domain.model.SwitchOnOffDModel;
import com.nathan.arch.presentation.presenters.IDVBPropertyConfigPresenter;
import com.nathan.arch.storage.tools.EmptyTool;

import java.lang.ref.WeakReference;
import java.util.Map;

public class IDVBPropertyConfigPresenterImpl implements IDVBPropertyConfigPresenter,
        PropertyConfigInteractor.Callback{
    private Callback mCallback;
    private PropertyConfigInteractor mInteractor;

    public IDVBPropertyConfigPresenterImpl(){
        mInteractor = new PropertyConfigInteractorImpl(this);
    }


    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        mInteractor.attach(this);
    }

    @Override
    public int getGroupPropertyConfigValue(PropertyGroupConfigDModel groupValue) {
        return  mInteractor.getGroupPropertyConfigValue(groupValue);
    }

    @Override
    public boolean setOrDoSetChoose(PropertyGroupConfigDModel groupValue, int value) {
        return mInteractor.setOrDoSetChoose(groupValue,value);
    }

    @Override
    public SwitchOnOffDModel getPropertySwitchConfig(PropertySwitchConfigDModel switchConfig) {
        return mInteractor.getPropertySwitchConfig(switchConfig);
    }

    @Override
    public boolean setPropertySwitchConfig(PropertySwitchConfigDModel switchConfig, SwitchOnOffDModel onOff) {
        return mInteractor.setPropertySwitchConfig(switchConfig,onOff);
    }

    @Override
    public boolean setDVBPassword(String pwd) {
        return mInteractor.setDVBPassword(pwd);
    }

    @Override
    public String getDVBPassword() {
        return mInteractor.getDVBPassword();
    }

    @Override
    public Map<String,Integer> getRatingMapList() {
        return mInteractor.getRatingMapList();
    }

    @Override
    public Map<String, Integer> getLangListByType(PropertyGroupConfigDModel configItem) {
        return mInteractor.getLangListByType(configItem);
    }

    @Override
    public Map<String, Integer> getPropertyTimeZoneList() {
        return mInteractor.getPropertyTimeZoneList();
    }

    @Override
    public void factoryReset() {
        mInteractor.factoryReset();
    }

    @Override
    public String getStackVersion() {
        return mInteractor.getStackVersion();
    }

    @Override
    public String getCleanJarVersion() {
        return mInteractor.getCleanJarVersion();
    }

    @Override
    public void showFactoryResetSuccess() {
        if (EmptyTool.isNotEmpty(mCallback)){
            mCallback.showFactoryResetSuccess();
        }
    }

    @Override
    public void showFactoryResetFail() {
        if (EmptyTool.isNotEmpty(mCallback)) {
            mCallback.showFactoryResetFail();
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void detach() {

    }

    private boolean checkNullable(WeakReference<Callback> mCallback){
        if (mCallback != null && mCallback.get() != null){
            return true;
        }
        return false;
    }
}
