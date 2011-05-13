package com.appsolut.example.aidlMessageServiceUsingParcelable;

import android.graphics.Typeface;
import android.os.RemoteException;

public class TimeParcelableMessageService extends IRemoteParcelableMessageService.Stub {
	private final static int MAX_FONT_SIZE_INCREASE = 40;
	private final static int MIN_FONT_SIZE = 10;
	
	private final AIDLParcelableMessageService service;

	public TimeParcelableMessageService(AIDLParcelableMessageService service) {
		this.service = service;
	}
	
	@Override
	public MyParcelableMessage getMessage() throws RemoteException {
		String message = service.getStringForRemoteService();
		int fontSize = (int)(Math.random()*MAX_FONT_SIZE_INCREASE) + MIN_FONT_SIZE;
		int textColor = (int)(Math.random()*Integer.MAX_VALUE);
		
		int randomTextStyleSelector = (int)(Math.random()*3);
		int textStyle;
		switch (randomTextStyleSelector) {
		case 0:
			textStyle = Typeface.BOLD;
			break;
		case 1:
			textStyle = Typeface.BOLD_ITALIC;
			break;
		case 2:
			textStyle = Typeface.ITALIC;
			break;
		default:
			textStyle = Typeface.NORMAL;
			break;
		}
		
		return new MyParcelableMessage(message, fontSize, textColor, Typeface.defaultFromStyle(textStyle));
	}

}
