package com.xk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.xk.android.R;

public class AppointActivity extends Activity {
	private Button but;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appoint);
		but = (Button) super.findViewById(R.id.button1);
	}
}
