<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ycb
  Date: 2019/5/31
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="tableBody1" border="0" cellspacing="50px" cellpadding="0">
    <tbody id="courseTb1">
    <c:forEach var="course" items="${privacycourses }" varStatus="status">
        <tr>
            <td>${course.courseId   }</td>
            <td>${course.courseName   }</td>
            <td>${course.duration   }</td>
            <td>${course.userName   }</td>
            <td>${course.coachName   }</td>
            <td style="text-align:center">

                <a href="/privacy_chosen/${course.courseId   }/${course.userName   }"> 预定</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
