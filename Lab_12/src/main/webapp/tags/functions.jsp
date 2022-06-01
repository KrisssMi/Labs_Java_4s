<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Function JSTL tags</title>
</head>
<body>
    <p><b>Hello, World!</b></p>
    <c:set var="string" value="Hello, World!"/>

    <c:if test="${fn:containsIgnoreCase(string, 'world')}">
        <p>The string contains 'world' (ignore case)</p>
    </c:if>

    <c:if test="${fn:endsWith(string, '!')}">
        <p>The string ends with '!'</p>
    </c:if>

    <c:if test="${fn:startsWith(string, 'Hello')}">
        <p>The string starts with 'Hello'</p>
    </c:if>

    <p>Length: ${fn:length(string)}</p>

    <c:set var="string1" value="${fn:replace(string, '!', ', ')}"/>
    <c:set var="string2" value="${fn:split(string1, ', ')}"/>
    <c:set var="string3" value="${fn:join(string2, '-')}"/>
    <p>Words: ${string3}</p>
</body>
</html>
