<%-- 
    Document   : index
    Created on : 01.08.2014, 19:04:10
    Author     : Blohin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>Authorization</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="icon" href="favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    </head>
    <body>

    <!-- top bar -->
        <div class="vladmaxi-top">
            <a href="" target="_blank">Система автоматического расписания</a>
        <div class="clr"></div>
        </div>
    <!--/ top bar -->

        <form id="login" action="AuthenticationServlet" method="POST">
            <h1>The form of entry</h1>
            <fieldset id="inputs">
                <input id="username" type="text" name="Login" placeholder="Login" autofocus required value="bublik">   
                <input id="password" type="password" name="Password" placeholder="Password" required value="bread7283">
            </fieldset>
            <fieldset id="actions">
                <input type="submit" id="submit" value="Log-In">
                <a href="registration.jsp">Registration</a>
            </fieldset>
        </form>
    </body>
</html>
