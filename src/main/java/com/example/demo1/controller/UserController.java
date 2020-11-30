package com.example.demo1.controller;

import com.example.demo1.bean.User;
import com.example.demo1.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class UserController {
    @Autowired
    public UserMapper userMapper;

    @RequestMapping(value = "/indexUser", method = RequestMethod.GET)
    public void indexUser(@Param("username") String username, @Param("password") String password, HttpServletResponse response){
        User user = new User(username,password);
        String u1= userMapper.selectByName(user);
        response.setContentType("text/html;charset=utf-8");
        if(u1==null) {
            userMapper.insertUser(user);
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(u1!=null){
            try {
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('此用户名已存在，请重新输入！');");
                out.println("history.back();");
                out.println("</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @RequestMapping(value = "/loginUser")
    public void loginUser(@Param("username") String username,@Param("password") String password,HttpServletResponse response){
        User user1;
        User user = new User(username,password);
        user1=userMapper.selectByUser(user);
        response.setContentType("text/html;charset=utf-8");
        if(user1!=null){
//            mv.addObject("pass",user1);
            try {
                response.sendRedirect("main.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(user1==null){
//            mv.addObject("null",user1);
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
            out.println("<script>");
            out.println("alert('用户名或密码输入有误，请重新输入！');");
            out.println("history.back();");
            out.println("</script>");

        }
    }

    @RequestMapping(value = "/deleteUser")
    public void deleteUser(@Param("username") String username,@Param("password") String password,HttpServletResponse response){
        User user=new User(username,password);
        User user1 = userMapper.selectByUser(user);
        response.setContentType("text/html;charset=utf-8");
        if(user1!=null){
            userMapper.deleteByUser(user);
            try {
                response.sendRedirect("main.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(user1==null){
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
            out.println("<script>");
            out.println("alert('用户名或密码输入有误！请重新输入！');");
            out.println("history.back();");
            out.println("</script>");
        }
    }

    @RequestMapping(value = "/updateUser")
    public void updateUser(@Param("username") String username,@Param("lodPassword") String lodPassword,@Param("newPassword") String newPassword,HttpServletResponse response){
        User user=new User(username,lodPassword);
        User user2 =new User(username,newPassword);
        User user1 = userMapper.selectByUser(user);
        response.setContentType("text/html;charset=utf-8");
        if(user1!=null){
            userMapper.updateUser(user2);
            try {
                response.sendRedirect("main.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(user1==null){
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
            out.println("<script>");
            out.println("alert('用户名或密码输入有误！请重新输入！');");
            out.println("history.back();");
            out.println("</script>");
        }
    }
}
