<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
    
<%--      <%@ page import="com.global.biz.board.impl.BoardDAO" %>
     <%@ page import="com.global.biz.board.BoardVO" %>
     <%@ page import="java.util.List" %> --%>
     
<%--      <%
     //DB연동 처리 
     BoardVO vo = new BoardVO();
     BoardDAO dao = new BoardDAO();
     List<BoardVO>boardList = dao.getBoardList(vo);
     //응답화면 구성
     %>
     --%>
  <%--   
    <%
    //세션에 저장 된 글  목록을 얻어온다.
    	List<BoardVO>boardList = (List)session.getAttribute("boardList");
    %>
     --%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<div align="center">
		<h1>글 목록</h1>
		<h3>
		   게시판에 오신 ${userName}님 환영합니다....<a href="logout.do">Log-Out</a>
		</h3>	
		
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
					<tr>
						<td align="right">
								<select name="searchCondition">
									<!-- 	<option value="TITLE">제목</option>
										<option value="CONTENT">내용</option> -->
										<c:forEach var="option" items="${conditionMap}">
												<option value="${option.value }">${option.key }
										</c:forEach>
								</select>
								<input name="searchKeyword" type="text"></input>
								<input value="검색" type="submit"></input>								
						</td>
					</tr>
			</table>
		</form>
		
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			  <th bgcolor="orange" width="100">번호</th>
			  <th bgcolor="orange" width="200">제목</th>
			  <th bgcolor="orange" width="150">작성자</th>
			  <th bgcolor="orange" width="150">등록일</th>
			  <th bgcolor="orange" width="100">조회수</th>
		</tr>
	
			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>${board.seq}</td>
					<td align="left"><a href="getboard.do?seq=${board.seq}">
					${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
				</c:forEach>
		
	</table>
	<br>
	<a href="insertBoard.jsp">새 글 등록</a>
	</div>
</body>
</html>