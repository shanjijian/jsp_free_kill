package reflection;

public class Reflect {
    private static Reflect reflect = new Reflect();
    public Reflect() {
    }
    public static Reflect getReflect() {
        return reflect;
    }
    public void print(int a, int b) {
        System.out.println(a + b);
    }
}