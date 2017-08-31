<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<div class="fh5co-narrow-content">
    <form action="/addsmall" method="GET">
        名字:
        <br/>
        <input type="text" name="name">
        <br/>
        添加点介绍,让它更容易被搜索到...
        <br/>
        <textarea name="detailed" cols=40 rows=4 ></textarea>
        <br/>
        <input class="btn btn-primary btn-outline" type="reset" value="重写">
        <input class="btn btn-primary btn-outline" type="submit" value="添加">
    </form>
</div>