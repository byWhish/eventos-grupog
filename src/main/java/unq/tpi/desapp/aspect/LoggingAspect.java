package unq.tpi.desapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* unq.tpi.desapp.webservice..*(..))")
    private void loggingTargets() {}

    @Before("loggingTargets()")
    public void logEnterMethod(JoinPoint thisJoinPoint) {
        LOGGER.info("ENTER " + thisJoinPoint);
    }

    @AfterReturning(pointcut = "loggingTargets()", returning = "result")
    public void logExitMethod(JoinPoint thisJoinPoint, Object result) {
        LOGGER.info("EXIT  " + thisJoinPoint + " -> return value = " + result);
    }

    @AfterThrowing(pointcut = "loggingTargets()", throwing = "exception")
    public void logException(JoinPoint thisJoinPoint, Exception exception) {
        LOGGER.info("ERROR " + thisJoinPoint + " -> exception = " + exception);
    }
}