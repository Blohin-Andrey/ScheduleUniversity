<%-- 
    Document   : administrator
    Created on : 07.09.2014, 17:42:02
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>

    <head>      
        <title>Administrator account</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">                
    </head>

    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/university"
                           user="root" password="admin"/>

        <sql:query var="requestion" dataSource="${snapshot}">
            SELECT 
                RequisitionId AS 'identificator',
                UserLogin AS 'teacher',
                GroupName AS 'group',
                DisciplineName AS 'discipline',
                RequisitionQuantity AS 'pairs in week'
            FROM
            Requisition AS r
                INNER JOIN
            User AS u ON r.UserId = u.UserId
                INNER JOIN 
            university.Group AS g ON r.GroupId = g.GroupId
                INNER JOIN
            Discipline AS d ON r.DisciplineId = d.DisciplineId
        </sql:query>

        <table border = 2 align = center width = 90%>
            <tr>
                <th> Identificator </th> <th> Teacher </th> <th> Group </th> <th> Discipline </th> <th> Pairs in Week </th>
            </tr>
            <c:forEach var="row" items="${requestion.rows}">
                <tr align = center>
                    <td> ${row.RequisitionId} </td> 
                    <td> ${row.UserLogin} </td> 
                    <td> ${row.GroupName} </td>
                    <td> ${row.DisciplineName} </td>
                    <td> ${row.RequisitionQuantity} </td>
                </tr>
            </c:forEach>      

            <td colspan = 7 align = right>
                <form action="ScheduleServlet" method="POST"> 
                    <input type="submit" value="Submit">
                </form>
            </td>
        </table>

    </body>
</html>
