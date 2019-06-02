<%--
  Created by IntelliJ IDEA.
  User: ycb
  Date: 2019/5/11
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>

<div class="links" id="link">
    <input type="button" value="回到首頁" onclick="tolinks()"
           style="font-size: 25px;position:relative;left: 900px;top:20px  ">
    <script type="text/javascript">
        function tolinks() {
            window.location.href = "${linklist.get(0) }"
        }
    </script>


</div>


</body>
</html>
