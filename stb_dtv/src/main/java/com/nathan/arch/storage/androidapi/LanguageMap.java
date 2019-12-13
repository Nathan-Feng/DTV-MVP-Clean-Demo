package com.nathan.arch.storage.androidapi;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class LanguageMap {
    private static final String DEFAULT_FILE = "en-US_ISO639.properties";
    private static final String DEFAULT_FILE_TAIL = "_ISO639.properties";
    private String mFileName;
    private Context mContext;
    /*qaa*/
    private static final String en_str_qaa = "Original Language";
    private static final String zh_str_qaa = "\u539f\uf9cb\u8bed\u8a00";

    /*qad*/
    private static final String en_str_qad = "Audio Description";
    private static final String zh_str_qad = "\u97f3\u9891\u63cf\u8ff0";

    public LanguageMap(Context context){
        mContext = context;
    }

    private String getPropertiesFileName(){
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        mFileName = language + "-" + country + DEFAULT_FILE_TAIL;
        return mFileName;
    }

    public String getLanguage(String languageCode){

        Properties languageProperties = new Properties();
        boolean isFileExist = true;
        InputStream in1 = null;
        InputStream in2 = null;
        try {
            in1 = mContext.getAssets().open(getPropertiesFileName());
            languageProperties.load(in1);
            in1.close();
        } catch (IOException e) {
            e.printStackTrace();
            isFileExist = false;
        }

        if (!isFileExist){
            try {
                in2 = mContext.getAssets().open(DEFAULT_FILE);
                languageProperties.load(in2);
                in2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if ( null != in1){
                in1.close();
            }
            if ( null != in2){
                in2.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (languageCode == null || languageCode.isEmpty()){
            return languageProperties.getProperty("unknown");
        }
        String systemLanguge = Locale.getDefault().getLanguage();
        String language = languageProperties.getProperty(languageCode.toLowerCase(Locale.getDefault()));
        if (language != null){
            return language;
        }else if ((languageCode.length() > 0) && ((languageCode.charAt(0) == 'q') || (languageCode.charAt(0) == 'Q'))){
            if (systemLanguge.equals("zh")){
                if (languageCode.equalsIgnoreCase("qaa")
                        || languageCode.equalsIgnoreCase("qab")
                        || languageCode.equalsIgnoreCase("qac")){
                    return zh_str_qaa;
                } else if (languageCode.equalsIgnoreCase("qad")){
                    return zh_str_qad;
                } else {
                    return languageProperties.getProperty("reserved");
                }
            } else {
                if (languageCode.equalsIgnoreCase("qaa")
                        || languageCode.equalsIgnoreCase("qab")
                        || languageCode.equalsIgnoreCase("qac")){
                    return en_str_qaa;
                } else if (languageCode.equalsIgnoreCase("qad")){
                    return en_str_qad;
                } else {
                    return languageCode;
                }
            }
        }else if (languageCode.length() > 0 && languageCode.equalsIgnoreCase("nar")){
            return languageCode;
        } else {
            return languageProperties.getProperty("unknown");
        }
    }

}
