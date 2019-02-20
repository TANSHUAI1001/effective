package core.classloading;

public class SubClass extends SuperClass{
    static {
        System.out.println("subclass static init");
    }

    public SubClass(){
        System.out.println("subclass constructor init");
    }
    public static int subValue = 111;

    public static void test(){
        System.out.println("subclass static method");
    }
}
