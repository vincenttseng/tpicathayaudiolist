<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View snaps</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>time</th>
                    <th>filename</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${screenShotList}" var="screenShot">
                    <tr>
                        <td>${screenShot.fileShownString}</td>
                        <td>${screenShot.absFilePath}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>