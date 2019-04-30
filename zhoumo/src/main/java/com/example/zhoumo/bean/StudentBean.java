package com.example.zhoumo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class StudentBean {
    @Id(autoincrement = true)
    private Long id;
    private String author;
    private String desc;
    private String cover;
    @Generated(hash = 1423139974)
    public StudentBean(Long id, String author, String desc, String cover) {
        this.id = id;
        this.author = author;
        this.desc = desc;
        this.cover = cover;
    }
    @Generated(hash = 2097171990)
    public StudentBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getCover() {
        return this.cover;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", desc='" + desc + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    public void setCover(String cover) {

        this.cover = cover;
    }
}
