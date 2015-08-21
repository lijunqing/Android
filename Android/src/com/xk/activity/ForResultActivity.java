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
 * ָ����ת��Activity
 * @author jun
 *
 */
public class ForResultActivity extends Activity {
	private Button but;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startacrivityforresult);
		but = (Button) super.findViewById(R.id.button2);
		but.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = getIntent();
				Log.i("aaa","forresult"+ intent.getStringExtra("str1"));
				intent.putExtra("aaa", "zhangsan");
				setResult(RESULT_OK, intent); //intentΪA�����Ĵ���Bundle��intent����ȻҲ�����Լ������µ�Bundle
				finish();//�˴�һ��Ҫ����finish()����
			}
		});
	}
}
