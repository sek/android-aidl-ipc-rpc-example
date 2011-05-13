package com.appsolut.example.aidlMessageServiceUsingParcelable;

import java.text.SimpleDateFormat;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AIDLParcelableMessageService extends Service {
	private static final String APPSOLUT_INTENT_ACTION_BIND_MESSAGE_SERVICE = "appsolut.intent.action.bindParcelableMessageService";
	private final static String LOG_TAG = AIDLParcelableMessageService.class.getCanonicalName();

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(LOG_TAG,"The AIDLParcelableMessageService was created.");
	}

	@Override
	public void onDestroy() {
		Log.d(LOG_TAG,"The AIDLParcelableMessageService was destroyed.");
		super.onDestroy();
	}


	@Override
	public IBinder onBind(Intent intent) {
		if(APPSOLUT_INTENT_ACTION_BIND_MESSAGE_SERVICE.equals(intent.getAction())) {
			Log.d(LOG_TAG,"The AIDLParcelableMessageService was binded.");
			return new TimeParcelableMessageService(this);
		}
		return null;
	}

	String getStringForRemoteService() {
		return getString(R.string.time_message) + (new SimpleDateFormat(" hh:mm:ss").format(System.currentTimeMillis()));
	}

}
