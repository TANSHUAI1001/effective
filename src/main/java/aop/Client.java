package aop;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Subject.class},
                new JdkProxySubject(new RealSubject()));

        subject.request();
        subject.hello();

        // cglib
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject1 = (Subject) enhancer.create();
        subject1.hello();
        subject1.request();
    }
}
