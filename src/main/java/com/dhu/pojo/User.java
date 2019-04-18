package com.dhu.pojo;

public class User {
    Integer userId;   //读者编号
    String userName;    //用户名
    String password;    //密码
    Integer authority;  //权限

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", authority=" + authority +
                '}';
    }

    public User(Integer userId, String userName, String password, Integer authority) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }

    public User(String userName, String password, Integer authority) {
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}