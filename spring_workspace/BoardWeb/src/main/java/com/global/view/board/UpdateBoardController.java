package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;


//@Controller
public class UpdateBoardController {

	//@RequestMapping("/updateBoard.do")
	public String updateBoard (BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
//		String title=request.getParameter("title");
//		String writer=request.getParameter("writer");
//		String content=request.getParameter("content");
//		String seq = request.getParameter("seq");
//
//		//DB연동
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setSeq(Integer.parseInt(seq));
//
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//
//		ModelAndView mav = new ModelAndView();
//
//	    mav.setViewName("redirect:getBoardList.do");//View  정보를 저장 
		boardDAO.updateBoard(vo);
	    
		return "getBoardList.do";
	}

}
