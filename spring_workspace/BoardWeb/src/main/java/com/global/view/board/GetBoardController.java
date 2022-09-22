package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;



//@Controller
public class GetBoardController {

	//@RequestMapping("/getboard.do")
	public ModelAndView getBoard( BoardVO vo, BoardDAO boardDAO,  ModelAndView mav) {
		System.out.println("글 상세 조회처리");
//String seq = request.getParameter("seq");
		   
		   // 2.DB 연동 처리
//		   BoardVO vo = new BoardVO();
//		   vo.setSeq(Integer.parseInt(seq));
//		   
//		   BoardDAO boardDAO = new BoardDAO();
//		   BoardVO board = boardDAO.getBoard(vo);
//		   
////		    HttpSession session = request.getSession();
////		    session.setAttribute("board", board);
//		   ModelAndView mav = new ModelAndView();
//		    
		    mav.addObject("board", boardDAO.getBoard(vo));//Model 정보를 저장
		    mav.setViewName("getboard.jsp");//View  정보를 저장 
		    
		    return mav;
		   
		 
	}

}
