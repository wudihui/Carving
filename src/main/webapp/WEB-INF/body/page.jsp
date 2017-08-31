<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<%--翻页模块--%>
<div class="fh5co-narrow-content">
    <div class="row">
        <div class="col-md-12 animate-box" data-animate-effect="fadeInLeft">
            <p>
                <a class="btn btn-primary btn-outline" onclick=moreLast()>上一页</a>
                <a class="btn btn-primary btn-outline" onclick=moreNext()>下一页</a>
                <a class="btn btn-primary btn-outline" id="to_top">返回顶部</a>
            </p>
        </div>
    </div>
</div>