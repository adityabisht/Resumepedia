package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.IR;

public final class computer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\t\t<!-- Header -->\n");
      out.write("\t\t\t<header id=\"header\">\n");
      out.write("\t\t\t\t<h1><a href=\"computer.jsp\">Computer Doc</a></h1>\n");
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
      out.write("\t\t<!-- Main -->\n");
      out.write("\t\t\t<section id=\"main\" class=\"wrapper\">\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<header class=\"major\">\n");
      out.write("\t\t\t\t\t\t<h2>Computer Top Docs</h2>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("\n");
      out.write("\t\t\t\t\t ");

            //out.print("happy life");
            String s = "Computer";
            if (s != null) {
                IR i = new IR();

                i.searchIndexWithQueryParser(s);
                ArrayList<String> hits = i.return_hits;
                ArrayList<String> names = i.name;
                for (int j = 0; j < 10; j++) {
                    out.println("<br>");
                    //String hre = "http://"+hits.get(j);
                   out.println("<a href=\"" + hits.get(j) + "\">" + names.get(j) + "</a>");
                    //out.println("This is a placeholder");
                    out.println("</br>");

                }
                out.println("</body>");
                out.println("</html>");

            }

        
      out.write("\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t\n");
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
