package com.xk.activity;

import com.xk.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
/**
 * Activity的生命周期
 * @author jun
 *
 */
public class LifeActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("aaa", "Activity被创建");
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("aaa", "Activity被销毁");
	}
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i("aaa", "Activity被启动");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("aaa", "Activity被停止");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("aaa", "Activity被暂停");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("aaa", "Activity被重新启动");
	}
}
