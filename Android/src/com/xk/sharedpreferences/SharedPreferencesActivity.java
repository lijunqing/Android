package com.xk.sharedpreferences;

import com.xk.android.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SharedPreferencesActivity extends Activity {
	private SharedPreferences share;
	private SharedPreferences.Editor edit;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sharedprefences);
		tv = (TextView) super.findViewById(R.id.share);
		share = getSharedPreferences("myshare", Context.MODE_PRIVATE);
		edit = share.edit();
		if(share.getString("first", "aa").equals("")){
			tv.setText(share.getString("first", ""));
		}else{
			edit.putString("first", "aaa");
			edit.commit();
		}
	}
}
