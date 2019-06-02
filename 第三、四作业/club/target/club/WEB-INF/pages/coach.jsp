<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ycb
  Date: 2019/5/2
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="tableBodys" border="0" cellspacing="50px" cellpadding="0">
    <tbody id="courseTbs">
    <c:forEach var="coach" items="${coached.content }" varStatus="status">
        <tr>
            <td>${coach.coachName   }</td>
            <td>${coach.coachLevel   }</td>
            <td style="text-align:center">
                <a href="javascript:void(0);"> 修改</a>
                <a href="javascript:void(0);">| 查看</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>


    <li>
                                                        <a href="?page=${coached.number+2}"  aria-label="Next">
                                                            <span aria-hidden="true">&raquo;</span>
                                                        </a>
                                                    
    </li>
</table>
</body>
</html>
