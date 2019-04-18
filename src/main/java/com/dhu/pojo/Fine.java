package com.dhu.pojo;

public class Fine {
    Integer bookId;     //图书编号
    Integer readerId;   //读者编号
    Double fine;        //罚金

    public Fine(Integer bookId, Integer readerId, Double fine) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.fine = fine;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }
}
