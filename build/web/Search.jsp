<%-- 
    Document   : Search
    Created on : Apr 28, 2015, 4:57:16 PM
    Author     : karankothari1
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.IR"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Search</title>
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
						<h2>Search the Candidate</h2>
						<p>Enter the query of any of the following types :
                                                <br>1. WILDCARD QUERY FOR MULTIPLE CHARACTERS MISSING - 'so*ware'
        <br>2. WILDCARD QUERY FOR SINGLE CHARACTER MISSING - 'mana?ement'
        <br>3. BOOLEAN QUERY WITH OR - '(COMPUTERS  ) OR (MANAGEMENT )'
        <br>4. BOOLEAN QUERY WITH AND - '(education ) AND (information)'
        <br>5. COMBINATION OF BOOLEAN AND WILDCARD QUERY '(comp*rs OR information) AND (info?mation)'
                                                </p>
					</header>
				</div>
				<div class="container 75%">
					<form action="" method="get">
						<div class="row uniform">
							<div class="6u 12u$(small)">
								<input name="input" id="name" value="" placeholder="Search" type="text" autocomplete="off">
                                                        </div>
							<div class="12u$">
								<ul class="actions">
									<li><input value="Search" class="special big" type="submit"></li>
                                                                        <a href="computer.jsp" class="button big">Computer</a>
					</li>
				
                               
					<li>
						<a href="mba.jsp" class="button big">MBA</a>
					</li>
                                        <li>
						<a href="attorney.jsp" class="button big">Attorney</a>
					</li>
								</ul>
							</div>
						</div>
					</form>
                                    <div id="ssresults">
                                        <%
            //out.print("happy life");
            String s = request.getParameter("input");
            if (s != null) 
            {
                IR i = new IR();

                i.searchIndexWithQueryParser(s);
                ArrayList<String> hits = i.return_hits;
                ArrayList<String> names = i.name;
                for (int j = 0; j < hits.size(); j++) {
                    out.println("<br>");
                    //String hre = "http://"+hits.get(j);
                   out.println("<a href=\"" + hits.get(j) + "\">" + names.get(j) + "</a>");
                    //out.println("This is a placeholder");
                    out.println("</br>");

                }
                out.println("</body>");
                out.println("</html>");
                

            }
            else 
                out.print("Enter Search word");
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