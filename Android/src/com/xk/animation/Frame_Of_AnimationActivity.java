package com.xk.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.xk.android.R;
/**
 * Ö¡¶¯»­
 * @author jun
 *
 */
public class Frame_Of_AnimationActivity extends Activity {
	private ImageView img;
	private Button start;
	private Button stop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame__of__animation);
		img=(ImageView) findViewById(R.id.img);
		start=(Button)findViewById(R.id.btu);
		stop=(Button) findViewById(R.id.stop);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AnimationDrawable ad=(AnimationDrawable) img.getBackground();
				ad.start();
			}
		});
		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AnimationDrawable ad=(AnimationDrawable) img.getBackground();
				ad.stop();
			}
		});
	}
}
