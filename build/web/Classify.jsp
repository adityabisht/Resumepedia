<%-- 
    Document   : Search
    Created on : Apr 28, 2015, 4:57:16 PM
    Author     : karankothari1
--%>

<%@page import="com.NBClassifier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.IR"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <!DOCTYPE html>

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Classify</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
		</noscript>
	</head>
	<body>
            <%
                String s = request.getParameter("message");
            %>
		<!-- Header -->
			<header id="header">
				<h1><a href="Index.jsp">ResumePedia</a></h1>
				<nav id="nav">
					<ul>
						<li><a href="Index.jsp">Home</a></li>
						<li><a href="Search.jsp">Search</a></li>
						<li><a href="Classify.jsp">Classify</a></li>
						<li><a href="#" class="button special">Sign Up</a></li>
					</ul>
				</nav>
			</header>

		<!-- Text box & button -->
			<section id="three" class="wrapper style3 special">
				<div class="container">
					<header class="major">
						<h2>Classify the Resume!!!</h2>
						
					</header>
				</div>
				<div class="container 75%">
					<form action="" method="post" >
						<div class="row uniform">
							<div class="12u$">
								<textarea name="message" id="message" placeholder="Insert Text to classify" rows="15" cols="50"></textarea>
							</div>
							<div class="12u$">
								<ul class="actions">
									<li><input value="Submit" class="special big" type="submit"></li>
                                                                        <li>
						
								</ul>
							</div>
						</div>
					</form>
                                    <div id="classifier">
                                  
            <%
                
            //out.print(s);
                if (s != null) {
                String t = "/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/data/train";
                NBClassifier n = new NBClassifier(t);
                //out.print(n.files[1]);
        //int ans= n.classify(s);
                String class_value = n.files[n.classify(s)];
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                
                out.println("<body>");
                out.println("<h1><p>" +class_value+ "</p></h1>");
                out.println("</head>");
                out.println("</body>");
                out.println("</html>");

            }
                else
                    out.println("Enter Resume");


        %>
                                    </div>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<section class="links">
						<div class="row">
						
							
				
						<div class="4u$ 12u$(medium)">
							<ul class="icons">
								<li>
									<a class="icon rounded fa-facebook"><span class="label">Facebook</span></a>
								</li>
								<li>
									<a class="icon rounded fa-twitter"><span class="label">Twitter</span></a>
								</li>
								<li>
									<a class="icon rounded fa-google-plus"><span class="label">Google+</span></a>
								</li>
								<li>
									<a class="icon rounded fa-linkedin"><span class="label">LinkedIn</span></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</footer>

	</body>
</html>