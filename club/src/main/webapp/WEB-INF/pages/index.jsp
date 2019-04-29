<%--
  Created by IntelliJ IDEA.
  User: ycb
  Date: 2019/4/25
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="position" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎来到neGymClub</title>
    <link rel="stylesheet" type="text/css" href="css/index.css" />
</head>


<form action="/login" method="post">
<body style="background-color:rgba(255, 255, 255, 0.5)">


<div class="fg" style="background-color:rgba(189,183,107,0.5);position:absolute;left: 800px;top: 200px;width: 400px;height: 600px">
    <div class="fg" id="accountdiv" style="position:relative;left: 50px;top: 130px;width: 300px;height: 150px">
        <%--<label style="font-size: 25px;position:relative;top: 30px;">账户</label>--%>
        username:<input type="text"  name="username" id="account" style="width:200px;text-align:center;outline:none;font-size:25px;position:relative;left: 50px;top:25px;border-bottom: black 1px solid;
    border-top-style: none;
    border-right-style: none;
    border-left-style: none;
    background-color: transparent;" >
    </div>

    <div class="fg" id="passworddiv" style="position:relative;left: 50px;top:100px;width: 300px;height: 150px">
        <%--<label style="font-size: 25px;position:relative;top: 30px;">密码</label>--%>
        password:<input type="password"  name="password" id="password" style="width:200px;text-align:center;outline:none;font-size:25px;position:relative;left:50px;top:20px;border-bottom: black 1px solid;
    border-top-style: none;
    border-right-style: none;
    border-left-style: none;
    background-color: transparent;">
    </div>

    <div class="fg" id="log_reg" style="position:relative;left: 50px;top:100px;width: 300px;height: 150px">
        <input type="submit"  value="login" style="border:0;outline:none;background-color:rgba(189,183,107,0.5);font-size:30px;position:relative;left: 50px"/>
        <%--<script type="text/javascript">--%>
            <%--function login() {--%>
                <%--var url="<%=basePath%>jsp/main.jsp";--%>
                <%--var user_account=document.getElementById("account").value;--%>
                <%--var user_password=document.getElementById("password").value;--%>
                <%--var sys_acc="666";--%>
                <%--var sys_pass="aaa"--%>
                <%--window.location.href=url;--%>
                <%--// alert(user_account+" "+user_password)--%>
                <%--// if (user_account==sys_acc&&user_password==sys_pass)  {--%>
                <%--//     window.location.href=url;--%>
                <%--// }--%>
                <%--// $.ajax({--%>
                <%--//     url: "/test",--%>
                <%--//     type: "GET",--%>
                <%--//     async: false,--%>
                <%--//     success: function(data) {--%>
                <%--//         alert(data);--%>
                <%--//     }--%>
                <%--// });--%>
            <%--}--%>
        <%--</script>--%>
        <button type="button" style="border:0;outline:none;background-color:rgba(189,183,107,0.5);font-size:30px;position:relative;left: 100px">register</button>
    </div>

</div>

</body>
</form>

</html>
