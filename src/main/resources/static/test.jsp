<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
<h3>注册页面</h3>
<form action="/indexUser" method="get">
    <table>
        <tr>
            <td>username:</td>
            <td><input name="username"></td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input name="password"></td>
        </tr>
        <tr><td><input type="submit" value="提交"></td></tr>
    </table >
</form>
</body>
</html>