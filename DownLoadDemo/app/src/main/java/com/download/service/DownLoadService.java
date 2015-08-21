package com.download.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.down.entities.FileInfo;

import org.apache.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by jun on 2015/8/18.
 */
public class DownLoadService extends Service{
    public static final int MSG_INIT = 0;
    public static final String ACTION_START="ACTION_START";
    public static final String ACTION_STOP="ACTION_STOP";
    public static final String ACTION_UPDATE="ACTION_UPDATE";
    public static final String DOWNLOADPATH =
            Environment.getExternalStorageDirectory().getAbsolutePath()+"/downloads/";
    private DownLoadTask downLoadTask = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //获得Activity传过来的参数
        Log.i("test",intent.getAction().toString());
        if(ACTION_START.equals(intent.getAction())){
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
//            Log.i("test","start:"+fileInfo.toString());
            //启动初始化线程
            new InitThread(fileInfo).start();
        }else if (ACTION_STOP.equals(intent.getAction())) {
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
//            Log.i("test", "stop:"+fileInfo.toString());
            if (downLoadTask != null){
                downLoadTask.isPuse = true;
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_INIT:
                    FileInfo fileInfo = (FileInfo) msg.obj;
//                    Log.i("test","init:"+fileInfo.toString());
                    downLoadTask = new DownLoadTask(DownLoadService.this,fileInfo);
                    downLoadTask.download();
                    break;
            }
        }
    };
    /**
     * 初始化的子线程
     */
    class InitThread extends Thread{
        private FileInfo mfileInfo = null;

        public InitThread(FileInfo fileInfo) {
            this.mfileInfo = fileInfo;
        }

        @Override
        public void run() {
            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            try {
                //连接网络的文件
                URL url = new URL(mfileInfo.getUrl());
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                int length = 1;
                if(conn.getResponseCode() == HttpStatus.SC_OK){
                    //获得文件长度
                    length = conn.getContentLength();
                }
                if(length <= 0){
                    return;
                }
                File dir = new File(DOWNLOADPATH);
                if (!dir.exists()){
                    dir.mkdir();
                }
//                Log.i("test",dir.toString());
                File file = new File(dir,mfileInfo.getFileName());
                if (!file.exists())
                    file.createNewFile();
                raf = new RandomAccessFile(file,"rwd");
//                Log.i("test",file.toString());
                raf.setLength(length);
                //在本地创建文件
                //设置文件长度
                mfileInfo.setLength(length);
                handler.sendMessage(handler.obtainMessage(MSG_INIT, mfileInfo));
            }catch (Exception e){
                e.printStackTrace();
            }finally {

                if(conn != null){
                    conn.disconnect();
                }
                if (raf != null){

                    try {
                        raf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
