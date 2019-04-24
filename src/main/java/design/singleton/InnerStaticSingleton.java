package design.singleton;

/**
 * defect：在反序列化、反射、克隆时重新生成实例对象
 */
public class InnerStaticSingleton {
    private InnerStaticSingleton() {
    }

    private static class SingletonInstance{
        private static final InnerStaticSingleton instance = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance(){
        return SingletonInstance.instance;
    }
}
