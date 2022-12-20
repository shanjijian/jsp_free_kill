package eval;

import java.lang.reflect.Method;

public class Eval {
    public static Object eval(String str) throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("public class Temp {\n" + "public Temp() {}\n" + "public Object getObject() {\n" + str + "return new Object();\n" + "}}");
        Class<?> clazz = new MyClassLoader().findClass(buffer.toString());
        Method method = clazz.getMethod("getObject");
        // 通过反射调用方法
        return method.invoke(clazz.newInstance());
    }

    public static void main(String[] args) throws Exception {
        Object eval = eval("System.out.println(\"Hello World\");");
        System.out.println(eval);
    }
}

