package com.global.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdivice {

	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing(pointcut ="allPointcut()", throwing ="exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		
		String method = jp.getSignature().getName();
		
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("�������� ���� �Է� �Ǿ����ϴ�.");
		}else if(exceptionObj instanceof NumberFormatException) {
			System.out.println("���������� �ƴ� ���� �ԷµǾ����ϴ�.");
		}else if(exceptionObj instanceof Exception) {
			System.out.println("������ ����� �߻��߽��ϴ�.");
		}
		
		
		
		
		System.out.println("[����ó��]"+method+"()�޼ҵ� ������ �߻��� ���� �޽���:"+exceptionObj.getMessage());
	}
}