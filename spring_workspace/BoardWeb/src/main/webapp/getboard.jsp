<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
    
<%--        <%@ page import="com.global.biz.board.impl.BoardDAO" %>
     <%@ page import="com.global.biz.board.BoardVO" %>
    --%>
   
  <%--  <%
   // 1.검색할  게시글 번호를 추출한다.
   String seq = request.getParameter("seq");
   
   // 2.DB 연동 처리
   BoardVO vo = new BoardVO();
   vo.setSeq(Integer.parseInt(seq));
   
   BoardDAO boardDAO = new BoardDAO();
   BoardVO board = boardDAO.getBoard(vo);
   
   //응답하면 구성
   %> --%>

  <%--   <%
    // 세션에 저장된 게시글에 정보를 얻어온다.
    BoardVO board = (BoardVO)session.getAttribute("board");
    %> --%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 정보</title>
</head>
<body>
<div align="center">
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${board.seq }">	<!--글 번호는 숨겨서 와야된다? -->
		<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title" value="${board.title }"></td>
				</tr>
				
				<tr>
					<td bgcolor="orange">작성자</td>
				    <td align="left">${board.writer }</td>
				</tr>
				
				<tr>
					<td bgcolor="orange">내용</td>
				    <td align="left"><textarea rows="10" cols="40" name="content">${board.content }</textarea></td>
				</tr>
				
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.regDate }</td>
				</tr>
				
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left">${board.cnt }</td>
				</tr>
				
				<tr>
					 <td colspan="2" align="center"><input type="submit" value="글수정"></td>
				</tr>

		</table>
	</form>
	<hr>
	<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=${board.seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글 목록</a>	
</div>

</body>
</html>