package com.xk.boradcastreceiver;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BoradcastReceiverActivity extends Activity {
	 private final String ACTION_NAME = "���͹㲥";  
	    private Button mBtnMsgEvent = null;  
	      
	    protected void onCreate(Bundle savedInstanceState){  
	        super.onCreate(savedInstanceState);  
	        //ע��㲥  
	        registerBoradcastReceiver();  
	          
	        LinearLayout mLinearLayout = new LinearLayout(this);  
	        mBtnMsgEvent = new Button(this);  
	        mBtnMsgEvent.setText("���͹㲥");  
	        mLinearLayout.addView(mBtnMsgEvent);  
	        setContentView(mLinearLayout);  
	          
	        mBtnMsgEvent.setOnClickListener(new OnClickListener() {  
	            @Override  
	            public void onClick(View v) {  
	                Intent mIntent = new Intent(ACTION_NAME);  
	                mIntent.putExtra("yaner", "���͹㲥���൱�������ﴫ������");  
	                  
	                //���͹㲥  
	                sendBroadcast(mIntent);  
	            }  
	        });  
	    }  
	      
	    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){  
	        @Override  
	        public void onReceive(Context context, Intent intent) {  
	            String action = intent.getAction();  
	            if(action.equals(ACTION_NAME)){  
	                Toast.makeText(getApplicationContext(), "����action�������Ӧ�Ĺ㲥", 200).show();  
	            }  
	        }  
	          
	    };  
	      
	    public void registerBoradcastReceiver(){  
	        IntentFilter myIntentFilter = new IntentFilter();  
	        myIntentFilter.addAction(ACTION_NAME);  
	        //ע��㲥        
	        registerReceiver(mBroadcastReceiver, myIntentFilter);  
	    }  
	}  
