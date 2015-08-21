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
			URL url=new URL(params[0]);//�õ���������url��ַ
			InputStream is = url.openStream();//ͨ����ַ������ݵõ�һ��InputStream
			Bitmap bt = BitmapFactory.decodeStream(is);//ͨ��Bitmap�Ĺ������õ���InputStreamת����Bitmap
			return bt;//����bitmap
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	protected void onPostExecute(Bitmap result) {
		img.setImageBitmap(result);//�����ص�Bitmap���õ�ҳ��
	}
}
