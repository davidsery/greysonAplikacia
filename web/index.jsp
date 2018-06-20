<%-- 
    Document   : index
    Created on : 20-Jun-2018, 20:27:54
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        	<label>Please enter your username: <input type="text" placeholder="User name" name="username" required></label><input value="Poslat" type="button" name="login" onclick="login()">
        </div>
        <%! 
        public void login(){
            System.out.println("hojaaaaa");
        }
        %>
    </body>
</html>
