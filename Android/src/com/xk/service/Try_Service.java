package com.xk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class Try_Service extends Service{

	//����Ҫ��д�ķ���
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	//�����ص������õķ���
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("aaa", "service��������");
	}
	//����service���õķ���
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("aaa", "service��������");	
		return START_NOT_STICKY;
	}
	//ֹͣservice���õķ���
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("aaa", "service��������");
	}
}
