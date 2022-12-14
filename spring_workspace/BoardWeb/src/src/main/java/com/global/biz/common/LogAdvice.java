package com.global.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import jdk.nashorn.internal.runtime.logging.Logger;

@Service
@Aspect // Aspect= Pointcut + Advice 합쳐진거임
public class LogAdvice {
	
	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	/*
	 * @Pointcut("execution(* com.global.biz..*Impl.get*(..))") public void
	 * getPointcut() {}
	 */
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전에 동작....");
	}
	
}
