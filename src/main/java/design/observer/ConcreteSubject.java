package design.observer;

public class ConcreteSubject extends Subject {
    @Override
    public void notifyMethod() {
        for(Object obs:observers) {
            ((Observer)obs).update();
        }
    }
}
