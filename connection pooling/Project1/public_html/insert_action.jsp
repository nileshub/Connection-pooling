<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    </head>
    <body>
         <jsp:useBean id="empbean" class="project1.InsertDataServlet" scope="session"/>
        <%String mail =request.getParameter("email");
int id = Integer.parseInt(request.getParameter("staff_id"));
empbean.insert_data(mail,id);%>
    </body>
</html>