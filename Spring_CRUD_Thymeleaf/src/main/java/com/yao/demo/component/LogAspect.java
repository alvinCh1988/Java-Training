package com.yao.demo.component;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* com.yao.demo.*.*.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {

		String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		logger.info("classMethod : {} , args : {}", classMethod, joinPoint.getArgs());
	};

	@AfterReturning(returning = "result", pointcut = "log()")
	public void doAtferReturning(Object result) {
		logger.info("Return : {}", result);
	}

}
