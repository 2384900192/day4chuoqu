package com.example.day4_lianxice.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class MyBean {
    @Id    //表示是表中的主键
    private Long id; //一定是Long型
    private String date;
    private String name;
    private String imgervirew;
    @Generated(hash = 598229033)
    public MyBean(Long id, String date, String name, String imgervirew) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.imgervirew = imgervirew;
    }
    @Generated(hash = 1281580447)
    public MyBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImgervirew() {
        return this.imgervirew;
    }
    public void setImgervirew(String imgervirew) {
        this.imgervirew = imgervirew;
    }
}
