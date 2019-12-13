package com.nathan.arch.storage.tools;

import android.util.Log;

public class LogTool {
    private static final String MSG_SEPARATOR = ",-";
    private static final String MSG_EMPTY = "Empty Msg";
    private static final int STACK_LEVEL = 5;

    public static final int NOLOG   = 0;
    public static final int ERROR   = 1;
    public static final int WARNING = 2;
    public static final int INFO    = 4 ;
    public static final int DEBUG   = 8;
    public static final int VERBOSE =16;

    public static final int MAUDSUBTTX  = 1;
    public static final int MCHANNEL    = 2;
    public static final int MCLOCK      = 4;
    public static final int MEPG        = 8;
    public static final int MMAIN       = 16;
    public static final int MPVR        = 32;
    public static final int MSCAN       = 64;
    public static final int MRECODER    = 128;
    public static final int MBASE       = 256;
    public static final int MPLAY       = 512;
    public static final int MSETTING    = 1024;
    public static final int MTIMESHIFT  = 2048;
    public static final int MBOOK       = 4096;
    public static final int MALLLOG     = 0xFFFFFFF;

    private static int mModuleType = MALLLOG;
    private static int mLogLevel = NOLOG;


    /**
     * @param nLevel from NOLOG,ERROR,WARNING,INFO,DEBUG,VERBOSE
     */
    public static void setLogLevel(int nLevel){
        mLogLevel = NOLOG;
        switch (nLevel){
            case VERBOSE:
                mLogLevel = mLogLevel + VERBOSE;
            case DEBUG:
                mLogLevel = mLogLevel + DEBUG;
            case INFO:
                mLogLevel = mLogLevel + INFO;
            case WARNING:
                mLogLevel = mLogLevel + WARNING;
            case ERROR:
                mLogLevel = mLogLevel + ERROR;
            default:
                mLogLevel = NOLOG;
                break;
        }
    }

    public static void setLogModule(int nModule){
        mModuleType = nModule;
    }

    public static void v(int nModule,String pMsg){
        if ((0 != (mLogLevel & VERBOSE) && (0 != (mModuleType & nModule)))){
            Log.v(getFinalTag(),getFinalTag(pMsg));
        }
    }

    public static void d(int nModule,String pMsg){
        if ((0 != (mLogLevel & DEBUG) && (0 != (mModuleType & nModule)))){
            Log.v(getFinalTag(),getFinalTag(pMsg));
        }
    }

    public static void i(int nModule,String pMsg){
        if ((0 != (mLogLevel & INFO) && (0 != (mModuleType & nModule)))){
            Log.v(getFinalTag(),getFinalTag(pMsg));
        }
    }

    public static void w(int nModule,String pMsg){
        if ((0 != (mLogLevel & WARNING) && (0 != (mModuleType & nModule)))){
            Log.v(getFinalTag(),getFinalTag(pMsg));
        }
    }

    public static void e(int nModule,String pMsg){
        if ((0 != (mLogLevel & ERROR) && (0 != (mModuleType & nModule)))){
            Log.v(getFinalTag(),getFinalTag(pMsg));
        }
    }


    private static String getFinalTag(String pMsg){
        if (pMsg.isEmpty()){
            pMsg = MSG_EMPTY;
        }

        StringBuffer mBuf = new StringBuffer();
        mBuf.append(getMethodName());
        mBuf.append(MSG_SEPARATOR);
        mBuf.append(getLineNumber());
        mBuf.append(MSG_SEPARATOR);
        mBuf.append(pMsg);
        return mBuf.toString();
    }

    private static String getFinalTag(){
        return getClassName();
    }

    private static String getLineNumber(){
        StringBuffer mBuf = new StringBuffer();
        mBuf.append("L");
        mBuf.append(Thread.currentThread().getStackTrace()[STACK_LEVEL].getLineNumber());
        return mBuf.toString();
    }

    private static String getMethodName(){
        return Thread.currentThread().getStackTrace()[STACK_LEVEL].getMethodName();
    }

    private static String getClassName(){
        String strClassName = Thread.currentThread().getStackTrace()[STACK_LEVEL].getClassName();
        String strRet = strClassName;
        int nLow = strClassName.lastIndexOf(".") +1;
        if ((nLow > 0) && (nLow < strClassName.length())){
            strRet = strClassName.substring(nLow);
        }
        return strRet;
    }
}
