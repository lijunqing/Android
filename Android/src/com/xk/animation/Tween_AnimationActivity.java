package com.xk.animation;

import com.xk.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
/**
 * 补间动画
 * @author jun
 *
 */
public class Tween_AnimationActivity extends Activity {
	private ImageView img;
	private Button but;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	public void init(){
		img=(ImageView) findViewById(R.id.img);
		but=(Button) findViewById(R.id.btu);
		but.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final AlphaAnimation myAnimation_Alpha = new AlphaAnimation(0.1f, 1.0f);
				img.setAnimation(myAnimation_Alpha);
				myAnimation_Alpha.setDuration(2000);
				myAnimation_Alpha.start();
				myAnimation_Alpha.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation arg0) {
						Toast.makeText(Tween_AnimationActivity.this, "动画开始", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {

					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						RotateAnimation rotate = new RotateAnimation(0.0f, +360.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
						img.setAnimation(rotate);
						rotate.setDuration(2000);
						rotate.start();
						rotate.setAnimationListener(new AnimationListener() {

							@Override
							public void onAnimationStart(Animation arg0) {

							}

							@Override
							public void onAnimationRepeat(Animation arg0) {

							}

							@Override
							public void onAnimationEnd(Animation arg0) {
								ScaleAnimation Scale = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
										Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
								TranslateAnimation myAnimation_Translate = new TranslateAnimation(10f, 100f, 10f, 100f);
								img.setAnimation(myAnimation_Translate);
								img.setAnimation(Scale);
								myAnimation_Translate.setDuration(2000);
								Scale.setDuration(3000);
								Scale.start();
								myAnimation_Translate.start();

							}
						});
						Toast.makeText(Tween_AnimationActivity.this, "动画结束", Toast.LENGTH_SHORT).show();
					}
				});
			}
		});

	}
}


