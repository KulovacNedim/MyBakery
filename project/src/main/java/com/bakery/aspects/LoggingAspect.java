package com.bakery.aspects;

import com.bakery.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
    public void getAllProductsPrint(JoinPoint joinPoint, Object result) {

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

}
