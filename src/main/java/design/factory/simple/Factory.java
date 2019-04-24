package design.factory.simple;

public class Factory {

    public static Product getProduct(String name){
        Product product = null;
        if(name.equalsIgnoreCase("A")){
            product = new ConcreteProductA();
        }else if(name.equalsIgnoreCase("B")){
            product = new ConcreteProductB();
        }

        return product;
    }
}
