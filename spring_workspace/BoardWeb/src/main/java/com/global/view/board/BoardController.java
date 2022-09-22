package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	//�������ִ� Controller���� ��ģ�͵���
	
	//�� ��� 
	@RequestMapping(value = "/insertBoard.do")
	public  String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
	
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	// �� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard (BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		boardDAO.updateBoard(vo);
	    
		return "getBoardList.do";
	}
	// �� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard( BoardVO vo, BoardDAO boardDAO) {
	System.out.println("�� ���� ó��");
	boardDAO.deleteBoard(vo);
		 
	return "getBoardList.do";
	}
	// �� �� ��ȸ

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
}