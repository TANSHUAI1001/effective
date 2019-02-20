package core.classloading;

public class SuperClass {
    static {
        System.out.println("super static init");
    }

    public SuperClass(){
        System.out.println("super constructor init");
    }

    public static int superValue = 123;
    public static final String helloWorld = "HELLO WORLD";
}
