package com.dhu.pojo;

public class Reader {
    private Integer readerId;   //读者编号
    private String  name;       //读者姓名
    private Integer age;        //年龄
    private String phone;       //电话号码
    private String sex;        //性别
    private Integer level;      //信誉等级
    private Integer hasBorrowed;     //借书数量
    private  Authority authority;    //用户等级对应权限

    public Reader(Integer readerId, String name, Integer age, String phone, String sex, Integer level, Integer hasBorrowed, Authority authority) {
        this.readerId = readerId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.sex = sex;
        this.level = level;
        this.hasBorrowed = hasBorrowed;
        this.authority = authority;
    }

    public Reader() {
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", level=" + level +
                ", hasBorrowed=" + hasBorrowed +
                '}';
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getHasBorrowed() {
        return hasBorrowed;
    }

    public void setHasBorrowed(Integer hasBorrowed) {
        this.hasBorrowed = hasBorrowed;
    }
}
