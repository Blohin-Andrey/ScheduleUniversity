<%-- 
    Document   : schedule
    Created on : 07.09.2014, 17:58:18
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>

    <head>      
        <title>Teacher account</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">                
    </head>

    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/university"
                           user="root" password="admin"/>

        <sql:query var="lessons" dataSource="${snapshot}">
            SELECT 
                LessonId AS 'identificator',
                UserLogin AS 'teacher',
                GroupName AS 'group',
                DisciplineName AS 'discipline',
                LessonDayOfWeek AS 'day of week',
                LessonPair AS 'pair',
                AudienceNumber AS 'number room'
            FROM Lesson AS l
                INNER JOIN
            User as u ON l.LessonTeacher = u.UserId
                INNER JOIN
            university.Group AS g ON l.LessonGroup = g.GroupId
                INNER JOIN
            Discipline AS d ON l.LessonDiscipline = d.DisciplineId
                INNER JOIN
            Audience as a ON l.AudienceId = a.AudienceId
            ORDER BY LessonId
        </sql:query>        
        
        <table border = 2 align = center  width = 90%>

            <tr>
                <th> Identificator </th> <th> Teacher </th> <th> Group </th> <th> Discipline </th> <th> DayOfWeek </th> <th> Pair </th> <th> Room </th>
            </tr>

            <c:forEach var="row" items="${lessons.rows}">
                <tr align = center>
                    <td> ${row.LessonId} </td> 
                    <td> ${row.UserLogin} </td> 
                    <td> ${row.GroupName} </td>
                    <td> ${row.DisciplineName} </td>
                    <td> ${row.LessonDayOfWeek} </td>
                    <td> ${row.LessonDayOfWeek} </td>
                    <td> ${row.AudienceNumber} </td>
                </tr>
            </c:forEach>
            
           <td colspan = 7 align = right>
                <form action="index.jsp" method="POST"> 
                    <input type="submit" value="Exit">
            </td>
            
        </table>
    </body>
</html>
