<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--数据模块--%>
<div class="row">
    <div class="col-md-4 animate-box" data-animate-effect="fadeInLeft">
        <h1 class="fh5co-heading-colored">${info}</h1>
    </div>
</div>
<div class="fh5co-gallery" id="result">
    <c:forEach items="${cs}" var="c" varStatus="st">
        <a class="gallery-item" href="single?id=${c.id}">
            <img src="${c.head_img}" alt="图片显示异常">
            <span class="overlay">
						<h2>${c.name}</h2>
						<span>${c.id}</span>
					</span>
        </a>
    </c:forEach>
</div>
