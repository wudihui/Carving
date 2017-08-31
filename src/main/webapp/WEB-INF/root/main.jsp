<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="fh5co-narrow-content">
    <form action="delete" method="GET">
        <input type="number" name="id">
        <input class="btn btn-primary btn-outline" type="submit" value="删除">
    </form>
    <form action="add_doc" method="POST">
        <input class="btn btn-primary btn-outline" type="submit" value="添加">
    </form>
    <form action="quit" method="POST">
        <input class="btn btn-primary btn-outline" type="submit" value="注销">
    </form>
</div>
