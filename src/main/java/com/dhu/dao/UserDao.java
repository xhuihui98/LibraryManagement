package com.dhu.dao;


import com.dhu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    //根据登录名和密码查询用户
    @Select("select * from user where username = #{userName} and password = #{password}")
    User selectByUsernameAndPassword(
            @Param("userName") String userName,
            @Param("password") String password
    );

    //根据登录名和密码查询用户
    @Select("select * from user")
    List<User> selectAllUser();

    //根据id查询用户
    @Select("select * from user where userId = #{id}")
    User selectUserById(Integer id);

    //根据id查询用户
    @Select("select * from user where authority = #{authority}")
    List<User> selectUserByAuthority(Integer authority);

    //根据id删除用户
    @Delete(" delete from user where userId = #{id} ")
    void deletUserById(@Param("id") Integer id);

    //根据用户名查询id
    @Select("select userId from user where username = #{username}")
    Integer selectIdByUsername(String username);


    //根据用户名查询读者
    @Select("select * from user where username = #{username}")
    User selectUserByUsername(String username);

    //修改密码
    @Update("update user set password = #{password} where username = #{userName}")
    void modifyReader(User user);

    //新建用户
    @Insert("insert into user(username,password) values(#{userName},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "userId")
    int createReader(User user);

    //新建管理员
    @Insert("insert into user(username,password,authority) values(#{userName},#{password},#{authority})")
    @Options(useGeneratedKeys = true,keyProperty = "userId")
    int createAdmin(User admin);

    //更新读者个人信息
    @Update("update user set authority = 1  where userId = #{userId}")
    int addAdmin(Integer userId);

}
