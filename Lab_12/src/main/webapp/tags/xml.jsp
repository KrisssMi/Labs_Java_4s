<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title>Xml JSTL tags</title>
    <style>
        table {
            border-collapse: collapse;
        }
        td {
            border: 2px solid rgba(129, 95, 133, 0.22);
            padding: 5px;
            width: 160px;
        }
        th {
            border: 2px solid rgba(243, 137, 255, 0.22);
            padding: 5px;
            width: 160px;
        }
    </style>
</head>
<body>
<x:parse var="stories">
    <c:import url="stories.xml"/>
</x:parse>

<c:catch var="exception">
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
        </tr>
        <x:forEach var="item" select="$stories/stories/story">
            <tr>
                <td><x:out select="$item/name/text()"/></td>
                <td><x:out select="$item/author/text()"/></td>
                <td><x:out select="$item/price/text()"/></td>
            </tr>
        </x:forEach>
    </table>
</c:catch>
<c:if test="${exception != null}">
    <p>Exception : ${exception} <br/>
        Message : ${exception.message}</p>
</c:if>
</body>
</html>
