package com.example.demo1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
public class User{
   String name;
   String password;

    public User(String name, String password) {
        this.name=name;
        this.password=password;
    }

//    public User() {
//    }
//
//
//    public User(Integer id, String name, String password) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
