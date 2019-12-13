package com.nathan.arch.storage;

import com.nathan.arch.domain.model.PropertyGroupConfigDModel;
import com.nathan.arch.domain.model.PropertySwitchConfigDModel;
import com.nathan.arch.domain.model.SwitchOnOffDModel;
import com.nathan.arch.domain.repository.PropertyConfigRepository;
import com.nathan.arch.storage.dvb.ICallbackPropertyConfigMethod;
import com.nathan.arch.storage.dvb.impl.PropertyConfigMethodFromDVB;
import com.nathan.arch.storage.tools.EmptyTool;

import java.util.Map;


/**
 * @author Nathan
 */
public class PropertyConfigRepositoryImpl implements PropertyConfigRepository ,
        PropertyConfigMethodFromDVB.Callback{


    private Callback mCallback;
    private ICallbackPropertyConfigMethod mMethod ;

    private static PropertyConfigRepositoryImpl instance = null;
    public static synchronized  PropertyConfigRepositoryImpl getInstance(){
        if (EmptyTool.isEmpty(instance )){
            instance=new PropertyConfigRepositoryImpl();
        }
        return instance;
    }
    private PropertyConfigRepositoryImpl(){
        mMethod = new PropertyConfigMethodFromDVB(this);
    }

    private boolean setPropertyConfigValue(PropertyGroupConfigDModel groupValue,int value){
        return false;
    }

    /**
     * @param groupValue
     * @param value
     * @return
     */
    private boolean doSetGroupPropertyConfigValue(PropertyGroupConfigDModel groupValue,int value){
        return false;
    }

    @Override
    public void attach(Callback callback) {
        this.mCallback = callback;
    }

    /**
     * *************************************************************************************
     *
     */
    @Override
    public int getGroupPropertyConfigValue(PropertyGroupConfigDModel groupValue){
        return -1;
    }

    @Override
    public boolean setOrDoSetChoose(PropertyGroupConfigDModel groupValue,int value){
        if (groupValue == PropertyGroupConfigDModel.SCREEN_RATIO  ||
            groupValue == PropertyGroupConfigDModel.DIG_AUDIO_BYPASS  ||
            groupValue == PropertyGroupConfigDModel.P_SHOW_NO_TYPE ||
            groupValue == PropertyGroupConfigDModel.UTC_TOT_REGION_ID ||
            groupValue == PropertyGroupConfigDModel.P_SORT_TYPE){
            return doSetGroupPropertyConfigValue( groupValue, value);
        } else {
            return setPropertyConfigValue(groupValue,value);
        }
    }

    @Override
    public SwitchOnOffDModel getPropertySwitchConfig(PropertySwitchConfigDModel switchConfig){
        return SwitchOnOffDModel.OFF;
    }

    @Override
    public boolean setPropertySwitchConfig(PropertySwitchConfigDModel switchConfig, SwitchOnOffDModel onOff){
        return false;
    }

    @Override
    public boolean setDVBPassword(String pwd){
        return false;
    }

    @Override
    public String getDVBPassword(){
        return "";
    }

    @Override
    public Map<String,Integer> getRatingMapList(){
        return  null;
    }

    @Override
    public Map<String, Integer> getLangListByType(PropertyGroupConfigDModel configItem) {
        return  null;
    }

    @Override
    public Map<String, Integer> getPropertyTimeZoneList() {
        return  null;
    }

    @Override
    public void factoryReset() {

    }

    @Override
    public String getStackVersion() {
        return "";
    }

    @Override
    public String getCleanJarVersion() {
        return "";
    }

    @Override
    public void showFactoryResetSuccess() {
        if (EmptyTool.isNotEmpty(mCallback)) mCallback.showFactoryResetSuccess();
    }

    @Override
    public void showFactoryResetFail() {
        if (EmptyTool.isNotEmpty(mCallback)) mCallback.showFactoryResetFail();
    }


    @Override
    public void detach() {
         mMethod  = null;
        mCallback = null;
        instance = null;
    }
}
