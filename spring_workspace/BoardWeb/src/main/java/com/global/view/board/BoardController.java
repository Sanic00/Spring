package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	//나눠져있는 Controller들을 합친것들임
	
	//글 등록 
	@RequestMapping(value = "/insertBoard.do")
	public  String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
	
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard (BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		boardDAO.updateBoard(vo);
	    
		return "getBoardList.do";
	}
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard( BoardVO vo, BoardDAO boardDAO) {
	System.out.println("글 삭제 처리");
	boardDAO.deleteBoard(vo);
		 
	return "getBoardList.do";
	}
	// 글 상세 조회

	@RequestMapping("/getboard.do")
	public ModelAndView getBoard( BoardVO vo, BoardDAO boardDAO,  ModelAndView mav) {
		System.out.println("글 상세 조회처리");
		  mav.addObject("board", boardDAO.getBoard(vo));//Model 정보를 저장
		    mav.setViewName("getboard.jsp");//View  정보를 저장 
		    
		    return mav;
	}
	// 글 목록 조회
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav ) {
		
		System.out.println("글 목록 조회 처리");
		 mav.addObject("boardList", boardDAO.getBoardList(vo));//Model 정보를 저장
		    mav.setViewName("getBoardList.jsp");//View  정보를 저장 
	   
		    return mav;
			
		}
}
