package aop;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("subject request");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
