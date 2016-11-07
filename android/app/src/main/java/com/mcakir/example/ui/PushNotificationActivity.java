package com.mcakir.example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mcakir.example.R;
import com.mcakir.example.log.Logger;
import com.mcakir.example.util.Util;

public class PushNotificationActivity extends AppCompatActivity {

    private Logger logger = Logger.getLogger(PushNotificationActivity.class.getSimpleName());

    public static String EXTRA_PUSH_MESSAGE_KEY = "EXTRA_PUSH_MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        String message = bundle != null ? bundle.getString(EXTRA_PUSH_MESSAGE_KEY) : "";

        Util.toast(getApplicationContext(), message);

        logger.debug("message: " + message);
    }

}
