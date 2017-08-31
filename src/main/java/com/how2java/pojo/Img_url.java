package com.how2java.pojo;

/**
 * Created by Administrator on 2017/8/15.
 */
public class Img_url {
    private int id;
    private String img_id;
    private String url;

    @Override
    public String toString() {
        return "Img_url{" +
                "id=" + id +
                ", img_id='" + img_id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {

        return id;
    }

    public String getImg_id() {
        return img_id;
    }

    public String getUrl() {
        return url;
    }
}
