package com.mcakir.example.gcm;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.mcakir.example.log.Logger;
import com.mcakir.example.util.Util;

import java.io.IOException;

public class GcmRegister extends AsyncTask<Void, Void, Boolean> {

    private final static Logger logger = Logger.getLogger(GcmRegister.class.getName());

    private String GOOGLE_PROJECT_ID = "PROJECT_ID";

    private Context context;

    private GoogleCloudMessaging gcm;

    private String registrationId = null;

    public GcmRegister(Context context, GoogleCloudMessaging gcm){
        this.context = context;
        this.gcm = gcm;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... arg0) {
        try {
            if (gcm == null) {
                gcm = GoogleCloudMessaging.getInstance(context);
            }

            registrationId = gcm.register(GOOGLE_PROJECT_ID);

            if(!TextUtils.isEmpty(registrationId)){
                storeOnServer();
            }

            return true;

        } catch (IOException ex) {

            logger.error("doInBackground > e: " + ex.getMessage());

        }

        return false;
    }

    private void storeOnServer() {

        logger.info("storeOnServer > registrationId: " + registrationId);

        // post to your server
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);

        if(!TextUtils.isEmpty(registrationId)){
            Util.toast(context, "Registration is success");
        }

    }
}
