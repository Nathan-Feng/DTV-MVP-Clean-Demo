package com.nathan.arch.domain.interactors.config.impl;

import com.nathan.arch.domain.interactors.config.PropertyConfigInteractor;
import com.nathan.arch.domain.model.PropertyGroupConfigDModel;
import com.nathan.arch.domain.model.PropertySwitchConfigDModel;
import com.nathan.arch.domain.model.SwitchOnOffDModel;
import com.nathan.arch.domain.repository.PropertyConfigRepository;
import com.nathan.arch.storage.PropertyConfigRepositoryImpl;

import java.util.Map;

public class PropertyConfigInteractorImpl implements PropertyConfigInteractor ,
        PropertyConfigRepository.Callback{
    private Callback mCallback;
    private PropertyConfigRepository mRepository;

    public PropertyConfigInteractorImpl(Callback callback){
        this.mCallback = callback;
        mRepository = PropertyConfigRepositoryImpl.getInstance();

    }


    @Override
    public int getGroupPropertyConfigValue(PropertyGroupConfigDModel groupValue) {
        return  mRepository.getGroupPropertyConfigValue(groupValue);
    }

    @Override
    public boolean setOrDoSetChoose(PropertyGroupConfigDModel groupValue, int value) {
        return mRepository.setOrDoSetChoose(groupValue,value);
    }

    @Override
    public SwitchOnOffDModel getPropertySwitchConfig(PropertySwitchConfigDModel switchConfig) {
        return mRepository.getPropertySwitchConfig(switchConfig);
    }

    @Override
    public boolean setPropertySwitchConfig(PropertySwitchConfigDModel switchConfig, SwitchOnOffDModel onOff) {
        return mRepository.setPropertySwitchConfig(switchConfig,onOff);
    }

    @Override
    public boolean setDVBPassword(String pwd) {
        return mRepository.setDVBPassword(pwd);
    }

    @Override
    public String getDVBPassword() {
        return mRepository.getDVBPassword();
    }

    @Override
    public Map<String,Integer> getRatingMapList() {
        return mRepository.getRatingMapList();
    }

    @Override
    public Map<String, Integer> getLangListByType(PropertyGroupConfigDModel configItem) {
        return mRepository.getLangListByType(configItem);
    }

    @Override
    public Map<String, Integer> getPropertyTimeZoneList() {
        return mRepository.getPropertyTimeZoneList();
    }

    @Override
    public void factoryReset() {
        mRepository.factoryReset();
    }

    @Override
    public String getStackVersion() {
        return mRepository.getStackVersion();
    }

    @Override
    public String getCleanJarVersion() {
        return mRepository.getCleanJarVersion();
    }


    @Override
    public void showFactoryResetSuccess() {
        mCallback.showFactoryResetSuccess();
    }

    @Override
    public void showFactoryResetFail() {
        mCallback.showFactoryResetFail();
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
        mRepository.attach(this);
    }

    @Override
    public void detach() {

    }
}
