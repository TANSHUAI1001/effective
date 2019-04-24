package design.factory.simple;

public class Client {
    public static void main(String[] args) {
        Product product = Factory.getProduct("B");
        product.commonMethod();
        product.diffMethod();
    }
}
