package com.global.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.global.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
		
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@AfterReturning(pointcut ="getPointcut()", returning ="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName()+"로그인(Admin)");
			}
		
		}
		System.out.println("[사후처리] " +method+"()메소드 리턴 값:"+returnObj.toString());
	}
}