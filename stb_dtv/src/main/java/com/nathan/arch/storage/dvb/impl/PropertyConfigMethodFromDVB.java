package com.nathan.arch.storage.dvb.impl;

import com.nathan.arch.storage.dvb.ICallbackPropertyConfigMethod;

/**
 * @author Nathan
 */
public class PropertyConfigMethodFromDVB implements ICallbackPropertyConfigMethod {

    private static final String CLEAN_JAR_VERSION = "0.9.1";
    private Callback callback;

    public PropertyConfigMethodFromDVB(Callback callback){
        this.callback = callback;
    }

}
