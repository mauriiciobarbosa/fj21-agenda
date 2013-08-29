<%@page import="java.util.List"%>
<%@page import="com.caelum.jdbc.MysqlConnection"%>
<%@page import="com.caelum.jdbc.model.Contato"%>
<%@page import="com.caelum.jdbc.dao.ContatoDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de Contato</title>
	</head>
	<body>
		<table>
			<tr>
				<td>NOME</td>
				<td>E-MAIL</td>
				<td>ENDEREÇO</td>
				<td>DATA DE NASCIMENTO</td>
			</tr>
			<%
				Connection connection = new MysqlConnection().getConnection("localhost",
																			"fj21",
																			"mbarbosa",
																			"h8hzvaxk19");
				ContatoDao contatoDao = new ContatoDao(connection);
				List<Contato> contatos = contatoDao.getList();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				
				for (Contato contato : contatos) {
			%>
				
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=formato.format(contato.getDataNascimento().getTime()) %></td>
			</tr>
				
			<%
				}
			%>
		</table>
	</body>
</html>