package com.global.biz.board.impl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.global.biz.board.BoardVO;
import com.global.biz.common.JDBCUtil;

import java.sql.Connection;

//저장소
@Repository
public class BoardDAO {

	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL명령어들
	private final String BOARD_INSERT=
			"insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE="update board set title=?, content=? where seq=?"; 
	private final String BOARD_DELETE="delete board where seq=?";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_LIST="select * from board order by seq desc";
	
	//CRUD 기능의 메소드를 구현
	// 글을 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>JDBC로 insertBoard()기능 처리 합니다....");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===>JDBC로 updateBoard()기능 처리 합니다....");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	//글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>JDBC로 deleteBoard()기능 처리 합니다....");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	//글 상세조회
		public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>JDBC로 getBoard()기능 처리 합니다....");
		BoardVO board = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				//조회
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setCnt(rs.getInt("CNT"));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		return board;
	}
	//글 목록 조회
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("===>JDBC로 getBoardList()기능 처리 합니다....");
			List<BoardVO>boardList = new ArrayList<BoardVO>();
			
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_LIST);
				
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					//조회
				BoardVO  board = new BoardVO();
					board.setSeq(rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setCnt(rs.getInt("CNT"));
					boardList.add(board);
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs,stmt, conn);
			}
			return boardList;
		}
		
}
