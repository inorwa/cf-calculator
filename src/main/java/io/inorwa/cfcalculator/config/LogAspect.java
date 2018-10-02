package io.inorwa.cfcalculator.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class LogAspect {

	@Autowired(required=true)
	private HttpServletRequest request;

	@Around("within(@org.springframework.web.bind.annotation.RestController *)")
	public Object restControllerPointCut(ProceedingJoinPoint joinPoint) throws Throwable{
		log.info("Before: " + joinPoint.getSignature().getName() + " from " + request.getRemoteAddr());
		log.info(joinPoint.getArgs().toString());
		Object returnValue = null;
		if(joinPoint.getArgs().length > 0){
			returnValue = joinPoint.proceed(joinPoint.getArgs());
		}else {
			returnValue = joinPoint.proceed();
		}
		log.info("After: " + joinPoint.getSignature().getName());
		return returnValue;
	}


}
