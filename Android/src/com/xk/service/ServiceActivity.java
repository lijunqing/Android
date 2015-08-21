package com.xk.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.xk.android.R;

public class ServiceActivity extends Activity{
	private Button start,stop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		start=(Button) findViewById(R.id.start);
		stop=(Button) findViewById(R.id.stop);
		final Intent intent=new Intent();
		intent.setAction("com.xk.service.service");
		start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(intent);
			}
		});
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stopService(intent);
			}
		});
	}
}
