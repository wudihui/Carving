<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<!-- jQuery 模块-->
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- Stellar -->
<script src="js/jquery.stellar.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Counters -->
<script src="js/jquery.countTo.js"></script>
<!-- MAIN JS -->
<script src="js/main.js"></script>
<script>
    function moreNext() {
        $.get('portfolio/page_next', back);
    }
    function moreLast() {
        $.get('portfolio/page_last', back);
    }
    function back(data) {
        var resultObj = $("#result");
        resultObj.html(data);
    }
</script>
<!--MORE-->
<%--<script src="js/more.js"></script>--%>
<script>
    window.onload = function () {
        var oTop = document.getElementById("to_top");
        var screenw = document.documentElement.clientWidth || document.body.clientWidth;
        var screenh = document.documentElement.clientHeight || document.body.clientHeight;
        oTop.style.left = screenw - oTop.offsetWidth + "px";
        oTop.style.top = screenh - oTop.offsetHeight + "px";
        window.onscroll = function () {
            var scrolltop = document.documentElement.scrollTop || document.body.scrollTop;
            oTop.style.top = screenh - oTop.offsetHeight + scrolltop + "px";
        }
        oTop.onclick = function () {
            document.documentElement.scrollTop = document.body.scrollTop = 0;
        }
    }
</script>