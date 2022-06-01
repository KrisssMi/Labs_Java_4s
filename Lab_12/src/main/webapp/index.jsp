<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="my" uri="myTags.tld" %>
<!DOCTYPE html>
<html>
<style>
body {
    background-color: #fcf5d2;
    size: A4;
    font-family: "Imprint MT Shadow";
    font-size: 30px;
    text-align: center;
}
form {
    display: inline-block;
    margin-right: 70px;
}
button
{
    font: bold 20px "Imprint MT Shadow";
    background: #790000;
    border: 2px solid black;
    padding: 5px;
    margin: 5px;
    font-size: 30px;
    color: white;
    background-size: contain;
}
</style>
<head>
    <title>Lab_12</title>
</head>
<body>
<fieldset>
    <legend>Tags</legend>
    <form action="tags/core.jsp">
        <my:Submit label="Core"/>
    </form>
    <form action="tags/formatting.jsp">
        <my:Submit label="Formatting"/>
    </form>
    <form action="tags/sql.jsp">
        <my:Submit label="Sql"/>
    </form>
    <form action="tags/xml.jsp">
        <my:Submit label="Xml"/>
    </form>
    <form action="tags/functions.jsp">
        <my:Submit label="Funtions"/>
    </form>
    <form action="table.jsp">
        <my:Submit label="Table"/>
    </form>
</fieldset>
</body>
</html>