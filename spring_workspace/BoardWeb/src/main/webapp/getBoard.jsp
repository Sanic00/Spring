<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� �� ����</title>
</head>
<body>
<div align="center">
<form action="updateBoard.do" method="post">
<input type="hidden" name="seq" value="${board.seq}">
<table border="1" cellpadding="0" cellspacing="0">

    <tr>
         <td bgcolor="orange" width="70">����</td>
         <td align="left">
         <input type="text" name="title" value="${board.title}"></td>
    </tr>

    <tr>
          <td bgcolor="orange">�ۼ���</td>
         <td align="left">${board.writer} </td>
    </tr>

    <tr>
         <td bgcolor="orange">����</td>
         <td align="left">
         <textarea rows="10" cols="40" name="content">${board.content}</textarea>
        </td>
    </tr>
    
    <tr>
         <td bgcolor="orange">�����</td>
         <td align="left">${board.regDate}</td>
    </tr>
     <tr>
         <td bgcolor="orange">��ȸ��</td>
         <td align="left">${board.cnt}</td>
    </tr>
    
    <tr>
       <td colspan="2" align="center">
       <input type="submit" value="�ۼ���"></td>
    </tr>
   </table>
</form>
<hr>
<a href="insertBoard.jsp">�۵��</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq}">�ۻ���</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">�۸��</a>
</div>



</body>
</html>