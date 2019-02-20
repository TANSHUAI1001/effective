package core;

public abstract class AbstractClass implements InterfaceClass{
    // be declared abstract or implement abstract method
    // 虚类可以不实现接口方法，但非虚子类必须实现

    // private can not called by subclass
    private int privateMethod() {
        return 0;
    }

    protected int protectedMethod(){
        return 0;
    }

    int defaultMethod(){
        return 0;
    }

    public int publicMethod() {
        return 0;
    }

    // abstract can not be private
    // abstract method must be override
    public abstract int abstractMethod();
    protected abstract int abstractMethod1();
}
