package org.softuni.mobilele.services.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* org.softuni.mobilele.services.OfferService.getAllOffers(..))")
    public void trackOfferSearch() {}

    @Pointcut("@annotation(WarnIfExecutionExceeds)")
    public void warnIfExecutionExceeds() {}
}
