package com.global.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.global.biz.board.BoardService;

public class UserServiceClient {

	public static void main(String[] args) {
			
		//1.Spring Container 援щ����湲� 
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.Spring 而⑦���대��濡� 遺��� 媛�泥�  (UserServiceImpl)瑜� ��泥���湲� -->(Lookup)�대�쇨� ����.
		UserService  userservice = (UserService)container.getBean("userService");
		
		//3.濡�洹몄�� 湲곕�� ���ㅽ��
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userservice.getUser(vo);
		if(user != null) {
			System.out.println(user.getName()+"");
		}else {
			System.out.println("");
		}
		
		
		//4.Spring 而⑦���대�� 醫�猷�
		container.close();
	}

}
