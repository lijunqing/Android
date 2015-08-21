package com.down.entities;

/**
 * 线程信息
 * Created by jun on 2015/8/18.
 */
public class ThreadInfo {

    private int id;
    private String  url;
    private int start;
    private int stop;
    private int fished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public int getFished() {
        return fished;
    }

    public void setFished(int fished) {
        this.fished = fished;
    }

    public ThreadInfo() {
        super();
    }

    public ThreadInfo(int id, String url, int start, int stop, int fished) {
        this.id = id;
        this.url = url;
        this.start = start;
        this.stop = stop;
        this.fished = fished;
    }

    @Override
    public String toString() {
        return "ThreadInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", start=" + start +
                ", stop=" + stop +
                ", fished=" + fished +
                '}';
    }
}
