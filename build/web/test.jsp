<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.IR"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Text</title>
        <div class="container 75%">
					<form action="" method="get">
						<div class="row uniform">
							<div class="6u 12u$(small)">
								<input name="input" id="name" value="" placeholder="Search" type="text" autocomplete="off">
                                                        </div>
							<div class="12u$">
								<ul class="actions">
									<li><input value="Search" class="special big" type="submit"></li>
								</ul>
							</div>
						</div>
					</form>
                                    <div id="ssresults">
                                        <%
            //out.print("happy life");
            String s = request.getParameter("input");
            if (s != null) {
                IR i = new IR();

                i.searchIndexWithQueryParser(s);
                ArrayList<String> hits = i.return_hits;
                ArrayList<String> names = i.name;
                Iterator<String> itr = hits.iterator();
        
                //BufferedReader reader = new BufferedReader(new FileReader(hits));
           // StringBuilder sb = new StringBuilder();
            //String line;

            //while((line = reader.readLine())!= null){
              //  sb.append(line+"\n");
            //}
            //out.println(sb.toString());
                for (int j = 0; j < hits.size(); j++) {
                    out.println("<br>");
                    //String hre = "http://"+hits.get(j);
                   out.println("<a href=\"" + hits.get(j) + "\">" + names.get(j) + "</a>");
                   while(itr.hasNext()){
            out.println(itr.next());
        }

                    //out.println("This is a placeholder");
                    out.println("</br>");

                }
                out.println("</body>");
                out.println("</html>");

            }

        %>
                                    </div>
				</div>
			</section>

    </body>
</html>