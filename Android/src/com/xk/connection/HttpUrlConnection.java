package com.xk.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Handler;

public class HttpUrlConnection {
/**
 * HttpURLConnectionGet«Î«Û
 */
	public void urlconnectionGet(){
		new Thread(){
			@Override
			public void run() {
				try{
					URL url=new URL("");
					HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
					urlConnection.setRequestMethod("GET");
					urlConnection.setConnectTimeout(6000);
					urlConnection.setReadTimeout(6000);
					urlConnection.addRequestProperty("charset", "utf-8");
					if(urlConnection.getResponseCode() == 200){
						InputStream is = urlConnection.getInputStream();
						byte[] bt = new byte[is.available()];
						is.read(bt);
						String json = new String(bt);
						handler.sendMessage(handler.obtainMessage(1, json));
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {

		};
	};
	/**
	 * HttpURLConnectionPost«Î«Û
	 */
	public void uriconnectionpost(){
		new Thread(){
			@Override
			public void run() {
				super.run();
				try{

					URL url=new URL("");
					HttpURLConnection hc=(HttpURLConnection) url.openConnection();
					hc.setRequestMethod("POST");
					hc.setReadTimeout(6000);
					hc.setConnectTimeout(6000);
					hc.addRequestProperty("charset", "UTF-8");
					hc.setDoOutput(true);
					OutputStream op = hc.getOutputStream();
					PrintWriter p=new PrintWriter(op);
					p.print("key=814dfe2e4d61a16723d884647419bea3");
					p.flush();
					if(hc.getResponseCode()==200){
						InputStream is = hc.getInputStream();
						byte[] bt=new byte[is.available()];
						is.read(bt);
						String json=new String(bt);
						handler.sendMessage(handler.obtainMessage(2, json));
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}.start();
	}
}
