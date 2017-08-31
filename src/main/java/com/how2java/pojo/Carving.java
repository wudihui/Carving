package com.how2java.pojo;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Carving {
    private Integer id;
    private String name;
    private String detailed;
    private String head_img;
    private int start;

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {

        return start;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetailed() {
        return detailed;
    }

    public String getHead_img() {
        return head_img;
    }

    @Override
    public String toString() {
        return "Carving{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detailed='" + detailed + '\'' +
                ", head_img='" + head_img + '\'' +
                ", start='" + start + '\'' +
                '}';
    }

}
