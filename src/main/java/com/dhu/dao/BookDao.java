package com.dhu.dao;

import com.dhu.dao.provider.BookDynaSqlProvider;
import com.dhu.pojo.Book;
import com.dhu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BookDao {
    @Insert(" insert into book (ISBN,typename,bookname,author,publisher,price,stockNum,total) values (#{ISBN},#{typeName},#{bookName},#{author},#{publisher},#{price},#{stockNum},#{total});")
    @Options(useGeneratedKeys = true,keyProperty = "bookId")
    int insertBook(Book book);

    @Select("select * from book")
    List<Book> showBook();

    @Update("update book set ISBN=#{ISBN},bookname=#{bookName},author = #{author},publisher =#{publisher},price=#{price},stockNum=#{stockNum},total=#{total} where bookId = #{bookId}" )
    void updateBook(Book book);

    @Delete("delete from book where bookId = #{id}")
    int deleteBook(Integer id);

    @Select("select * from book order by borrowCount DESC;")
    List<Book> showBookOrderByBorrowCount();

    @Select("select * from book where ISBN = #{ISBN};")
    Book showBookByISBN(String ISBN);

    @Select("select * from book where bookId = #{bookId};")
    Book showBookById(Integer bookId);

    @SelectProvider(type= BookDynaSqlProvider.class,method = "selectWithParam")
    List<Book> selectByCondition(Map<String,Object> params);

    @Update("update book set borrowCount = #{borrowCount} where bookId = #{bookId}")
    int updateBorrowCount(Book book);
}
