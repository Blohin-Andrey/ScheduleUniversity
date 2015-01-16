<%-- 
    Document   : Teacher
    Created on : 06.09.2014, 14:01:54
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

        <sql:query var="groups" dataSource="${snapshot}">
            SELECT GroupId, GroupName FROM University.Group
        </sql:query>

        <sql:query var="subjects" dataSource="${snapshot}">
            SELECT DisciplineId, DisciplineName FROM Discipline
        </sql:query>

        <!-- top bar -->
        <div class="vladmaxi-top">
            <a href="/index.jsp" target="_blank">The main page</a>
            <div class="clr"></div>
        </div>
        <!--/ top bar -->
        
        <br>
        
        <div style="position:absolute; height:300px; width:250px; background: linear-gradient(45deg, #f06, yellow);" id="Login"> 
            <p><b> Identificator: </b> ${UserId}</p>
            <p><b> Login: </b> ${UserLogin} </p>
            <p><b> FirstName: </b> ${UserFirstName} </p>
            <p><b> SecondName: </b> ${UserSecondName} </p>
            <p><b> Sex: </b> ${UserSex} </p>                       
        </div>

        <div style="position:absolute; left:260px; height:300px; width:800px; background: yellow">

            <form action="ApplicationServlet" method="POST">

                <input type="hidden" name="User" value="${UserId}"/>
                
                <label> Select number a group </label>
                <select name="ChooseGroup">
                    <c:forEach var="row" items="${groups.rows}">
                        <option value="${row.GroupId}">${row.GroupName}</option>
                    </c:forEach>
                </select>
                <br>
                <label> Select a subject </label>
                <select name="ChooseDiscipline">
                    <c:forEach var="row" items="${subjects.rows}">
                        <option value="${row.DisciplineId}">${row.DisciplineName}</option>
                    </c:forEach>
                </select>
                <br>
                <label> Input number occupation per week </label>
                <input type="text" size="35" name="RequisitionPairsInWeek" value="">
                <br>
                <input type="submit" value="SendApplication">             
            </form>

        </div>

    </body>
</html>
