package eval;

import java.util.Arrays;

import javax.tools.SimpleJavaFileObject;
import javax.tools.JavaFileObject;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.net.URI;
import java.util.Collections;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String str) throws ClassNotFoundException {
        // 获取平台提供的Java编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 内存中的源代码保存在一个从JavaFileObject继承的类中
        JavaFileObject file = new JavaSourceFromString("Temp", str);
        Iterable<JavaFileObject> compilationUnits = Collections.singletonList(file);
        String flag = "-d";
        String outDir = System.getProperty("user.dir") + "/" + "target/classes";
        Iterable<String> stringList = Arrays.asList(flag, outDir); // 指定-d dir 参数
        // 建立一个编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, null, null, stringList, null, compilationUnits);
        // 编译源程序
        boolean result = task.call();
        if (result) {
            return Class.forName("Temp");
        }
        return null;
    }

}

class JavaSourceFromString extends SimpleJavaFileObject {
    private String name;
    private String code;

    public JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}