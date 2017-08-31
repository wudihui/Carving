<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <title>Blend</title>
    <tiles:insertAttribute name="head"/>
    <%--head模块--%>
</head>
<body>
<div id="fh5co-page">
    <tiles:insertAttribute name="lift"/>
    <%--portfolio左边栏--%>
    <div id="fh5co-main">
        <%--数据模块--%>
        <tiles:insertAttribute name="content"/>
        <%--翻页模块--%>
        <tiles:insertAttribute name="page"/>
    </div>
</div>
<tiles:insertAttribute name="jquery"/>
<%--jQuery模块--%>
</body>
</html>
