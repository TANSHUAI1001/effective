package design.factory.method;


public class ConcreteFactoryA implements Factory {
    @Override
    public Product factoryCreate() {
        return new ConcreteProductA();
    }
}
