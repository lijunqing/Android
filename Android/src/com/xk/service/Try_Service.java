package com.xk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class Try_Service extends Service{

	//必须要重写的方法
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	//创建回调函数用的方法
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("aaa", "service被创建了");
	}
	//启动service调用的方法
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("aaa", "service被启动了");	
		return START_NOT_STICKY;
	}
	//停止service调用的方法
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("aaa", "service被销毁了");
	}
}
