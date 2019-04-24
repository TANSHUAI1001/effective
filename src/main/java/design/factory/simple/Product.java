package design.factory.simple;

public abstract class Product {
    public void commonMethod(){
        System.out.println("hello");
    }

    public abstract void diffMethod();
}
