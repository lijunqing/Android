package com.xk.thread;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class MyAsnyscTask extends AsyncTask<String, integer, Bitmap>{
	private ImageView img;
	
	public MyAsnyscTask(ImageView img) {
		super();
		this.img = img;
	}
	@Override
	protected Bitmap doInBackground(String... params) {
		try {
			URL url=new URL(params[0]);//得到传过来的url地址
			InputStream is = url.openStream();//通过地址获得内容得到一个InputStream
			Bitmap bt = BitmapFactory.decodeStream(is);//通过Bitmap的工厂将得到的InputStream转换成Bitmap
			return bt;//返回bitmap
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	protected void onPostExecute(Bitmap result) {
		img.setImageBitmap(result);//将返回的Bitmap设置到页面
	}
}
