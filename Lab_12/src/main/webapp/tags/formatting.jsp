<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Formatting JSTL tags</title>
    <style>
        .table-header {
            text-align: center;
        }
        table {
            border-collapse: collapse;
        }
        td {
            border: 1px solid black;
            padding: 5px;
            width: 300px;
        }
        .table-header td {
            background-color: #ccc;
        }
    </style>
</head>
<body>
    <p><b>Date</b></p>
    <c:set var="Date" value="<%=new java.util.Date()%>" />
    <fmt:setLocale value="en-EN"/>
    <p>English date: <fmt:formatDate value="${Date}"/></p>
    <fmt:setLocale value="ru-RU"/>
    <p>Russian date: <fmt:formatDate value="${Date}"/></p>
    <p><b>Styles of time:</b></p>
    <li>
        short: <fmt:formatDate value="${Date}" type="time" timeStyle="short"/>
    </li>
    <li>
        medium: <fmt:formatDate value="${Date}" type="time" timeStyle="medium"/>
    </li>
    <li>
        long: <fmt:formatDate value="${Date}" type="time" timeStyle="long"/>
    </li>
    <p>
        <b>Formatted Date and Time:</b>
        <fmt:formatDate type="both" value="${Date}" />
    </p>

    <p><b>Number formatting</b></p>
    <c:set var="number" value="2986.234"/>
    <li>
        Default: <fmt:formatNumber value="${number}"/>
    </li>
    <li>
        Percent: <fmt:formatNumber value="${number}" type="percent"/>
    </li>
    <li>
        Currency: <fmt:formatNumber value="${number}" type="currency"/>
    </li>
    <li>
        Max fraction = 2: <fmt:formatNumber value="${number}" type="number" maxFractionDigits="2"/>
    </li>

    <br>
    <table>
        <tr>
            <td colspan="2" class="table-header">
                <p>
                    <b>
                        Formatting:
                            <fmt:formatDate value="${Date}" type="both"
                                            timeStyle="long" dateStyle="long" />
                    </b>
                </p>
            </td>
        </tr>

        <c:forEach var="zone"
                   items="<%=java.util.TimeZone.getAvailableIDs()%>">
            <tr>
                <td>
                    <c:out value="${zone}" />
                </td>
                <td>
                    <fmt:timeZone value="${zone}">
                        <fmt:formatDate value="${Date}" timeZone="${zone}"
                                        type="both"/>
                    </fmt:timeZone>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
