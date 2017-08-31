<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<div class="fh5co-narrow-content">
    <h1 class="fh5co-heading-colored" >如果你不是管理员请无视该页!</h1>
    <form action="login" method="POST">
        username:
        <input class="btn btn-primary btn-outline" type="text" name="username"/>
        <br/>
        password:
        <input class="btn btn-primary btn-outline" type="password" name="password"/>
        <br/>
        <input class="btn btn-primary btn-outline" type="submit" value="登录"/>
    </form>
</div>