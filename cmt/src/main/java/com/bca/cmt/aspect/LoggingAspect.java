package com.bca.cmt.aspect;
import com.bca.cmt.service.log.LogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    final LogService logService;

    public LoggingAspect(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("execution(* com.bca.cmt.*.*.*(..)) && !execution(* com.bca.cmt.interceptor.*.*(..)) && !execution(* com.bca.cmt.config.*.*(..))")
    public void serviceMethods() {}
    
    @Before("serviceMethods()")
    public void logBeforeServiceCall() {
        log.info("A service method is about to be called.");
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterServiceCall(JoinPoint joinPoint , Object result) {
            log.info("Service method executed successfully. Result: {}  -- Name : {}", result, joinPoint.getSignature().toShortString());

            // Eğer sonuç null değilse işlemi devam ettir
            if (result != null) {
                // RequestAttributes'ı güvenli bir şekilde al
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

                // Eğer RequestAttributes mevcutsa işlemi yap
                if (requestAttributes != null) {
                    HttpServletRequest request = requestAttributes.getRequest();
                    String uri = request.getRequestURI();
                    String method = request.getMethod();

                    // Servis çağrısını logla
                    logService.logCreate(joinPoint, result, "Service Call", uri, method);
                } else {
                    // RequestAttributes mevcut değilse alternatif loglama yapabilirsiniz
                    log.warn("No HTTP request context available for logging");
                }
            }
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        log.error("An exception occurred: {} {} {}", ex.getMessage(), ex,joinPoint.getSignature().getName());
    }

    @Around("serviceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Entering method: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        log.info("Exiting method: {} with result: {}", joinPoint.getSignature(), result);
        return result;
    }

}
