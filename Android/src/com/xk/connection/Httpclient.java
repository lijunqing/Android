package com.xk.connection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.Handler;
import android.os.Message;

public class Httpclient {
	/**
	 * httpclientpost«Î«Û
	 */
	public void httpclentpost(){
		new Thread(){
			public void run() {
				try {
					String url="http://japi.juhe.cn/qqevaluate/qq";
					HttpClient ht = new DefaultHttpClient();
					HttpPost hp=new HttpPost(url);
					List<NameValuePair> parm=new ArrayList<NameValuePair>();
					parm.add(new BasicNameValuePair("key", "336ddaca63caed3b4274e3fea7599f3c"));
					parm.add(new BasicNameValuePair("qq", ""));
					hp.setEntity(new UrlEncodedFormEntity(parm));
					HttpResponse res = ht.execute(hp);
					if(res.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
//						HttpEntity et = res.getEntity();
//						String json = EntityUtils.toString(et);
//						//						Gson gson=new Gson();
						//						Mydata data=gson.fromJson(json, Mydata.class);
						//						handler.sendMessage(handler.obtainMessage(1, data));
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}


	Handler handler=new Handler(){
		public void handleMessage(Message msg) {
			if(msg.what==1){
 				//				end.setText(data.getResult().getData().getConclusion());
				//				end1.setText(data.getResult().getData().getAnalysis());
			}
		};
	};
	/**
	 * httpclientget«Î«Û
	 */
	public void httpclientget(){
		new Thread(){
			@Override
			public void run() {
				try {
					HttpClient ht = new DefaultHttpClient();
					String url="http://api2.juheapi.com/carzone/category/list?key=814dfe2e4d61a16723d884647419bea3";
					HttpUriRequest request = new HttpGet(url);
					HttpResponse res = ht.execute(request);
					if(res.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
						HttpEntity ey = res.getEntity();
						String json=EntityUtils.toString(ey);
						handler.sendMessage(handler.obtainMessage(1, json));
						ht.getConnectionManager().shutdown();
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	Handler handler1=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
//				Gson gson=new Gson();
//				String json=(String) msg.obj;
//				MyData data = gson.fromJson(json, MyData.class);
//				Adapter adapter=new Adapter(data.getResult(), HttpClienGetActivity.this);
//				listview.setAdapter(adapter);
			}
		};
	};
}


