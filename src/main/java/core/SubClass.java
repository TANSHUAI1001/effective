package core;

public class SubClass extends AbstractClass {
    // be declared abstract or implement abstract method
    // 虚类可以不实现接口方法，但非虚子类必须实现
    @Override
    public int abstractMethod() {
        return 0;
    }

    @Override
    protected int abstractMethod1() {
        return 0;
    }

    @Override
    public int defaultInterfaceMethod() {
        return 0;
    }

    @Override
    public int publicInterfaceMethod() {
        return 0;
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.protectedMethod();
        subClass.defaultMethod();
        subClass.publicMethod();
        subClass.abstractMethod();
    }

}
