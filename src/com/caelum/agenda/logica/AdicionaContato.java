package com.caelum.agenda.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.jdbc.dao.ContatoDao;
import com.caelum.jdbc.model.Contato;

public class AdicionaContato implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Contato contato = new Contato();
		
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();
		
		dataNascimento.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto));
		
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		String status = new ContatoDao(connection).add(contato) ? "Contato adicionado com sucesso!" : "Erro ao adicionar Contato!";
		
		System.out.println(AdicionaContato.class.getName() + ": " + status);
		
		return "/lista-contato-elegante.jsp";
	}

}
