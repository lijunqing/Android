package com.xk.thread;


import com.xk.android.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class AsnyscTaskActivity extends Activity {
	private ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ansynctask);
		init();
	}
	public void init() {
		img=(ImageView)super.findViewById(R.id.img);
		//����һ��url����ַ����url
		String url="http://www3.clustrmaps.com/stats/maps-layer/1006000/1006303/www.cnblogs.com-hanyonglu--thumb-dots.png";
		MyAsnyscTask a=new MyAsnyscTask(img);//ʵ����MyAsnscTask
		a.execute(url);//����MyAsnscTask��execute������url����ȥ
	}
}
