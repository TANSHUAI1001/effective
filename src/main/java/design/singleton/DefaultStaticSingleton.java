package design.singleton;

public class DefaultStaticSingleton {
    private static DefaultStaticSingleton ourInstance = new DefaultStaticSingleton();

    public static DefaultStaticSingleton getInstance() {
        return ourInstance;
    }

    private DefaultStaticSingleton() {
    }
}
