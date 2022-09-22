package com.global.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	
	//��� get����� post ����� �ƴ� �ؿ����� post �����
	@RequestMapping(value="/login.do", method= RequestMethod.GET)
	public String loginView(@ModelAttribute("user")  UserVO vo) {
		
		System.out.println("�α��� ȭ������ �̵�");	
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
		
	}
	
	

	@RequestMapping(value="/login.do" , method= RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		System.out.println("�α���ó��");
		
		UserVO user = userDAO.getUser(vo);
//		String id = request.getParameter("id");
//		String password =request.getParameter("password");
//		
//    	//2.������ ���̽� ����ó�� 
//    	UserVO vo = new UserVO();
//    	vo.setId(id);
//    	vo.setPassword(password);
//    	
//    	UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);    
//    	
//		 ModelAndView mav = new ModelAndView();
//		 
		//3.ȭ�� �׺���̼�
		if(user != null){ //�α��� ������ 
//		mav.setViewName("redirect:getBoardList.do");
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else { //�ȸ����� �α��� ������ ����
			return "login.jsp";
		}
	}

}
