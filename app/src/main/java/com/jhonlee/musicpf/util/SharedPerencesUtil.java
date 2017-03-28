package com.jhonlee.musicpf.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JhoneLee on 2017/3/28.
 */

public class SharedPerencesUtil {

    public static void setPlayTpye(Context context,int playType){
        SharedPreferences preferences = context.getSharedPreferences("playType",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("playType",playType);
        editor.commit();
    }
    public static int getPlayTpye(Context context){
        SharedPreferences preferences = context.getSharedPreferences("playType",Context.MODE_PRIVATE);
        return  preferences.getInt("playType",Const.STATE_SHUNXU);
    }
}
