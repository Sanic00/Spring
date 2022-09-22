package com.global.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	//나눠져있는 Controller들을 합친것들임
	
	@Autowired   //자동주입
	private BoardService boardService; //교체를 위해 ?
	
	
	//글 등록 
	@RequestMapping(value = "/insertBoard.do")
	public  String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
	
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard (@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 처리");
		boardService.updateBoard(vo);
	    
		return "getBoardList.do";
	}
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard( BoardVO vo) {
	System.out.println("글 삭제 처리");
	boardService.deleteBoard(vo);
		 
	return "getBoardList.do";
	}
	
//	@RequestMapping("/getboard.do")
//	public String getBoard( BoardVO vo, BoardDAO boardDAO, Model model) {
//		System.out.println("글 상세 조회처리");
//		  model.addAttribute("board", boardDAO.getBoard(vo));//Model 정보를 저장
//		
//		    
//		    return "getboard.jsp"; //View의 이름을 리턴함
//	}
//	
	
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(
//		@RequestParam(value="searchCondition" , defaultValue = "TITLE", required = false) String condition ,
//		@RequestParam(value="searchKeyword" , defaultValue = "", required = false) String keyword
//		,BoardVO vo, BoardDAO boardDAO, Model model ) {
//		
//		System.out.println("글 목록 조회 처리");
//		System.out.println("검색 조건 :" +condition);
//		System.out.println("검색 키워드 :" +keyword);
//		//검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
////		 model.addAttribute("boardList", boardDAO.getBoardList(vo));//Model 정보를 저장
//		 
//		 	
//		 return "getBoardList.jsp"; //View의 이름을 리턴함
//	   
//		   }
			
		
	
	
	
	// 글 상세 조회
	
	/*
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
	 */

	//검색  
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		//검색 조건 목록 설정
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	
	
	@RequestMapping("/getboard.do")
	public String getBoard( BoardVO vo,  Model model ) {
	System.out.println("글 상세 조회처리");
	model.addAttribute("board", boardService.getBoardList(vo));
	   
	    
	    return "getboard.jsp";
}


	// 글 목록 조회
		@RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo,  Model model ) {
			
		System.out.println("글 목록 조회 처리");
			model.addAttribute("boardList", boardService.getBoardList(vo));//Model 정보를 저장
			
		   
			    return "getBoardList.jsp";
		}		
}
