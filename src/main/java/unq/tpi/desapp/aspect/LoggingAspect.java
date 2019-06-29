package unq.tpi.desapp.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final static Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* unq.tpi.desapp.webservice..*(..))")
    private void loggingTargets() {}

    @Before("loggingTargets()")
    public void logEnterMethod(JoinPoint thisJoinPoint) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ObjectMapper objectMapper = new ObjectMapper();
        LOGGER.info("USER: " + username + " ENTER " + thisJoinPoint);
        try {
            LOGGER.info("WITH ARGS: " + objectMapper.writeValueAsString(thisJoinPoint.getArgs()));
        } catch (JsonProcessingException e) {
            LOGGER.warn("error while logging args", e);
        }
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