package com.dhu.dao;

import com.dhu.pojo.Borrow;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.Date;
import java.util.List;

public interface BorrowDao {
    //查询借书信息
    @Select("select * from borrow where readerId = #{readerId}")
    @Results({
            @Result(column = "bookId",property = "bookId"),
            @Result(column="bookId",property = "book",
                    one=@One(select = "com.dhu.dao.BookDao.showBookById",
                            fetchType = FetchType.EAGER))
    })
    List<Borrow> selectBorrowByReader(Integer readerId);

    @Select("select * from borrow where bookId = #{bookId}")
    List<Borrow> selectBorrowByBook(Integer readerId);

    @Select("select * from borrow where bookId = #{bookId} and readerId = #{readerId}")
    Borrow checkBorrow(Borrow borrow);


    @Insert("insert into borrow(bookId,readerId,borrowDate,returnDate) values(#{bookId},#{readerId},#{borrowDate},#{returnDate})")
    @Results({ @Result(column="borrowDate",property = "borrowDate", jdbcType = JdbcType.DATE,javaType = Date.class),
            @Result(column="returnDate",property = "borrowDate", jdbcType = JdbcType.DATE,javaType = Date.class)}

    )
    int addBorrow(Borrow borrow);

    //换书
    @Update("update borrow set returnDate=#{returnDate} where bookId=#{bookId} and readerId =#{readerId}")
    int returnBook(Borrow borrow);

    //续借书
    @Update("update borrow set borrowDate=#{borrowDate},returnDate=#{returnDate} where bookId=#{bookId} and readerId =#{readerId}")
    @Results({ @Result(column="borrowDate",property = "borrowDate", jdbcType = JdbcType.DATE,javaType = Date.class),
            @Result(column="returnDate",property = "borrowDate", jdbcType = JdbcType.DATE,javaType = Date.class)}
    )
    int renewBook(Borrow borrow);

    //归还书
    @Delete("delete from borrow where bookId = #{bookId} and readerId = #{readerId}")
    int deleteBorrow(Borrow borrow);


}
