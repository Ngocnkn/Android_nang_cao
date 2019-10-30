package com.example.lab5;

public class New {
    private long id;
    private String title;
    private String desc;
    private String url;
    private String img;

    public New(long id, String title, String desc, String url, String img, String date) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.img = img;
        this.date = date;
    }


    private String date;
    private int isFavorite = 0;
    public int isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}