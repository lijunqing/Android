package com.download.db;

import com.down.entities.ThreadInfo;

import java.util.List;

/**
 * 数据访问接口
 * Created by jun on 2015/8/19.
 */
public interface ThreadDao {
    /**
     * 插入线程信息
     * @param threadInfo
     */
    public void insertThread(ThreadInfo threadInfo);
    /**
     * 删除线程信息
     * @param url
     * @param id
     */
    public void deleteThread(String url,int thread_id);

    /**
     * 更新线程下载进度
     * @param url
     * @param Thread_id
     * @param finished
     */
    public void updataThread(String url,int thread_id,int finished);

    /**
     * 查询文件的线程信息
     * @param url
     * @return
     */
    public List<ThreadInfo> getThreads(String url);

    /**
     * 查询信息是否存在
     * @param url
     * @param id
     * @return
     */
    public boolean isExists(String url,int thread_id);
}
