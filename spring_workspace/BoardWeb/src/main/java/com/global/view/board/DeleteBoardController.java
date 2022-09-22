package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController {

	//@RequestMapping("/deleteBoard.do")
	public String deleteBoard( BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
//		String seq=request.getParameter("seq");
//
//		   //DB연동
//		   BoardVO vo = new BoardVO();
//		   vo.setSeq(Integer.parseInt(seq));
//		   
//		   BoardDAO boardDAO = new BoardDAO();
      	   boardDAO.deleteBoard(vo);
//		   
//		   //화면 응답
//		   ModelAndView mav = new ModelAndView();
//
//		    mav.setViewName("redirect:getBoardList.do");//View  정보를 저장 
//		    
//		    return mav;
		
		 	return "getBoardList.do";
	}

}
