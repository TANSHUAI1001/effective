package design.factory.abstracts;

public class _Client {
    public static void main(String[] args) {
        ProductA productA;
        ProductB productB;
        Factory factory1 = new ConcreteFactory1();
        productA = factory1.createProductA();
        productB = factory1.createProductB();
        System.out.println(productA+"-"+productB);
        Factory factory2 = new ConcreteFactory2();
        productA = factory2.createProductA();
        productB = factory2.createProductB();
        System.out.println(productA+"-"+productB);
    }
}
