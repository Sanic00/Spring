package com.global.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회처리");
		String seq = request.getParameter("seq");
		   
		   // 2.DB 연동 처리
		   BoardVO vo = new BoardVO();
		   vo.setSeq(Integer.parseInt(seq));
		   
		   BoardDAO boardDAO = new BoardDAO();
		   BoardVO board = boardDAO.getBoard(vo);
		   
		    HttpSession session = request.getSession();
		    session.setAttribute("board", board);
		   
		   return "getboard";
	}

}
