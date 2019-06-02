<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ycb
  Date: 2019/4/28
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id="tableBody" border="0" cellspacing="50px" cellpadding="0">
    <tbody id="courseTb">
    <c:forEach var="course" items="${courselist }" varStatus="status">
        <tr>
            <td>${course.courseId   }</td>
            <td>${course.courseName   }</td>
            <td>${course.duration   }</td>
            <td>${course.userName   }</td>
            <td>${course.coachName   }</td>
            <td>${course.isPrivacy   }</td>
            <td style="text-align:center">
                <a href="javascript:void(0);"> 修改</a>
                <a href="javascript:void(0);">| 查看</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
