<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>Sql JSTL tags</title>
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
    <sql:setDataSource var="methods"
        url="jdbc:sqlserver://Kris_Mi;databaseName=Java_10;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false"
        driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" user="sa" password="1111"/>

    <sql:query var="rs" dataSource="${methods}">
        select * from user_auth;
    </sql:query>

    <table>
        <tr>
            <th>login</th>
            <th>status</th>
        </tr>
        <c:forEach items="${rs.rows}" var="row">
            <tr>
                <td>${row.login}</td>
                <td>${row.status}</td>
            </tr>
        </c:forEach>
        </tr>
    </table>
</body>
</html>
