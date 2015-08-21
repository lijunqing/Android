package com.xk.animation;

import com.xk.android.R;

import android.os.Bundle;
import android.view.View;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
/**
 *  Ù–‘∂Øª≠
 * @author jun
 *
 */
public class ObjectAnimatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_object_animator);
		
	}
	@SuppressLint("NewApi")
	public void rotateyAnimRun(View view)  
	    {  
	         ObjectAnimator//  
	         .ofFloat(view, "rotationX", 0.0F, 360.0F)//  
	         .setDuration(500)//  
	         .start();  
	    }  
}
