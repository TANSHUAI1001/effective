package core.classloading;

public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.superValue);// super init 子类被动引用不会初始化

//        System.out.println(SubClass.subValue);// super init && subclass init ==> get static
//        SubClass.subValue = 10;// super init && subclass init ==> put static
//        SubClass.test();// super init && subclass init ==> invoke static

//        SuperClass[] sca = new SuperClass[10];// 定义数组不会触发初始化

//        System.out.println(SuperClass.helloWorld);//常量在编译阶段会存入常量池，调用也不会触发初始化

        SuperClass ss = new SubClass();
        /*
        super static init
        subclass static init
        super constructor init
        subclass constructor init
         *///:~执行顺序
    }
}
