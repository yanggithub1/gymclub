<%--
  Created by IntelliJ IDEA.
  User: ycb
  Date: 2019/5/3
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>coachlist</title>
</head>
<body>
jjjj
<table id="tableBodys" border="0" cellspacing="50px" cellpadding="0" >
    <tbody id="courseTbs">
    ${coachPage }
    ${coachPage.totalPages }
    ${coachPage.totalElements }
    <c:forEach var="coach" items="${coachPage.content }" varStatus="status">
        <tr>
            <td>${coach.coachName   }</td>
            <td>${coach.coachLevel   }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
