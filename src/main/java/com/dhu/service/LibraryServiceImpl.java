package com.dhu.service;

import com.dhu.dao.*;
import com.dhu.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 图书管理系统服务层接口实现类
* */
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("LibraryService")
public class LibraryServiceImpl implements LibraryService {
    /**
     * 自动注入持久层Dao对象
     */
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReaderDao readerDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private FineDao fineDao;


    @Override
    public User login(String loginname, String password) {
        return userDao.selectByUsernameAndPassword(loginname,password);
    }

    @Override
    public int regist(User user) {
        if(user == null)
            return 0;
        else if(user.getUserName().equals("") || user.getPassword().equals(null)){
            return 0;
        }
        else{
            if (userDao.selectUserByUsername(user.getUserName()) != null){
                return 0;
            }
            else{
                return userDao.createReader(user);
            }

        }
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

    @Override
    public List<User> showUser() {
        return userDao.selectAllUser();
    }

    @Override
    public List<Book> showBook() {
        return bookDao.showBook();
    }

    @Override
    public int addBook(Book book) {
        if(bookDao.showBookByISBN(book.getISBN()) != null)
            return 0;
        else return bookDao.insertBook(book);
    }

    @Override
    public List<Book> showBookHots() {
        return bookDao.showBookOrderByBorrowCount();
    }

    @Override
    public List<Book> selectBookByCondition(Book book) {
        Map<String,Object> params = new HashMap<>();
        params.put("book",book);
        return bookDao.selectByCondition(params);
    }

    @Override
    public int deleteBookById(Book book) {
        return bookDao.deleteBook(book.getBookId());
    }

    @Override
    public void modifyBook(Book book) {
         bookDao.updateBook(book);
    }

    @Override
    public void addReaderInfo(Integer id) {
        readerDao.createReaderInformation(id);
    }

    @Override
    public int modifyReader(Reader reader) {
       return readerDao.modifyReaderInformation(reader);
    }

    @Override
    public Reader selectReaderById(Integer id) {
        return readerDao.selectReaderById(id);
    }

    @Override
    public List<Borrow> selectBorrowByReader(Integer readerId) {
        return borrowDao.selectBorrowByReader(readerId);
    }

    @Override
    public List<User> selectUserByAuthority(int authority) {
        return userDao.selectUserByAuthority(authority);
    }

    @Override
    public void deleteUserById(Integer id) {

        userDao.deletUserById(id);


    }

    @Override
    public User findUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    @Override
    public int addadmin(User user) {
        return userDao.addAdmin(user.getUserId());
    }

    @Override
    public int borrowBook(Borrow borrow) {
        return borrowDao.addBorrow(borrow);
    }

    @Override
    public Borrow checkBorrow(Borrow borrow) {
        return borrowDao.checkBorrow(borrow);
    }

    @Override
    public void updateHasBorrowed(Reader reader) {
        readerDao.modifyReaderHasBorrowed(reader);
    }

    @Override
    public List<Borrow> showBorrow(Integer id) {
        return borrowDao.selectBorrowByReader(id);
    }

    @Override
    public int returnBook(Borrow borrow) {
        return borrowDao.deleteBorrow(borrow);
    }

    @Override
    public int renewBook(Borrow borrow) {
        return borrowDao.renewBook(borrow);
    }

    @Override
    public int addFine(Fine fine) {
        return fineDao.addFine(fine);
    }

    @Override
    public int updateBorrowCount(Book book) {
        return bookDao.updateBorrowCount(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.showBookById(id);
    }
}
