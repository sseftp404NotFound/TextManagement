package com.slsnotfound.textmanagement.Model;

import lombok.Data;

@Data
public class User {
    private int uid;
    private String username;
    private String sex;
    private String birthday;
    private String password;
    private String phonenum;
    private String address;
    private String referrer;
    private String industry;
    private String committee;
    private int role;
    private int status;
    private String company;
    private String profession;
    private String email;
    private String wechat;

    public User(){

    }

    public User(String username,String sex,String birthday,String password,String phonenum,String address,String referrer,String industry,String committee){
        this.username=username;
        this.sex=sex;
        this.birthday=birthday;
        this.password=password;
        this.phonenum=phonenum;
        this.address=address;
        this.referrer=referrer;
        this.industry=industry;
        this.committee=committee;
        this.role=0;
        this.status=-1;
    }
}
