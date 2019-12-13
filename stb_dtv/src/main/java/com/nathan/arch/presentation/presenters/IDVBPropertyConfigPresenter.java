package com.nathan.arch.presentation.presenters;

import com.nathan.arch.domain.model.PropertyGroupConfigDModel;
import com.nathan.arch.domain.model.PropertySwitchConfigDModel;
import com.nathan.arch.domain.model.SwitchOnOffDModel;
import com.nathan.arch.presentation.presenters.base.IDVBBasePresenter;
import com.nathan.arch.presentation.ui.IDVBBaseCallback;

import java.util.Map;

public interface IDVBPropertyConfigPresenter extends IDVBBasePresenter {

    void attach(Callback callback);

    interface Callback  extends IDVBBaseCallback {
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
}
