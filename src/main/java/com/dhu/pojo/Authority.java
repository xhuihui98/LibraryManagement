package com.dhu.pojo;

public class Authority {
    Integer level;          //信誉等级
    Integer maxBorrowed;    //最大借书数
    Integer borrowContinue;    //续借次数
    Integer borrowTime;    //借书时长

    public Authority() {
    }

    public Authority(Integer level, Integer maxBorrowed, Integer borrowContinue, Integer borrowTime) {
        this.level = level;
        this.maxBorrowed = maxBorrowed;
        this.borrowContinue = borrowContinue;
        this.borrowTime = borrowTime;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "level=" + level +
                ", maxBorrowed=" + maxBorrowed +
                ", borrowContinue=" + borrowContinue +
                ", borrowTime=" + borrowTime +
                '}';
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMaxBorrowed() {
        return maxBorrowed;
    }

    public void setMaxBorrowed(Integer maxBorrowed) {
        this.maxBorrowed = maxBorrowed;
    }

    public Integer getBorrowContinue() {
        return borrowContinue;
    }

    public void setBorrowContinue(Integer borrowContinue) {
        this.borrowContinue = borrowContinue;
    }

    public Integer getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Integer borrowTime) {
        this.borrowTime = borrowTime;
    }
}
