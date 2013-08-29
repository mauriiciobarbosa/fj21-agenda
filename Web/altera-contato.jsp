<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" href="css/eggplant/jquery-ui-1.10.3.custom.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.9.1.js"> </script>
		<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.js"> </script>
		<title>Alterar Contato</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		
		Formulário para alteração dos contatos: <br />
		
		<form action="mvc" method="POST">
			<%-- <caelum:campoTexto id="id" label="Id:" value="${param.id}" enabled="false"/> 
			<br />
			--%>
			<input type="hidden" name="id" value="${param.id}" />
			
			<caelum:campoTexto id="nome" label="Nome:" value="${param.nome}" />
			<br />
			<caelum:campoTexto id="email" label="E-mail:" value="${param.email}" />
			<br />
			<caelum:campoTexto id="endereco" label="Endereco:" value="${param.end}" />
			<br />
			<caelum:campoData id="dataNascimento" label="Data de Nascimento:" value="${param.nasc}"/>

			<input type="hidden" name="logica" value="AlteraContato" />
			
			<br />
			
			<input type="submit" value="Enviar" />
			
		</form>
		
		<c:import url="rodape.jsp" />
	</body>
</html>