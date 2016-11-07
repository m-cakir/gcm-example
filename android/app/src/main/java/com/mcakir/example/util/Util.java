package com.mcakir.example.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class Util {

    public static void toast(Context context, String message){

        if(!TextUtils.isEmpty(message)){

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

        }
    }

}
