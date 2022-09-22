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
		
		System.out.println("�� ��� ��ȸ ó��");
//		
//	    BoardVO vo = new BoardVO();
//	    BoardDAO boardDAO = new BoardDAO();
//	    List<BoardVO>boardList = dao.getBoardList(vo);
//	    
	    //�˻��� ����� ���ǿ� �����ϰ� �� ��� ȭ������ �̵� ������
	   //���� ��ü ����� ��û 
//	    HttpSession session = request.getSession();
//	    
//	    session.setAttribute("boardList", boardList);
	    
	    
//	    //�˻� ����� ȭ�� ������  ModelAndView�� �����Ͽ� ������
//	    ModelAndView mav = new ModelAndView();
//	    
	    mav.addObject("boardList", boardDAO.getBoardList(vo));//Model ������ ����
	    mav.setViewName("getBoardList.jsp");//View  ������ ���� 
   
		
	    return mav;
		
		
	}

}
