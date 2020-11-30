package com.example.demo1.mapper;

import com.example.demo1.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public void insertUser(User user);
    public User selectByUser(User user);
    public String selectByName(User user);
    public void deleteByUser(User user);
    public void updateUser(User user);
}
