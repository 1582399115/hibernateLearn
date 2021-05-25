package com.xinlei.entity;

import java.math.BigInteger;

public class UserDay02 {
    private Integer id;
    private String userName;
    private String UserPassword;
    private int age;
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDay02{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
