package com.dhu.dao;

import com.dhu.pojo.Fine;
import org.apache.ibatis.annotations.Insert;

public interface FineDao {
    @Insert("insert into fine(bookId,readerId,fine) values(#{bookId},#{readerId},#{fine}")
    int addFine(Fine fine);
}
