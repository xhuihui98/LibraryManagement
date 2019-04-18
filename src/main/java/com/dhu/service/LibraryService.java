package com.dhu.service;

import com.dhu.pojo.*;

import java.util.List;

public interface LibraryService {
    /*
    * 用户登录
    * @param loginname
    * @param password
    * return User对象
    * */
    User login(String loginname, String password);
    /*
    * 用户注册
    * @param 用户名
    * @param 密码
    * */
    int regist(User user);
    /*
    * 根据用户名搜索用户
    * */
    User findUserByUsername(String username);

    /*
    * 插入图书
    * */
    int addBook(Book book);
    /*
    * 展示所有用户
    * */
    List<User> showUser();
    /*
    * 展示图书列表
    * */
    List<Book> showBook();
    /*
     * 展示图书列表
     * */
    List<Book> showBookHots();
    /*
    * 动态查询图书
    * */
    List<Book> selectBookByCondition(Book book);

    /*
    * 删除图书*/
    int deleteBookById(Book book);
    /*
    * 修改图书*/
    void modifyBook(Book book);
    /*
    * 新建读者信息*/
    void addReaderInfo(Integer id);
    /*
    * 修改读者信息*/
    int modifyReader(Reader reader);
    /*
    * 根据Id 返回读者信息*/
    Reader selectReaderById(Integer id);
    /*
    * 根据读者ID返回借书列表*/
    List<Borrow> selectBorrowByReader(Integer ReaderId);
    /*
     * 根据权限搜索用户
     * */
    List<User> selectUserByAuthority(int authority);
    /*
    根据id删除用户
    * */
    void deleteUserById(Integer id);
    /*
    根据id查找用户
    **/
    User findUserById(Integer id);
    /*
    * 修改用户权限
    * */
    int addadmin(User user);
    /*
    * 新建借书*/
    int borrowBook(Borrow borrow);
    /*
    * 查找借书记录是否存在*/
    Borrow checkBorrow(Borrow borrow);
    /*
    更新用户借的书
    * */
    void updateHasBorrowed(Reader reader);
    /*
    根据读者id查询借书列表
    * */
    List<Borrow> showBorrow(Integer id);
    /*
    * 归还图书
    * */
    int returnBook(Borrow borrow);
    /*
    * 续借图书
    * */
    int renewBook(Borrow borrow);
    /*
    * 新建处罚表
    * */
    int addFine(Fine fine);

    /*
    更新图书借阅数量
    */
    int updateBorrowCount(Book book);

    /*根据id查找图书*/
    Book findById(Integer id);
}
