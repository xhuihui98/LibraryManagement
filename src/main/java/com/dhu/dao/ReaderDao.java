package com.dhu.dao;

import com.dhu.pojo.Reader;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ReaderDao {

    //根据id 查询读者信息
    @Select("select * from reader where readerId = #{id}")
    @Results({
            @Result(column = "level",property = "level"),
            @Result(column="level",property = "authority",
            one=@One(select = "com.dhu.dao.AhthorityDao.selectAuthorityByLevel",
            fetchType = FetchType.EAGER))
    })
    Reader selectReaderById(Integer id);

    //根据id 查询读者信息
    @Select("select * from reader")
    List<Reader> showReaders();

    //根据id删除读者信息
    @Delete("delete from reader where readerId #{id}")
    int deleteReaderById(Integer id);

    //插入读者个人信息
    @Insert("insert into reader(readerId) values(#{readerId})")
    int createReaderInformation(Integer id);

    //更新读者个人信息
    @Update("update reader set name = #{name},age = #{age},sex = #{sex},phone = #{phone} where readerId = #{readerId}")
    int modifyReaderInformation(Reader reader);

    //更新用户信誉等级
    @Update("update reader set level = #{level}")
    void modifyReadeLevel(Integer level);

    //更新用户已经借的书
    @Update("update reader set hasBorrowed = #{hasBorrowed} where readerId = #{readerId}")
    void modifyReaderHasBorrowed(Reader reader);

    //获取用户信誉等级
    @Select("select level from reader where readerId = #{id}")
    int selectReaderLevelById(Integer id);

    //获取用户已经借的书
    @Select("select has_borrowed from reader where readerId = #{id}")
    int selectHasBorrowedById(Integer id);



    //创建读者信息

    /*
    @Results({
            @Result(id=true,column = "reader_id",property = "readerID"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "phone",property = "phone")
    })*/

}
