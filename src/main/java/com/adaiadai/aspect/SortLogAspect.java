package com.adaiadai.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Async
@Component
public class SortLogAspect {

    @Around("@annotation(com.adaiadai.aspect.SortLog)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

    }

}
