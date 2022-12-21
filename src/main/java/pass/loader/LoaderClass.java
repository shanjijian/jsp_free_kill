package pass.loader;

public class LoaderClass {
    /*
    Java 语言系统自带有三个类加载器:
    Bootstrap ClassLoader 最顶层的加载类，主要加载核心类库，%JRE_HOME%\lib 下的 rt.jar、resources.jar、charsets.jar 和 class 等。
        另外需要注意的是可以通过启动 jvm 时指定 - Xbootclasspath 和路径来改变 Bootstrap ClassLoader 的加载目录。
        比如java -Xbootclasspath/a:path被指定的文件追加到默认的 bootstrap 路径中。
        我们可以打开我的电脑，在上面的目录下查看，看看这些 jar 包是不是存在于这个目录。
    Extention ClassLoader 扩展的类加载器，加载目录 %JRE_HOME%\lib\ext 目录下的 jar 包和 class 文件。
        还可以加载-D java.ext.dirs选项指定的目录。
    Appclass Loader 也称为 SystemAppClass 加载当前应用的 classpath 的所有类。
     */
    public static void main(String[] args) {
        //BootstrapClassLoader加载的jar包
        System.out.println(System.getProperty("sun.boot.class.path"));
        //ExtClassLoader加载的jar包
        System.out.println(System.getProperty("java.ext.dirs"));
        //SystemClassLoader(AppClassLoader)加载的是java.class.path下的路径
        //结果为当前java工程目录target/classes，里面存放的是编译生成的class文件
        System.out.println(System.getProperty("java.class.path"));
        //使用自定义的ClassLoader加载系统类加载器
        ClassLoader systemClassLoader = Loader.MyLoader.class.getClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println("extensionClassLoader = " + extensionClassLoader);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载Java的核心类库，无法加载自定义类
        //BootStrap是祖先类不是Java编写的，所以打印出class为null
        ClassLoader bootstrapClassloader = extensionClassLoader.getParent();
        System.out.println("bootstrapClassloader = " + bootstrapClassloader);
        //sun.misc.Launcher是java虚拟机的入口应用
    }
}
