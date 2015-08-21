package com.xk.boradcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class BroadCastReciverActivityDemo extends Activity{
	IntentFilter intentFilter = new IntentFilter();
	SMSBroadCastReciver receiver = new SMSBroadCastReciver();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
		registerReceiver(receiver, intentFilter);
		
		Intent intent = new Intent();
		intent.setAction("android.provider.Telephony.SMS_RECEIVED");
		sendBroadcast(intent);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}
}
