package com.appsolut.example.aidlDisplayRemoteMessage;

import com.appsolut.example.aidlMessageServiceUsingParcelable.MyParcelableMessage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DisplayRemoteParcelableMessage extends Activity {
    private Button disconnectButton;
    private Button queryButton;
    private TextView messageTextView;
    private RemoteParcelableMessageServiceServiceConnection remoteServiceConnection;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        remoteServiceConnection = new RemoteParcelableMessageServiceServiceConnection(this);
        disconnectButton = (Button)findViewById(R.id.disconnectButton);
        queryButton = (Button)findViewById(R.id.queryButton);
        messageTextView = (TextView)findViewById(R.id.parcelableMessageTextView);
       
        disconnectButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				remoteServiceConnection.safelyDisconnectTheService();
			}
		});
        
        queryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				remoteServiceConnection.safelyQueryMessage();
			}
		});
    }
    
    void theMessageWasReceivedAsynchronously(MyParcelableMessage message) {
    	message.applyMessageToTextView(messageTextView);
    }
}