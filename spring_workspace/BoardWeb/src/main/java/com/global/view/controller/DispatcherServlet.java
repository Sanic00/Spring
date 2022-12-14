package com.global.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;


@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
    public DispatcherServlet() {
        super();
    }
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    		handlerMapping = new HandlerMapping();
    		viewResolver = new ViewResolver();
    		viewResolver.setPrefix("./");
    		viewResolver.setSuffix(".jsp");
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 클라이언트의 요청 path 정보를 추출함
		String uri =  request.getRequestURI(); // <---BoardWeb/ 임 
		String path = uri.substring(uri.lastIndexOf("/")); //문자열 추출 
		System.out.println(path);

		//(MVC2)2. 클라이언트 요청에 path에 따라 적절히 분기처리한다.
		//(MVC FrameWork) 2. HandlerMapping 을 통해  path에 해당하는 Controller를 검색함
		Controller ctrl = handlerMapping.getController(path);
		
		//(MVC FrameWork)3. 검색 된  Controller 를 실행함
		String viewName= ctrl.handleRequest(request, response);
		
		//(MVC FrameWork)4. ViewResolver를 통해서 viewName에 해당하는 화면을 검색함
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		
		}else {
			view= viewName;
		}
				
		//(MVC FrameWork)5. 검색된 화면으로 이동한다.
		response.sendRedirect(view);
		
		/*
		if(path.equals("/login.do")) {
			System.out.println("로그인처리");
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
				response.sendRedirect("getBoardList.do");
			}else { //안맞으면 로그인 폼으로 보냄
				response.sendRedirect("login.jsp");
			}
			
			
			
			
			
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			 HttpSession session = request.getSession();
		    session.invalidate();
		    
		    response.sendRedirect("login.jsp");
		    
		    
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			String title=request.getParameter("title");
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");

			//DB연동
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			//화면 응답
			response.sendRedirect("getBoardList.do");

			
			
			
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			String title=request.getParameter("title");
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");

			//DB연동
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			//화면 응답
			response.sendRedirect("getBoardList.do");

		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			String seq=request.getParameter("seq");

			   //DB연동
			   BoardVO vo = new BoardVO();
			   vo.setSeq(Integer.parseInt(seq));
			   
			   BoardDAO boardDAO = new BoardDAO();
			   boardDAO.deleteBoard(vo);
			   
			   //화면 응답
			   response.sendRedirect("getBoardList.do");
			   
		}else if(path.equals("/getboard.do")) {
			System.out.println("글 상세 조회처리");
			String seq = request.getParameter("seq");
			   
			   // 2.DB 연동 처리
			   BoardVO vo = new BoardVO();
			   vo.setSeq(Integer.parseInt(seq));
			   
			   BoardDAO boardDAO = new BoardDAO();
			   BoardVO board = boardDAO.getBoard(vo);
			   
			    HttpSession session = request.getSession();
			    session.setAttribute("board", board);
			   response.sendRedirect("getboard.jsp");
			   
			   
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 조회 처리");
			
		    BoardVO vo = new BoardVO();
		    BoardDAO dao = new BoardDAO();
		    List<BoardVO>boardList = dao.getBoardList(vo);
		    
		    //검색된 결과를 세션에 저장하고 글 목록 화면으로 이동 시켜줌
		   //세션 객체 만들고 요청 
		    HttpSession session = request.getSession();
		    
		    session.setAttribute("boardList", boardList);
		   
		   response.sendRedirect("getBoardList.jsp");
		    
		   
		   
		}
		*/
	}
}
