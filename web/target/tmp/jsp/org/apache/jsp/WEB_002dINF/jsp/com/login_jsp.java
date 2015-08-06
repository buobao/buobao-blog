package org.apache.jsp.WEB_002dINF.jsp.com;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if lt IE 7 ]><html class=\"ie ie6\" lang=\"zh-CN\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7 ]><html class=\"ie ie7\" lang=\"zh-CN\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8 ]><html class=\"ie ie8\" lang=\"zh-CN\"> <![endif]-->\r\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!-->\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<!--<![endif]-->\r\n");
      out.write("<head>\r\n");
      out.write("  <base href=\"http://localhost/\">\r\n");
      out.write("  <title>Login</title>\r\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\r\n");
      out.write("  <link href=\"http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"http://localhost/static/css/jx.main.css\" rel=\"stylesheet\">\r\n");
      out.write("  <!-- jQuery scrollUp 2.0-->\r\n");
      out.write("  <link id=\"scrollUpTheme\" rel=\"stylesheet\" href=\"http://markgoodyear.com/labs/scrollup/css/themes/image.css\">\r\n");
      out.write("  <script src=\"http://cdn.bootcss.com/jquery/2.0.3/jquery.min.js\"></script>\r\n");
      out.write("  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("  <!--[if lt IE 9]>\r\n");
      out.write("  <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("  <script src=\"http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js\"></script>\r\n");
      out.write("  <![endif]-->\r\n");
      out.write("  <link href=\"//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css\" rel=\"stylesheet\"/>\r\n");
      out.write("  <style>\r\n");
      out.write("    *{margin:0;padding: 0;}\r\n");
      out.write("    body{\r\n");
      out.write("      background: #444 url(http://sandbox.runjs.cn/uploads/rs/418/nkls38xx/carbon_fibre_big.png);\r\n");
      out.write("      font-family:\"宋体\";\r\n");
      out.write("    }\r\n");
      out.write("    .loginBox{\r\n");
      out.write("      width:420px;\r\n");
      out.write("      height:280px;\r\n");
      out.write("      padding:0 20px;\r\n");
      out.write("      border:1px solid #fff;\r\n");
      out.write("      color:#000;\r\n");
      out.write("      margin-top:40px;\r\n");
      out.write("      border-radius:8px;\r\n");
      out.write("      background: white;\r\n");
      out.write("      box-shadow:0 0 15px #222;\r\n");
      out.write("      background: -moz-linear-gradient(top, #fff, #efefef 8%);\r\n");
      out.write("      background: -webkit-gradient(linear, 0 0, 0 100%, from(#f6f6f6), to(#f4f4f4));\r\n");
      out.write("      font:11px/1.5em 'Microsoft YaHei' ;\r\n");
      out.write("      position: absolute;\r\n");
      out.write("      left:50%;\r\n");
      out.write("      top:50%;\r\n");
      out.write("      margin-left:-210px;\r\n");
      out.write("      margin-top:-165px;\r\n");
      out.write("    }\r\n");
      out.write("    .loginBox h2{\r\n");
      out.write("      height:45px;\r\n");
      out.write("      font-size:20px;\r\n");
      out.write("      font-weight:normal;\r\n");
      out.write("    }\r\n");
      out.write("    .loginBox .left{\r\n");
      out.write("      border-right:1px solid #ccc;\r\n");
      out.write("      height:100%;\r\n");
      out.write("      padding-right: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    .regBtn{\r\n");
      out.write("      margin-top:21px;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <div class=\"loginBox row\">\r\n");
      out.write("    <h2 class=\"text-center\">Login</h2>\r\n");
      out.write("    <form id=\"login_form\" name=\"login_form\" action=\"");
      out.print(basePath);
      out.write("com/login.action\" method=\"post\" class=\"form-horizontal\">\r\n");
      out.write("      <div class=\"form-group has-success\">\r\n");
      out.write("        <label for=\"userName\" class=\"col-sm-2 col-md-2 control-label\">UserName</label>\r\n");
      out.write("        <div class=\"col-sm-10 col-md-10\">\r\n");
      out.write("          <input type=\"text\" class=\"form-control\" id=\"userName\" name=\"userName\" placeholder=\"User Name\" value=\"\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"form-group has-success\">\r\n");
      out.write("        <label for=\"psw\" class=\"col-sm-2 col-md-2 control-label\">Password</label>\r\n");
      out.write("        <div class=\"col-sm-10 col-md-10\">\r\n");
      out.write("          <input type=\"password\" class=\"form-control\" id=\"psw\" name=\"psw\" placeholder=\"Password\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <div class=\"col-sm-offset-4 col-sm-10\" style=\"color: #990033;\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <div class=\"col-sm-offset-4 col-sm-10 col-md-10\">\r\n");
      out.write("          <button class=\"btn btn-info\" data-loading-text=\"Logging...\" type=\"submit\">Login</button>\r\n");
      out.write("              <button class=\"btn btn-info\" type=\"reset\">Clear</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--.content-->\r\n");
      out.write("<script src=\"http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
