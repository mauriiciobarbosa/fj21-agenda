<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- Cria a lista --%>
<jsp:useBean id="dao" class="com.caelum.jdbc.dao.ContatoDao" ></jsp:useBean>
<jsp:useBean id="formato" class="java.text.SimpleDateFormat" ></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de Contatos</title>
	</head>
	<body>
		
		<c:import url="cabecalho.jsp" />
	
		<table border="1" bgcolor="#eeeeee">
			<tr>
				<td>NOME</td>
				<td>E-MAIL</td>
				<td>ENDEREÇO</td>
				<td>DATA DE NASCIMENTO</td>
				<td>AÇÃO</td>
			</tr>
			<%-- Percorre os contatos montando as linhas da tabela --%>
			<c:forEach var="contato" items="${dao.list}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td><c:out value="${contato.nome}" /></td>
					<td>
						<c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}"><c:out value="${contato.email}" /></a>
							</c:when>
							<c:otherwise>
								<c:out value="E-mail não confirmado" />
							</c:otherwise>
						</c:choose>
					</td>
					<td><c:out value="${contato.endereco}" /></td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<a href="altera-contato.jsp?id=${contato.id}&nome=${contato.nome}&email=${contato.email}&end=${contato.endereco}&nasc=<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>">
							<input type="button" value="Alterar" /></a>
						<a href="mvc?logica=RemoveContato&id=${contato.id}">
							<input type="button" value="Remover" />
						</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:import url="rodape.jsp" />
	</body>
</html>