package com.xk.contentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class ContentProviderWireActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Context ctx=ContentProviderWireActivity.this;
		ContentResolver resolver =ctx.getContentResolver();
		Uri uri=Uri.parse("content://com.example.androidtestdemo");
		Cursor c = resolver.query(uri, null, null, null, null);
		c.moveToFirst();
		while(!c.isAfterLast()){
			for(int i=0,j=c.getColumnCount();i<j;i++){
				Log.v("Android2",""+c.getString(i));
			}
			c.moveToNext();
		}
	}
}

