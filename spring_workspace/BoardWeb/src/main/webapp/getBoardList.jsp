<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ page import="com.global.biz.board.impl.BoardDAO" %>
     <%@ page import="com.global.biz.board.BoardVO" %>
     <%@ page import="java.util.List" %>
     
     <%
     //DB연동 처리 
     BoardVO vo = new BoardVO();
     BoardDAO dao = new BoardDAO();
     List<BoardVO>boardList = dao.getBoardList(vo);
     
     //응답화면 구성
     
     %>
    
    
    
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
			테스트님 환영합니다....<a href="logout_proc.jsp">Log-Out</a>
		</h3>	
		
		<form action="getBoardList.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
					<tr>
						<td align="right">
								<select name="searchCondition">
										<option value="TITLE">제목</option>
										<option value="CONTENT">내용</option>
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
			<%
				for(BoardVO board : boardList){
					
			%>		
				<tr>
					<td><%=board.getSeq() %></td>
					<td align="left"><a href="getboard.jsp?seq=<%=board.getSeq()%>">
					<%=board.getTitle() %></a></td>
					<td><%=board.getWriter() %></td>
					<td><%=board.getRegDate() %></td>
					<td><%=board.getCnt() %></td>
				</tr>
			<%
				}
			%>		
	</table>
	<br>
	<a href="insertBoard.jsp">새 글 등록</a>
	</div>
</body>
</html>