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
		
		System.out.println("글 목록 조회 처리");
		
	    BoardVO vo = new BoardVO();
	    BoardDAO dao = new BoardDAO();
	    List<BoardVO>boardList = dao.getBoardList(vo);
	    
	    //검색된 결과를 세션에 저장하고 글 목록 화면으로 이동 시켜줌
	   //세션 객체 만들고 요청 
	    HttpSession session = request.getSession();
	    
	    session.setAttribute("boardList", boardList);
	   
	    return "getBoardList";
		
		
	}

}
