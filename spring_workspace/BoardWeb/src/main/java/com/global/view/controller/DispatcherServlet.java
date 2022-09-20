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
		
		//1. Ŭ���̾�Ʈ�� ��û path ������ ������
		String uri =  request.getRequestURI(); // <---BoardWeb/ �� 
		String path = uri.substring(uri.lastIndexOf("/")); //���ڿ� ���� 
		System.out.println(path);

		//(MVC2)2. Ŭ���̾�Ʈ ��û�� path�� ���� ������ �б�ó���Ѵ�.
		//(MVC FrameWork) 2. HandlerMapping �� ����  path�� �ش��ϴ� Controller�� �˻���
		Controller ctrl = handlerMapping.getController(path);
		
		//(MVC FrameWork)3. �˻� ��  Controller �� ������
		String viewName= ctrl.handleRequest(request, response);
		
		//(MVC FrameWork)4. ViewResolver�� ���ؼ� viewName�� �ش��ϴ� ȭ���� �˻���
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		
		}else {
			view= viewName;
		}
				
		//(MVC FrameWork)5. �˻��� ȭ������ �̵��Ѵ�.
		response.sendRedirect(view);
		
		/*
		if(path.equals("/login.do")) {
			System.out.println("�α���ó��");
			String id = request.getParameter("id");
			String password =request.getParameter("password");
			
	    	//2.������ ���̽� ����ó�� 
	    	UserVO vo = new UserVO();
	    	vo.setId(id);
	    	vo.setPassword(password);
	    	
	    	UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);    
	    	
			//3.ȭ�� �׺���̼�
			if(user != null){ //�α��� ������ 
				response.sendRedirect("getBoardList.do");
			}else { //�ȸ����� �α��� ������ ����
				response.sendRedirect("login.jsp");
			}
			
			
			
			
			
		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			 HttpSession session = request.getSession();
		    session.invalidate();
		    
		    response.sendRedirect("login.jsp");
		    
		    
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			String title=request.getParameter("title");
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");

			//DB����
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			//ȭ�� ����
			response.sendRedirect("getBoardList.do");

			
			
			
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			String title=request.getParameter("title");
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");

			//DB����
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);

			//ȭ�� ����
			response.sendRedirect("getBoardList.do");

		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			String seq=request.getParameter("seq");

			   //DB����
			   BoardVO vo = new BoardVO();
			   vo.setSeq(Integer.parseInt(seq));
			   
			   BoardDAO boardDAO = new BoardDAO();
			   boardDAO.deleteBoard(vo);
			   
			   //ȭ�� ����
			   response.sendRedirect("getBoardList.do");
			   
		}else if(path.equals("/getboard.do")) {
			System.out.println("�� �� ��ȸó��");
			String seq = request.getParameter("seq");
			   
			   // 2.DB ���� ó��
			   BoardVO vo = new BoardVO();
			   vo.setSeq(Integer.parseInt(seq));
			   
			   BoardDAO boardDAO = new BoardDAO();
			   BoardVO board = boardDAO.getBoard(vo);
			   
			    HttpSession session = request.getSession();
			    session.setAttribute("board", board);
			   response.sendRedirect("getboard.jsp");
			   
			   
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� ��ȸ ó��");
			
		    BoardVO vo = new BoardVO();
		    BoardDAO dao = new BoardDAO();
		    List<BoardVO>boardList = dao.getBoardList(vo);
		    
		    //�˻��� ����� ���ǿ� �����ϰ� �� ��� ȭ������ �̵� ������
		   //���� ��ü ����� ��û 
		    HttpSession session = request.getSession();
		    
		    session.setAttribute("boardList", boardList);
		   
		   response.sendRedirect("getBoardList.jsp");
		    
		   
		   
		}
		*/
	}
}
