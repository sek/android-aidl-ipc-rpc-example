/* The package where the aidl file is located */
package com.appsolut.example.aidlMessageServiceUsingParcelable;

/* Import our Parcelable message */
import com.appsolut.example.aidlMessageServiceUsingParcelable.MyParcelableMessage;

/* The name of the remote service */
interface IRemoteParcelableMessageService {

	/* A simple Method which will return a message
	 * The message object implements the Parcelable interface 
	 */
	MyParcelableMessage getMessage();

}