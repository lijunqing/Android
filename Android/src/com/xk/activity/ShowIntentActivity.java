package com.xk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.xk.android.R;
/**
 * activityÒþÊ½Ìø×ª
 * @author jun
 *
 */
public class ShowIntentActivity extends Activity {
	private Button but;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_intent);
		but = (Button) super.findViewById(R.id.intentbutton1);
		but.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("com.xk.activity.intent.action.AppointActivity");
				startActivity(intent);
			}
		});
	}
}
