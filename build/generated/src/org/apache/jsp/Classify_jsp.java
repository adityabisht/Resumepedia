package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.NBClassifier;
import java.util.ArrayList;
import com.IR;

public final class Classify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   <!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("\tTransit by TEMPLATED\n");
      out.write("\ttemplated.co @templatedco\n");
      out.write("\tReleased for free under the Creative Commons Attribution 3.0 license (templated.co/license)\n");
      out.write("-->\n");
      out.write("<html lang=\"en\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<title>ResumePedia</title>\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t<meta name=\"description\" content=\"\" />\n");
      out.write("\t\t<meta name=\"keywords\" content=\"\" />\n");
      out.write("\t\t<!--[if lte IE 8]><script src=\"js/html5shiv.js\"></script><![endif]-->\n");
      out.write("\t\t<script src=\"js/jquery.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/skel.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/skel-layers.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/init.js\"></script>\n");
      out.write("\t\t<noscript>\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/skel.css\" />\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/style-xlarge.css\" />\n");
      out.write("\t\t</noscript>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("            ");

                String s = request.getParameter("message");
            
      out.write("\n");
      out.write("\t\t<!-- Header -->\n");
      out.write("\t\t\t<header id=\"header\">\n");
      out.write("\t\t\t\t<h1><a href=\"Index.jsp\">ResumePedia</a></h1>\n");
      out.write("\t\t\t\t<nav id=\"nav\">\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"Index.jsp\">Home</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"Search.jsp\">Search</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"Classify.jsp\">Classify</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" class=\"button special\">Sign Up</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</nav>\n");
      out.write("\t\t\t</header>\n");
      out.write("\n");
      out.write("\t\t<!-- Text box & button -->\n");
      out.write("\t\t\t<section id=\"three\" class=\"wrapper style3 special\">\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t\t<header class=\"major\">\n");
      out.write("\t\t\t\t\t\t<h2>Classify the Resume!!!</h2>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"container 75%\">\n");
      out.write("\t\t\t\t\t<form action=\"\" method=\"post\" >\n");
      out.write("\t\t\t\t\t\t<div class=\"row uniform\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"12u$\">\n");
      out.write("\t\t\t\t\t\t\t\t<textarea name=\"message\" id=\"message\" placeholder=\"Insert Text to classify\" rows=\"15\" cols=\"50\"></textarea>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"12u$\">\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"actions\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><input value=\"Submit\" class=\"special big\" type=\"submit\"></li>\n");
      out.write("                                                                        <li>\n");
      out.write("\t\t\t\t\t\t<a href=\"Search.jsp\" class=\"button big\">Computer</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\n");
      out.write("                               \n");
      out.write("\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t<a href=\"\" class=\"button big\">MBA</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("                                        <li>\n");
      out.write("\t\t\t\t\t\t<a href=\"\" class=\"button big\">Attorney</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("                                    <div id=\"classifier\">\n");
      out.write("                                  \n");
      out.write("            ");

                
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


        
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t<!-- Footer -->\n");
      out.write("\t\t\t<footer id=\"footer\">\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t\t<section class=\"links\">\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div class=\"4u$ 12u$(medium)\">\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"icons\">\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"icon rounded fa-facebook\"><span class=\"label\">Facebook</span></a>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"icon rounded fa-twitter\"><span class=\"label\">Twitter</span></a>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"icon rounded fa-google-plus\"><span class=\"label\">Google+</span></a>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a class=\"icon rounded fa-linkedin\"><span class=\"label\">LinkedIn</span></a>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</footer>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
