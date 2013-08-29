<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%-- Minha primeira página em JSP --%>
	
		<% 
			String mensagem = "Bem vindo ao sistema de agenda da FJ-21!"; 
			String desenvolvedor = "Mauricio Barbosa";
			
			out.println(mensagem);
		%>
		
		<br />
		
		<%
			out.println("Desenvolvido por " + desenvolvedor);
			
			System.out.println("Tudo foi executado");
		%>
		
	</body>
</html>