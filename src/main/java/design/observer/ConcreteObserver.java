package design.observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println(this+" updated !");
    }
}
