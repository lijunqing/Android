package com.xk.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSBroadCastReciver extends BroadcastReceiver{
	private static final String mACTION="android.provider.Telephony.SMS_RECEIVED";
	@Override
	public void onReceive(Context context, Intent intent) {
		String mACTION = intent.getAction();
		if(intent.getAction().equals(mACTION)){
			StringBuilder sb=new StringBuilder();
			Bundle bundle=intent.getExtras();
			if(bundle!=null)
			{
				Object[] obj=(Object[])bundle.get("pdus");
				//构建信息对象
				SmsMessage[] message=new SmsMessage[obj.length];
				for(int i=0;i<obj.length;i++)
				{
					message[i]=SmsMessage.createFromPdu((byte[])obj[i]);
				}

				for(SmsMessage currentMessage:message)
				{
					sb.append("接收到来自:/n");                    
					//发送人的电话号码
					sb.append(currentMessage.getDisplayOriginatingAddress());
					sb.append("/n-------传来的信息---------/n");
					//发送的信息内容
					sb.append(currentMessage.getDisplayMessageBody());
				}
			}
			//以Notification显示来讯信息
			Toast.makeText(context,sb.toString(), Toast.LENGTH_LONG).show();
		}
	}
}
