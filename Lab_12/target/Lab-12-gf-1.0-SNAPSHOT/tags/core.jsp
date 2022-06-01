<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Core JSTL tags</title>
</head>
<body>
    <p><b>Out tag</b></p>
    <c:out value="16 + 64 * 2 = "/>
    <c:out value="${16 + 64 * 2}"/>

    <p><b>If tag</b></p>
    <c:set var="user" value="Kristina" scope="session"/>
    <c:if test="${user eq 'Sasha'}">
        <c:out value="You joined as admin"/>
    </c:if>

    <p><b>Choose tag</b></p>
    <c:set var="age" value="18" scope="page"/>
    <c:choose>
        <c:when test="${age == 18}">
            <c:out value="You are adult :("/>
        </c:when>
        <c:otherwise>
            <c:out value="You are baby :)"/>
        </c:otherwise>
    </c:choose>

    <p><b>ForEach tag</b></p>
    <%
        String[] lp = {"C++", "Java", "Go", "PHP", "C#", "Python", "Ruby", "JavaScript", "Swift", "Kotlin", "Scala", "Objective-C"};
        request.setAttribute("lp", lp);
    %>
    <c:forEach items="${lp}" var="lang">
        <li>${lang}</li>
    </c:forEach>

    <p><b>Catch tag</b></p>
    <c:catch var="exception">
        <% int num = 0 / 0; %>
    </c:catch>
    <c:if test="${exception != null}">
        <p>Exception : ${exception} <br/>
        Message : ${exception.message}</p>
    </c:if>
</body>
</html>
