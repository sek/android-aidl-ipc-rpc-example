package com.appsolut.example.aidlMessageService;

import java.text.SimpleDateFormat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AIDLMessageService extends Service {
	private static final String APPSOLUT_INTENT_ACTION_BIND_MESSAGE_SERVICE = "appsolut.intent.action.bindMessageService";
	private final static String LOG_TAG = AIDLMessageService.class.getCanonicalName();

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(LOG_TAG,"The AIDLMessageService was created.");
	}

	@Override
	public void onDestroy() {
		Log.d(LOG_TAG,"The AIDLMessageService was destroyed.");
		super.onDestroy();
	}


	@Override
	public IBinder onBind(Intent intent) {
		if(APPSOLUT_INTENT_ACTION_BIND_MESSAGE_SERVICE.equals(intent.getAction())) {
			Log.d(LOG_TAG,"The AIDLMessageService was binded.");
			return new TimeMessageService(this);
		}
		return null;
	}

	String getStringForRemoteService() {
		return getString(R.string.time_message) + (new SimpleDateFormat(" hh:mm:ss").format(System.currentTimeMillis()));
	}

}
