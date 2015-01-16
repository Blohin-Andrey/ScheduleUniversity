<%-- 
    Document   : regestration
    Created on : 22.08.2014, 12:41:52
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <title>Registration form</title>        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">      
        <link rel="stylesheet" href="css/registration.css">
        <script type="text/javascript" src="js/checkDataRegistration.js"> </script>
    </head>

    <body class="bg-cyan">
        <div class="body body-s">    
            <form class="sky-form" action="RegistrationServlet" method="post" onSubmit="return validationForm(this);">
                <header>Registration form</header>

                <fieldset>
                    <section>
                        <label class="input">
                            <input type="text" name="Login" placeholder="UserName">
                            <b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
                        </label>
                    </section>

                    <section>
                        <label class="input">
                            <input type="text" name="EmailAddress" placeholder="Email address">
                            <b class="tooltip tooltip-bottom-right">Needed to verify your account</b>
                        </label>
                    </section>

                    <section>
                        <label class="input">
                            <input type="password" name="Password" placeholder="Password">
                            <b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
                        </label>
                    </section>

                    <section>
                        <label class="input">
                            <input type="password" name="ConfirmPassword" placeholder="Confirm password">
                            <b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
                        </label>
                    </section>  
                </fieldset>

                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">
                                <input type="text" name="FirstName" placeholder="First name">
                            </label>
                        </section>

                        <section class="col col-6">
                            <label class="input">
                                <input type="text" name="LastName" placeholder="Last name">
                            </label>
                        </section>
                    </div>

                    <section>
                        <label class="select">
                            <select name="ChooseSex">
                                <option value="None" selected disabled>Gender</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                            <i></i>
                        </label>
                    </section>

                    <section>
                        <label class="select">
                            <select name="ChooseRole">
                                <option value="None" selected disabled>Role</option>
                                <option value="1">Student</option>
                                <option value="2">Teacher</option>
                            </select>
                            <i></i>
                        </label>
                    </section>
                </fieldset>
                <footer>
                    <input type="text" size="35" name="msg" value="${RegistrationError}">
                    <button type="submit" class="button">Submit</button>
                </footer>
            </form>
        </div>
    </body>
</html>
