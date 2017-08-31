<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
<aside id="fh5co-aside" role="complementary" class="border">

    <h1 id="fh5co-logo"><a href="main"><img src="images/logo-colored.png" alt=""></a></h1>
    <nav id="fh5co-main-menu" role="navigation">
        <ul>
            <form action="search" method="GET">
                <a>搜索</a><input type="text" class="btn btn-primary btn-outline" name="name">
            </form>
            <li><a href="/">主页</a></li>
            <li><a href="portfolio">全部</a></li>
            <li class="fh5co-active"><a href="about">详情</a></li>
        </ul>
    </nav>

    <div class="fh5co-footer">
        <ul>
            <li><a href="#"><i class="icon-facebook"></i></a></li>
            <li><a href="#"><i class="icon-twitter"></i></a></li>
            <li><a href="#"><i class="icon-instagram"></i></a></li>
            <li><a href="#"><i class="icon-linkedin"></i></a></li>
        </ul>
    </div>
</aside>
