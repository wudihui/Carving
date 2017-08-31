<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/16
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<div class="fh5co-narrow-content">
    <form name="Form" action="/upload" method="post"  enctype="multipart/form-data">
        <h1>${info}</h1>
        <input type="file" name="file">
        <input class="btn btn-primary btn-outline" type="submit" value="提交"/>
    </form>
</div>
