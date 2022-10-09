package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Mapper
public interface UserMapper {

    @Delete("delete from sys_user where id =#{id}")
    Integer deleteById(Integer id);

    @Select("select * from sys_user")
    List<User> findALl();


    @Insert("Insert into sys_user(username,password,nickname,email,phone,address) Values (#{username},#{password},"+
            " #{nickname},#{email},#{phone},#{address});")
    int insert(User user);


    int update(User user);

    @Select("select * from sys_user limit #{pageNum},#{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);
}
