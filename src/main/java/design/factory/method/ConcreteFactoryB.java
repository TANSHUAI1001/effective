package design.factory.method;

public class ConcreteFactoryB implements Factory {
    @Override
    public Product factoryCreate() {
        return new ConcreteProductB();
    }
}
