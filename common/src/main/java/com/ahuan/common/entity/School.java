package com.ahuan.common.entity;

/**
 * @program: springcloud
 * @description: TODO this is the description of the School class
 * @author: ahuan
 * @version: 2021-01-09 18:17
 **/
public class School {

    private String name;

    private String tel;

    private String addr;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}