package design.factory.method;

/**
 * 每一个具体的产品ConcreteProduct（或其子类）对应一个ConcreteFactory
 * 可以通过配置文件来存储具体工厂类ConcreteFactory的类名，更换新的具体工厂时无须修改源代码，系统扩展更为方便。
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA(); // 可通过配置文件注入
        Product product = factory.factoryCreate();
        System.out.println(product);
        factory = new ConcreteFactoryB(); // 可通过配置文件注入
        product = factory.factoryCreate();
        System.out.println(product);
    }
}
