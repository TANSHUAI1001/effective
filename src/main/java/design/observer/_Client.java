package design.observer;

public class _Client {
    public static void main(String[] args) {
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();

        Subject subject = new ConcreteSubject();
        subject.attach(observer1);
        subject.attach(observer2);
        subject.notifyMethod();
    }
}
