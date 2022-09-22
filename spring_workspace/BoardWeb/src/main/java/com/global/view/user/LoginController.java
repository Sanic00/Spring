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
	
	//얘는 get방식임 post 방식이 아님 밑에꺼가 post 방식임
	@RequestMapping(value="/login.do", method= RequestMethod.GET)
	public String loginView(@ModelAttribute("user")  UserVO vo) {
		
		System.out.println("로그인 화면으로 이동");	
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
		
	}
	
	

	@RequestMapping(value="/login.do" , method= RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		System.out.println("로그인처리");
		
		UserVO user = userDAO.getUser(vo);
//		String id = request.getParameter("id");
//		String password =request.getParameter("password");
//		
//    	//2.데이터 베이스 연동처리 
//    	UserVO vo = new UserVO();
//    	vo.setId(id);
//    	vo.setPassword(password);
//    	
//    	UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);    
//    	
//		 ModelAndView mav = new ModelAndView();
//		 
		//3.화면 네비게이션
		if(user != null){ //로그인 성공시 
//		mav.setViewName("redirect:getBoardList.do");
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else { //안맞으면 로그인 폼으로 보냄
			return "login.jsp";
		}
	}

}
