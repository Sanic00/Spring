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
	//�������ִ� Controller���� ��ģ�͵���
	
	@Autowired   //�ڵ�����
	private BoardService boardService; //��ü�� ���� ?
	
	
	//�� ��� 
	@RequestMapping(value = "/insertBoard.do")
	public  String insertBoard(BoardVO vo) {
		System.out.println("�� ��� ó��");
	
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	// �� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard (@ModelAttribute("board") BoardVO vo) {
		System.out.println("�� ���� ó��");
		boardService.updateBoard(vo);
	    
		return "getBoardList.do";
	}
	// �� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard( BoardVO vo) {
	System.out.println("�� ���� ó��");
	boardService.deleteBoard(vo);
		 
	return "getBoardList.do";
	}
	
//	@RequestMapping("/getboard.do")
//	public String getBoard( BoardVO vo, BoardDAO boardDAO, Model model) {
//		System.out.println("�� �� ��ȸó��");
//		  model.addAttribute("board", boardDAO.getBoard(vo));//Model ������ ����
//		
//		    
//		    return "getboard.jsp"; //View�� �̸��� ������
//	}
//	
	
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(
//		@RequestParam(value="searchCondition" , defaultValue = "TITLE", required = false) String condition ,
//		@RequestParam(value="searchKeyword" , defaultValue = "", required = false) String keyword
//		,BoardVO vo, BoardDAO boardDAO, Model model ) {
//		
//		System.out.println("�� ��� ��ȸ ó��");
//		System.out.println("�˻� ���� :" +condition);
//		System.out.println("�˻� Ű���� :" +keyword);
//		//�˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
////		 model.addAttribute("boardList", boardDAO.getBoardList(vo));//Model ������ ����
//		 
//		 	
//		 return "getBoardList.jsp"; //View�� �̸��� ������
//	   
//		   }
			
		
	
	
	
	// �� �� ��ȸ
	
	/*
	@RequestMapping("/getboard.do")
	public ModelAndView getBoard( BoardVO vo, BoardDAO boardDAO,  ModelAndView mav) {
		System.out.println("�� �� ��ȸó��");
		  mav.addObject("board", boardDAO.getBoard(vo));//Model ������ ����
		    mav.setViewName("getboard.jsp");//View  ������ ���� 
		    
		    return mav;
	}
	// �� ��� ��ȸ
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav ) {
		
		System.out.println("�� ��� ��ȸ ó��");
		 mav.addObject("boardList", boardDAO.getBoardList(vo));//Model ������ ����
		    mav.setViewName("getBoardList.jsp");//View  ������ ���� 
	   
		    return mav;
			
		}
	 */

	//�˻�  
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		//�˻� ���� ��� ����
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		
		return conditionMap;
	}
	
	
	
	@RequestMapping("/getboard.do")
	public String getBoard( BoardVO vo,  Model model ) {
	System.out.println("�� �� ��ȸó��");
	model.addAttribute("board", boardService.getBoardList(vo));
	   
	    
	    return "getboard.jsp";
}


	// �� ��� ��ȸ
		@RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo,  Model model ) {
			
		System.out.println("�� ��� ��ȸ ó��");
			model.addAttribute("boardList", boardService.getBoardList(vo));//Model ������ ����
			
		   
			    return "getBoardList.jsp";
		}		
}
