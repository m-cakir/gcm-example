package com.mcakir.example.log;

import android.util.Log;

public class Logger {

	private String prefix;
    private String tag;
	
	public static final boolean IS_LOG_ACTIVE = true;
	
	private Logger(String tag, String prefiks) {
        this.tag = tag;
		this.prefix = prefiks;
	}
	
	public static Logger getLogger(String prefiks){
		return new Logger("GCMAndroidClient", prefiks);
	}

	public void debug(String message) {
		if(IS_LOG_ACTIVE){

			Log.d(tag, prefix + "." + message);

		}
	}

	public void info(String message) {
		if(IS_LOG_ACTIVE){

			Log.i(tag, prefix + "." + message);

		}
	}

	public void warning(String message) {
		if(IS_LOG_ACTIVE){

			Log.w(tag, prefix + "." + message);

		}
	}

	public void error(String message) {
		if(IS_LOG_ACTIVE){

			Log.e(tag, prefix + "." + message);

		}
	}
}
