package com.ruanko.springboothelloworld.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.ruanko.springboothelloworld.entity.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM admin WHERE username = #{username} AND password = #{password}")
    User getInfo(@Param("username") String username, @Param("password") String password);

    @Insert("insert into admin(username,password)values(#{username},#{password})")
    void saveInfo(@Param("username") String username, @Param("password") String password);

}
