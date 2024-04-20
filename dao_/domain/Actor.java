package com.mysql.dao_.domain;

import java.time.LocalDateTime;

public class Actor {
    int id;
    String sex;
    String phone;
    String name;
    LocalDateTime borndate;

    public Actor(){}

    public Actor(int id, String sex, String phone, String name, LocalDateTime borndate) {
        this.id = id;
        this.sex = sex;
        this.phone = phone;
        this.name = name;
        this.borndate = borndate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBorndate() {
        return borndate;
    }

    public void setBorndate(LocalDateTime borndate) {
        this.borndate = borndate;
    }

    @Override
    public String toString() {
        return "actor{" +
                "id=" + id +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", borndate=" + borndate +
                '}';
    }
}
