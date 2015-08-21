package com.ljq.downloaddemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.down.entities.FileInfo;
import com.download.service.DownLoadService;

public class MainActivity extends AppCompatActivity {
    private Button button_start,button_stop;
    private TextView tv;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        tv = (TextView) super.findViewById(R.id.ApkName);
        button_start = (Button) super.findViewById(R.id.start);
        button_stop = (Button) super.findViewById(R.id.stop);
        progressBar = (ProgressBar) super.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        final FileInfo fileInfo = new FileInfo(0,"http://www.imooc.com/mobile/imooc.apk","imooc.apk",0,0);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DownLoadService.class);
                intent.setAction(DownLoadService.ACTION_START);
                intent.putExtra("fileInfo",fileInfo);
                startService(intent);
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DownLoadService.class);
                intent.setAction(DownLoadService.ACTION_STOP);
                intent.putExtra("fileInfo", fileInfo);
                startService(intent);
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownLoadService.ACTION_UPDATE);
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (DownLoadService.ACTION_UPDATE.equals(intent.getAction())){
                int finished = intent.getIntExtra("finished",0);
                progressBar.setProgress(finished);
            }
        }
    };
}
