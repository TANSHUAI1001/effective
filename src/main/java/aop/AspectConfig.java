package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

//    @Pointcut("@annotation(AdminOnly)")
//    public void method(){
//    }
    @Pointcut("execution(public * aop.*Service.*(..) throws java.lang.IllegalAccessException)")
    public void method(){
    }

    @Before("method()")
    public void before(){
        System.out.println("handle");
    }
}
