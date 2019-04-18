package com.dhu.dao;

import com.dhu.pojo.Authority;
import org.apache.ibatis.annotations.Select;

public interface AhthorityDao {
    @Select("select * from  authority where level = #{level}" )
    Authority selectAuthorityByLevel(Integer level);
}
