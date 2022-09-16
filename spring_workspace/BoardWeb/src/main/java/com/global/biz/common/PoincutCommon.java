package com.global.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//�ܺη� ���� ����ϴ� �����
@Aspect
public class PoincutCommon {

	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
}
