This example demonstrates the use of Remote Procedure Calls (RPC) / Inter Process Communication (IPC) in Android. It consists of four apps:

- AIDLMessageService and AIDLDisplayRemoteMessage:
These projects contain a Service and an Activity. The Activity will connect to the Service using the Android RPC mechanism and will query a String from that Service.

- AIDLRemoteClientUsingParcelableObject and AIDLRemoteMessageServiceUsingParcelableObject:
These projects are slightly modified versions of the first example. They also contain a Service and an Activity. The Activity will connect to the Service using the Android RPC mechanism and will query a self-defined Parcelable object.

See http://app-solut.com/blog/2011/04/using-the-android-interface-definition-language-aidl-to-make-a-remote-procedure-call-rpc-in-android for a detailed AIDL tutorial.

And http://app-solut.com/blog/2011/05/using-self-defined-parcelable-objects-during-an-android-aidl-rpc-ipc-call for the corresponding blog post on how to define and use Parcelables.