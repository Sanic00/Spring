package com.global.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//외부로 만들어서 사용하는 방법임
@Aspect
public class PoincutCommon {

	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
}
