package com.down.entities;

import java.io.Serializable;

/**
 * 文件信息
 * */
public class FileInfo implements Serializable{
    private int id;
    private String url;
    private String fileName;
    private int length;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFished() {
        return fished;
    }

    public void setFished(int fished) {
        this.fished = fished;
    }

    public FileInfo(int id, String url, String fileName, int length, int fished) {
        this.id = id;
        this.url = url;
        this.fileName = fileName;
        this.length = length;
        this.fished = fished;
    }

    public FileInfo() {
        super();
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", fileName='" + fileName + '\'' +
                ", length=" + length +
                ", fished=" + fished +
                '}';
    }
}
