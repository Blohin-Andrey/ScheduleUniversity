<%-- 
    Document   : student
    Created on : 06.09.2014, 16:22:55
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>

    <head>      
        <title>Student account</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">                
    </head>

    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/university"
                           user="root" password="admin"/>

        <sql:query var="schedulegroup" dataSource="${snapshot}">
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
                university.Group AS g ON l.LessonGroup = g.GroupId and g.GroupName = "${UserGroup}"
            INNER JOIN
                Discipline AS d ON l.LessonDiscipline = d.DisciplineId
            INNER JOIN
                Audience as a ON l.AudienceId = a.AudienceId
            ORDER BY LessonId
        </sql:query>

        <!-- top bar -->
        <div class="vladmaxi-top">
            <a href="index.jsp" target="_blank">The main page</a>
            <div class="clr"></div>
        </div>
        <!--/ top bar -->

        <br>

        <div style="position:absolute; height:250px; width:250px;" align = center> 
            <img src="img/noavatar.jpg" alt="альтернативный текст">
            <p><b> Identificator: </b> ${UserId}</p>
            <p><b> Login: </b> ${UserLogin} </p>
            <p><b> FirstName: </b> ${UserFirstName} </p>
            <p><b> SecondName: </b> ${UserSecondName} </p>
            <p><b> Sex: </b> ${UserSex} </p>
            <p><b> Group: </b> ${UserGroup} </p>            
        </div>

        <div style="position:absolute; left:260px; height:auto; width:auto;">
            <table border = 2 align = center>
                <th colspan = 6> Расписание занятий группы: ${UserGroup}</th>         
                <tr align = center>
                    <td> Monday </td> <td> Tuesday </td> <td> Wednesday </td> <td> Thursday </td> <td> Friday </td> <td> Saturday </td>
                </tr>
                
                <tr align = center> 
                    <c:forEach var="week" begin="1" end="6" step="1">
                        <td>
                            <c:forEach var="row" items="${schedulegroup.rows}">
                                <c:set var = "day" value="${row.LessonDayOfWeek}" />  
                                <c:if test = "${week == day}"> ${row.LessonPair} пара, пр. ${row.UserLogin}, предмет ${row.DisciplineName}, ауд. ${row.AudienceNumber} <br> </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>          
                <tr>
                    <td colspan = 7 align = right>
                        <form action="ScheduleServlet" method="POST"> 
                            Здесь когда-нибудь будет кнопка скачать
                        </form>
                    </td>
                </tr>
            </table>
        </div>
                
    </body>
</html>