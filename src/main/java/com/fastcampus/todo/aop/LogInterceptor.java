package com.fastcampus.todo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Martin
 * @since 2021/01/11
 */
@Component
@Aspect
public class LogInterceptor {
//    @Around("execution(* com.fastcampus..*.UserService.*(..))")
    @Around("@annotation(CustomLog)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        System.out.println(">>> Log Interceptor Start!!!");

        Object retVal = pjp.proceed();

        System.out.println(">>> Log Interceptor End!!!");
//        stopWatch.stop();

//        System.out.println(">>>> " + stopWatch.prettyPrint());
        return retVal;
    }
}
