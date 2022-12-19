package reflection;

import java.lang.reflect.Method;

public class testClass {
    public static void main(String[] args) throws Throwable {
        //正常方式
        Reflect reflect = new Reflect();
        reflect.print(1, 2);
        //部分反射
        //通过运行时的对象调用getClass();
        Class<?> aClass = Class.forName("reflection.Reflect");
        //getMethod(方法名,参数类型)
        //getMethod第一个参数是方法名，第二个参数是该方法的参数类型
        //因为存在同方法名不同参数这种情况，所以只有同时指定方法名和参数类型才能唯一确定一个方法
        Method method = aClass.getMethod("print", int.class, int.class);
        //相当于reflect.print(1, 2);方法的反射操作是用method对象来进行方法调用
        //和reflect.print调用的效果完全相同
        //使用reflect调用m1获得的对象所声明的公开方法即print，并将int类型的1,2作为参数传入
        method.invoke(reflect, 1, 2);
        //全部反射
        Class.forName("reflection.Reflect")
                .getMethod("print", int.class, int.class)
                .invoke(Class.forName("reflection.Reflect")
                        .getMethod("getReflect")
                        .invoke(Class.forName("reflection.Reflect")), 1, 2);
        //如需获取实例化，也可以使用newInstance()
        Object instance = aClass.newInstance();
        System.out.println("instance = " + instance);
    }
}
