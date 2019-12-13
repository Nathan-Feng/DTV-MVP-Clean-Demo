package com.nathan.arch.domain.interactors.config;

import com.nathan.arch.domain.interactors.base.IDVBBaseInteractorCallback;
import com.nathan.arch.domain.interactors.base.Interactor;
import com.nathan.arch.domain.model.PropertyGroupConfigDModel;
import com.nathan.arch.domain.model.PropertySwitchConfigDModel;
import com.nathan.arch.domain.model.SwitchOnOffDModel;

import java.util.Map;

public interface PropertyConfigInteractor extends Interactor {

    interface Callback extends IDVBBaseInteractorCallback {
        void showFactoryResetSuccess();
        void showFactoryResetFail();
    }

    int getGroupPropertyConfigValue(PropertyGroupConfigDModel groupValue);
    boolean setOrDoSetChoose(PropertyGroupConfigDModel groupValue, int value);
    SwitchOnOffDModel getPropertySwitchConfig(PropertySwitchConfigDModel switchConfig);

    boolean setPropertySwitchConfig(PropertySwitchConfigDModel switchConfig, SwitchOnOffDModel onOff);

    boolean setDVBPassword(String pwd);
    String getDVBPassword();

    Map<String,Integer> getRatingMapList();
    Map<String,Integer> getLangListByType(PropertyGroupConfigDModel configItem);
    Map<String,Integer> getPropertyTimeZoneList();
    void factoryReset();

    String getStackVersion();
    String getCleanJarVersion();

    void attach(Callback callback);
}
