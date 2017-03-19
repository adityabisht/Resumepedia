<%-- 
    Document   : classifier
    Created on : Apr 27, 2015, 9:50:41 PM
    Author     : karankothari1
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Pages</title>

    </head>


    <body>
        <h1>ResumePedia</h1>
        <form action="" method="get">
            Search <textarea name="text" rows="15" cols="50"></textarea><br>
            <input type="submit" value="Submit"/>
            <input type="reset" value="Clear" name="Clear" />
        </form>

        <%

            String s = request.getParameter("text");
            //out.print(s);
            if (s != null) {
                String t = "/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/data/train";
                NBClassifier n = new NBClassifier(t);
                //out.print(n.files[1]);
        //int ans= n.classify(s);
                String class_value = n.files[n.classify(s)];
                out.println(class_value);

            }


        %>
    </body>
</html>
