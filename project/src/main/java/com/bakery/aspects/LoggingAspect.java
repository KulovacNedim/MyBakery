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

    @AfterReturning(pointcut = "execution(* com.bakery.services.*..*(..))", returning = "result")
    public void servicesGetMethodsLogger(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().getName();
        String service = joinPoint.getSourceLocation().getWithinType().toString();

        if (result == null) {
            logger.info("SERVICE: " + service + ";");
            logger.info(" - METHOD: " + method);
            logger.info(" - RETURNED: null");
        }
        else {
            if (result instanceof List<?>) {
                List<Object> resultList = (List)result;
                logger.info("SERVICE: " + service + ";");
                logger.info(" - METHOD: " + method);
                if (resultList.isEmpty()) {
                    logger.info(" - RETURNED: " + resultList.getClass().getSimpleName()
                            + "<" + resultList.get(0).getClass().getSimpleName() + ">"
                            + " with " + resultList.size() + " elements: ");
                } else {
                    logger.info(" - RETURNED: " + resultList.getClass().getSimpleName()
                            + "<" + resultList.get(0).getClass().getSimpleName() + ">"
                            + " with " + resultList.size() + " elements: ");
                }

                for (Object object : resultList) {
                    logger.info(" - - " + object.toString());
                }
            }
            else {
                logger.info("SERVICE: " + service);
                logger.info(" - METHOD: " + method);
                logger.info(" - RETURNED: " + result.getClass().getSimpleName());
                logger.info(" - - " + result.toString());
            }
        }
    }
}
