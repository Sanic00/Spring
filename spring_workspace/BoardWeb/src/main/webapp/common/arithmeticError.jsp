<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="#ffffff" text="#000000">
<table width="100%" border="1" cellpadding="0" cellspacing="0">
  <tr>
               <td align="center"><b>�⺻ ���� ȭ���Դϴ�.</b></td>  
  </tr>
</table>
<br>

<table width="100%" border="1" cellpadding="0" cellspacing="0" align="center">
      <tr>
           <td align="center">
           <br>
           Message : ${exception.message}
           <br><br><br><br>
           </td>
      </tr>
</table>

</body>
</html>