package com.bakery.aspects;

import com.bakery.exceptions.ServiceException;
import com.bakery.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Profile("dev")
@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @AfterReturning(pointcut = "execution(* com.bakery.services.*.get*())", returning = "result")
    public void servicesGetMethodsLogger(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().getName();
        String service = joinPoint.getSourceLocation().getWithinType().toString();

        if (result == null) {
            logger.info("SERVICE: " + service + "; METHOD: " + method + " returned null");
        }
        else {
            List<Object> returned = (List)result;
            logger.info("SERVICE: " + service + "; METHOD: " + method + " returned " + returned.size() + " items: ");
            for (Object product : returned) {
                logger.info(product.toString());
            }
        }
    }

//    @Before("execution(* com.bakery.exceptions.ServiceExceptioHandler.handle()) && args(e)")
//    public void serviceExceptionHandlerLogger(JoinPoint joinPoint, ServiceException e) {
////        ServiceException e = (ServiceException) joinPoint.getArgs()[0];
//
//            logger.warning("Exception thrown by " + joinPoint.getSourceLocation());
//            logger.warning(" - ErrorCode: " + e.getErrorCode().getCode());
//            logger.warning(" - Message: " + e.getErrorCode().getMessage());
//
//    }

//    @AfterThrowing(pointcut = "execution(* com.bakery.services..*(..))", throwing = "e")
//    public void serviceExceptionLogger(ServiceException e, JoinPoint joinPoint) throws Throwable {
//        logger.warning("Exception thrown by " + joinPoint.getSourceLocation());
//        logger.warning(" - ErrorCode: " + e.getErrorCode().getCode());
//        logger.warning(" - Message: " + e.getErrorCode().getMessage());
//    }

}
