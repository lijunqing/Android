package com.xk.animation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xk.android.R;

public class LayoutAnimationActivity extends Activity {
	private LinearLayout mRootLinearLayout;
	private Context mContext;
	private TextView mTextView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout_animation);
		init();
	}
	private void init(){
		mContext=this;
		mRootLinearLayout=(LinearLayout) findViewById(R.id.rootLinearLayout);
		mTextView=(TextView) findViewById(R.id.textView);
		mTextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Button button=new Button(mContext);
				button.setText("button");
				mRootLinearLayout.addView(button);
			}
		});
	}
}
