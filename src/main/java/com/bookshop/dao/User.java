package com.bookshop.dao;

import java.io.Serializable;

/**
 * 用户实体类-user表
 */
public class User implements Serializable {

    private Integer id;
    private String studentid;
    private String name;
    private String password;
    private char sex;
    private String tel;
    private String address;
    private String major;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", studentid='" + studentid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
