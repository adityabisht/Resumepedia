<%-- 
    Document   : input
    Created on : Apr 26, 2015, 6:09:05 PM
    Author     : karankothari1
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.*" %>
<!DOCTYPE html>

<html>
    <head>
        <style>
            #text5
            {
                background: url(search-dark.png) no-repeat 10px 6px #333;
                color: #ccc;
                width: 150px;
                padding: 6px 15px 6px 35px;
                border-radius: 20px;
                box-shadow: 0 1px 0 #ccc inset;
                transition:500ms all ease;
            }
            #text5:hover
            {
                width:180px;
            }
            .styled-button-9 {
	background: #00A0D1;
	background: -moz-linear-gradient(top,#00A0D1 0%,#008DB8 100%);
	background: -webkit-gradient(linear,left top,left bottom,color-stop(0%,#00A0D1),color-stop(100%,#008DB8));
	background: -webkit-linear-gradient(top,#00A0D1 0%,#008DB8 100%);
	background: -o-linear-gradient(top,#00A0D1 0%,#008DB8 100%);
	background: -ms-linear-gradient(top,#00A0D1 0%,#008DB8 100%);
	background: linear-gradient(top,#00A0D1 0%,#008DB8 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00A0D1',endColorstr='#008DB8',GradientType=0);
	padding:8px 20px;
	color:#cfebf3;
	font-family:'Helvetica Neue',sans-serif;
	font-size:13px;
	border-radius:40px;
	-moz-border-radius:40px;
	-webkit-border-radius:40px;
	border:1px solid #095B7E
            }
            h1 {text-align: center}
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ResumePedia</title>
    </head>
    <body>
        <h1>ResumePedia</h1>
        <form action="" method="get">
            Search <input id="text5" type="text" name="input" value=""/><br>
            <input type="submit" value="Submit" class="styled-button-9" />
            <input type="reset" value="Clear" name="Clear" class="styled-button-9" />
        </form>

        <%
            //out.print("happy life");
            String s = request.getParameter("input");
            if (s != null) {
                IR i = new IR();

                i.searchIndexWithQueryParser(s);
                ArrayList<String> hits = i.return_hits;
                ArrayList<String> names = i.name;
                for (int j = 0; j < hits.size(); j++) {
                    out.println("<br>");
                    out.println("<a href=\"" + hits.get(j) + "\">" + names.get(j) + "</a>");
                    //out.println("This is a placeholder");
                    out.println("</br>");

                }
                out.println("</body>");
                out.println("</html>");

            }

        %>


    </body>
</html>
