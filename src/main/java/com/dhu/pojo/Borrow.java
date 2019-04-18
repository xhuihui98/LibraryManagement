package com.dhu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Borrow {
    Integer bookId;     //图书编号
    Integer readerId;   //读者编号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date borrowDate;    //借书日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date returnDate;    //归还日期
    Integer renewCount; //续借次数
    Book book;

    public Borrow(Integer bookId, Integer readerId, Date borrowDate, Date returnDate, Integer renewCount, Book book) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.renewCount = renewCount;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "bookId=" + bookId +
                ", readerId=" + readerId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", renewCount=" + renewCount +
                '}';
    }

    public Borrow() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Integer getRenewCount() {
        return renewCount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
