package com.global.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("�� ��� ��ȸ ó��");
		
	    BoardVO vo = new BoardVO();
	    BoardDAO dao = new BoardDAO();
	    List<BoardVO>boardList = dao.getBoardList(vo);
	    
	    //�˻��� ����� ���ǿ� �����ϰ� �� ��� ȭ������ �̵� ������
	   //���� ��ü ����� ��û 
	    HttpSession session = request.getSession();
	    
	    session.setAttribute("boardList", boardList);
	   
	    return "getBoardList";
		
		
	}

}
