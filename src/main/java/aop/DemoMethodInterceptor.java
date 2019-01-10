package aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DemoMethodInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before");
        Object result = null;
        try{
            result = methodProxy.invokeSuper(o,objects);
        }catch (Exception e){
            System.out.println("cglib ex:"+e.getMessage());
            throw e;
        }finally {
            System.out.println("cglib after");
        }

        return result;
    }
}
