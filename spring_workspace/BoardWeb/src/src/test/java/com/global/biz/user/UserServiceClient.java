package com.global.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.global.biz.board.BoardService;

public class UserServiceClient {

	public static void main(String[] args) {
			
		//1.Spring Container ������
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.Spring �����̳ʷκ��� ��ü�� ��û UserServiceImpl���� ��ü�� ��û��(Lookup)
		UserService  userservice = (UserService)container.getBean("userService");
		
		//3.�α��� ��� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userservice.getUser(vo);
		if(user != null) {
			System.out.println(user.getName()+"�� ȯ��");
		}else {
			System.out.println("�α��� ���� ȸ������ �ϼ���");
		}
		
		
		//4.Spring �����̳� ����
		container.close();
	}

}
