package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.IR;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <div class=\"container 75%\">\n");
      out.write("\t\t\t\t\t<form action=\"\" method=\"get\">\n");
      out.write("\t\t\t\t\t\t<div class=\"row uniform\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"6u 12u$(small)\">\n");
      out.write("\t\t\t\t\t\t\t\t<input name=\"input\" id=\"name\" value=\"\" placeholder=\"Search\" type=\"text\" autocomplete=\"off\">\n");
      out.write("                                                        </div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"12u$\">\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"actions\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><input value=\"Search\" class=\"special big\" type=\"submit\"></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("                                    <div id=\"ssresults\">\n");
      out.write("    </head>\n");
      out.write("     ");

            //out.print("happy life");
            String s = request.getParameter("input");
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
      out.write("</html>\n");
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
