<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Photos</title>
</head>
<body>
<h1><%
    String nombre = request.getParameter("Nombre");
    out.println("Hello " + nombre);
    Cookie cNombre = new Cookie("Nombre", nombre);
    response.addCookie(cNombre);
    Cookie[] cookies = request.getCookies();
    for(int i = 0; i < cookies.length; i++){
        out.println(cookies[i].getName() + ": " + cookies[i].getValue());
    }
%>
</h1>



</body>
</html>