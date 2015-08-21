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
 * StartActivityForResult��ת���з���ֵ
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
		switch (resultCode) { //resultCodeΪ�ش��ı�ǣ�����B�лش�����RESULT_OK
		case RESULT_OK:
			Bundle b=data.getExtras(); //dataΪB�лش���Intent
			String str=b.getString("aaa");//str��Ϊ�ش���ֵ
			Log.i("aaa", "startActivityForResult"+str);
			break;
		}
	}
}
