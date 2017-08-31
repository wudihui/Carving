<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="fh5co-narrow-content animate-box fh5co-border-bottom" data-animate-effect="fadeInLeft">
    <h2 class="fh5co-heading"><span>名字:${name} id:${id}</span></h2>
    <p>
    <p>${detailed}</p></p>

    <div class="row">
        <c:forEach items="${cs}" var="c" varStatus="st">
            <div class="col-md-12">
                <figure><img src="${c.url}" alt="图片显示异常 " class="img-responsive">
                </figure>
            </div>
        </c:forEach>

        <div class="col-md-12">
            <p class="text-center">${insButton}</p>
            <p class="text-center">${delButton}</p>
            <p class="text-center">${retButton}</p>
        </div>

    </div>
</div>