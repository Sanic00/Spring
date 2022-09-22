package com.global.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardListController{

//	@Override
	//@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav ) {
		
		System.out.println("글 목록 조회 처리");
//		
//	    BoardVO vo = new BoardVO();
//	    BoardDAO boardDAO = new BoardDAO();
//	    List<BoardVO>boardList = dao.getBoardList(vo);
//	    
	    //검색된 결과를 세션에 저장하고 글 목록 화면으로 이동 시켜줌
	   //세션 객체 만들고 요청 
//	    HttpSession session = request.getSession();
//	    
//	    session.setAttribute("boardList", boardList);
	    
	    
//	    //검색 결과와 화면 정보를  ModelAndView에 저장하여 리턴함
//	    ModelAndView mav = new ModelAndView();
//	    
	    mav.addObject("boardList", boardDAO.getBoardList(vo));//Model 정보를 저장
	    mav.setViewName("getBoardList.jsp");//View  정보를 저장 
   
		
	    return mav;
		
		
	}

}
