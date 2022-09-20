<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--     	<%@page import="com.global.biz.user.UserVO" %>
    	<%@page import="com.global.biz.user.impl.UserDAO" %>
    	
    	<%
		//1.사용자의 정보를 추출
		String id = request.getParameter("id");
		String password =request.getParameter("password");
		
    	//2.데이터 베이스 연동처리 
    	UserVO vo = new UserVO();
    	vo.setId(id);
    	vo.setPassword(password);
    	
    	UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);    
    	
		//3.화면 네비게이션
		if(user != null){ //로그인 성공시 
			response.sendRedirect("getBoardList.jsp");
		}else { //안맞으면 로그인 폼으로 보냄
			response.sendRedirect("login.jsp");
		}
		
    	%>
    	 --%>