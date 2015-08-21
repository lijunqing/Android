package com.xk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.xk.android.R;
/**
 * StartActivityForResult跳转，有返回值
 * @author jun
 *
 */
public class StartActivityForResultActivity extends Activity {
	private Button but;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startacrivityforresult);
		but = (Button) super.findViewById(R.id.button1);
		but.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), ForResultActivity.class);
				Bundle bundle=new Bundle();
				String str1="aaaaaa";
				bundle.putString("str1", str1);
				intent.putExtras(bundle);
				startActivityForResult(intent, 0);
			}
		});
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) { //resultCode为回传的标记，我在B中回传的是RESULT_OK
		case RESULT_OK:
			Bundle b=data.getExtras(); //data为B中回传的Intent
			String str=b.getString("aaa");//str即为回传的值
			Log.i("aaa", "startActivityForResult"+str);
			break;
		}
	}
}
