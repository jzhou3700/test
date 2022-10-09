package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public Integer save(@RequestBody User user){

        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    Integer deleteById(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }

    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum = (pageNum -1) * pageSize;
        Integer total = userMapper.findALl().size();
        Map<String,Object> res = new HashMap<>();
        List<User> data = userMapper.selectPage(pageNum, pageSize);
        res.put("data",data);
        res.put("total",total);
        return res;
    }

}
