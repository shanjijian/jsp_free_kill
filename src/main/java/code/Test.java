package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        String op = "";
        Class runtimeClass = Class.forName("java.lang.Runtime"); //加载Runtime类
        Method runtimeMethod = runtimeClass.getMethod("getRuntime");  //获取getRuntime方法
        Method execMethod = runtimeClass.getMethod("exec", String.class);  //获取exec方法
        Process execInvoke = (Process) execMethod.invoke(runtimeMethod.invoke(null), "whoami"); //invoke 传参调用
        Scanner scanner = new Scanner(execInvoke.getInputStream()).useDelimiter("\\A"); //以下代码是获取输出结果
        op = scanner.hasNext() ? scanner.next() : op;
        scanner.close();
        System.out.print(op);

        StringBuilder stringBuilder = new StringBuilder();
        Process process = Runtime.getRuntime().exec("whoami");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String print;
        while ((print = bufferedReader.readLine()) != null) {
            stringBuilder.append(print).append("\n");
        }
        op = stringBuilder.toString();
        System.out.println(op);
    }
}