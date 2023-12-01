package org.softuni.mobilele.services.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softuni.mobilele.services.MonitoringService;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Aspect
@Component
public class MonitoringAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(MonitoringAspect.class);

    private final MonitoringService monitoringService;

    public MonitoringAspect(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @Before("PointCuts.trackOfferSearch()")
    public void logOfferSearch() {
        monitoringService.logOfferSearch();
    }

    @Around("PointCuts.warnIfExecutionExceeds()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        WarnIfExecutionExceeds annotation = getAnnotation(proceedingJoinPoint);

        long timeout = annotation.timeInMillis();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object returnValue = proceedingJoinPoint.proceed();

        stopWatch.stop();

        if (stopWatch.getLastTaskTimeMillis() > timeout) {
            LOGGER.warn(
                    "The method {} ran for {} millis which is more than the expected {} millis.",
                    proceedingJoinPoint.getSignature(),
                    stopWatch.getLastTaskTimeMillis(),
                    timeout
            );
        }

        return returnValue;
    }

    private static WarnIfExecutionExceeds getAnnotation(ProceedingJoinPoint proceedingJoinPoint) {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();

        try {
            return proceedingJoinPoint
                    .getTarget()
                    .getClass()
                    .getMethod(method.getName(), method.getParameterTypes())
                    .getAnnotation(WarnIfExecutionExceeds.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
