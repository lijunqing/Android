package com.download.service;

import android.content.Context;
import android.content.Intent;

import com.down.entities.FileInfo;
import com.down.entities.ThreadInfo;
import com.download.db.ThreadDao;
import com.download.db.ThreadDaoImpl;

import org.apache.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 下载任务类
 *
 * * Created by jun on 2015/8/19.
 */
public class DownLoadTask {

    private Context mcontext;
    private FileInfo mFileinfo;
    private ThreadDao threadDao;
    private int mfinished;
    public boolean isPuse = false;

    public DownLoadTask(Context mcontext, FileInfo mFileinfo) {
        this.mcontext = mcontext;
        this.mFileinfo = mFileinfo;
        threadDao = new ThreadDaoImpl(mcontext);
    }
    public void download(){
        List<ThreadInfo> thredInfos = threadDao.getThreads(mFileinfo.getUrl());
        ThreadInfo threadInfo = null;
        if (thredInfos.size() == 0){
            threadInfo = new ThreadInfo(0,mFileinfo.getUrl(),0,mFileinfo.getLength(),0);
        }else {
            threadInfo = thredInfos.get(0);
        }
        new DownLoadThread(threadInfo).start();
    }
    class DownLoadThread extends Thread{
        private ThreadInfo mthreadinfo;
        public DownLoadThread(ThreadInfo threadInfo){
            this.mthreadinfo = threadInfo;
        }

        @Override
        public void run() {
            if (!threadDao.isExists(mthreadinfo.getUrl(),mthreadinfo.getId())){
                threadDao.insertThread(mthreadinfo);
            }
            HttpURLConnection connection = null;
            RandomAccessFile raf = null;
            InputStream inputStream = null;
            try {
                URL url = new URL(mthreadinfo.getUrl());
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                int start = mthreadinfo.getStart()+mthreadinfo.getFished();
                connection.setRequestProperty("Range","bytes="+start+"-"+mthreadinfo.getStop());
                File file = new File(DownLoadService.DOWNLOADPATH,mFileinfo.getFileName());
                raf = new RandomAccessFile(file,"rwd");
                raf.seek(start);
                Intent intent = new Intent(DownLoadService.ACTION_UPDATE);
                mfinished += mthreadinfo.getFished();
                if (connection.getResponseCode() == HttpStatus.SC_PARTIAL_CONTENT){
                    inputStream = connection.getInputStream();
                    byte[] buffer = new byte[1024*4];
                    int len = -1;
                    long time = System.currentTimeMillis();
                    while ((len = inputStream.read(buffer)) !=-1){
                        raf.write(buffer,0,len);
                        mfinished += len;
                        if (System.currentTimeMillis() - time > 500) {
                            time = System.currentTimeMillis();
                            intent.putExtra("finished", mfinished * 100 / mthreadinfo.getStop());
                            mcontext.sendBroadcast(intent);
                        }
                        if (isPuse){
                            threadDao.updataThread(mthreadinfo.getUrl(),mthreadinfo.getId(),mfinished);
                            return;
                        }
                    }
                    threadDao.deleteThread(mthreadinfo.getUrl(),mthreadinfo.getId());
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                connection.disconnect();
                try {
                    raf.close();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
