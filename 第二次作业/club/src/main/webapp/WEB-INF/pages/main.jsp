<%@ taglib prefix="position" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
  Created by IntelliJ IDEA.
  User: ycb
  Date: 2019/4/18
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ne GymClub</title>
</head>


<body>

<div class="main" id="main_interface" style="background-color:rgba(255,255,224,9);position:absolute;left: 0px;top: 50px;width: 2000px;height: 80px">
    <label style="font-size: 25px;position:relative;left: 800px;top:20px">课程库</label>

    <form action="/getlinks" method="post">
        <input type="submit" value="外部链接" style="font-size: 25px;position:relative;left: 1000px;top:10px" >
    </form>
    <%--<input type="button"  value="外部链接" onclick="tolinks()" style="font-size: 25px;position:relative;left: 900px;top:20px  ">--%>
    <%--<script type="text/javascript">--%>
        <%--function tolinks(){--%>
            <%--window.location.href="http://localhost:8080/lists/hateos?name=ycb";--%>
        <%--}--%>
    <%--</script>--%>

    <%--<form action="/getlinkss" method="post" >--%>
        <%--<input type="submit" value="外部链接" style="font-size: 25px;position:relative;left: 1000px;top:20px">--%>
    <%--</form>--%>
    <form action="/pagecoach/list" method="post" >
        <input type="submit" value="教练名单" style="font-size: 25px;position:absolute;left: 1200px;top:10px">
    </form>

    <form action="/getcourse/${username }" method="post">
    <input type="submit" value="高级课程" style="font-size: 25px;position:absolute;left: 1400px;top:20px" >
        <label  style="font-size: 25px;border:25px;border:0;outline:none;background-color:rgba(255,255,224,0.9);position:absolute;left: 1600px;top:20px">${username }</label>
    </form>
</div>

<div style="background-color:rgba(255,255,240,0.5);position:absolute;left: 0px;top: 150px;width: 2000px;height: 800px">
    <img src="<%=basePath%>images/main1.jpg"  style="position: relative;left:100px"/>
    <label style="font-size: 25px;position:relative;left: 150px;bottom:250px">自然的吐息</label>
    <label style="font-size: 25px;position:relative;left: 300px;bottom:50px">阳刚的魅力</label>
    <img src="<%=basePath%>images/main2.jpg" style="position: relative;left:400px"/>
</div>

<div style="background-color:rgba(255,255,240,0.5);position:relative;left:100px;top:600px">
    <img src="<%=basePath%>images/down.jpg"/>
</div>

<div style="position:relative;left:600px">
    <table style="background-color:rgba(255,255,240,0.5);border:0;outline:none;position:absolute;left: 100px;top: 300px;width: 1200px;height: 300px">
        <tr style="border-collapse:separate;border-spacing: 10px">
            <td style="text-align: center;position:relative;top:50px">北京市场馆</td>
            <td style="text-align: center;position:relative;top:50px">那有条街</td>
        </tr>

        <tr style="border-collapse:separate;border-spacing: 10px">
            <td style="text-align: center;position:relative;top:25px">郑州市场馆</td>
            <td style="border-spacing:20px;text-align: center;position:relative;top:25px">那有个馆</td>
        </tr>
        <tr style="border-collapse:separate;border-spacing: 10px">
            <td style="text-align: center;position:relative;top:0px">上海市场馆</td>
            <td style="text-align: center;position:relative;top:0px">那有个场地</td>
        </tr>
    </table>
</div>
</body>
</html>
