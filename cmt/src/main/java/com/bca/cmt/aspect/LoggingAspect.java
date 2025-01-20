package com.bca.cmt.aspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.bca.cmt.service..*(..))")
    public void logBeforeServiceCall() {
        log.info("A service method is about to be called.");
    }

    @AfterReturning(pointcut = "execution(* com.bca.cmt.service..*(..))", returning = "result")
    public void logAfterServiceCall(Object result) {
        log.info("Service method executed successfully. Result: {}", result);
    }

    @AfterThrowing(pointcut = "execution(* com.bca.cmt.service..*(..))", throwing = "ex")
    public void logException(Exception ex) {
        log.error("An exception occurred: {}", ex.getMessage(), ex);
    }

    @Around("execution(* com.bca.cmt.service..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Entering method: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        log.info("Exiting method: {} with result: {}", joinPoint.getSignature(), result);
        return result;
    }
}
