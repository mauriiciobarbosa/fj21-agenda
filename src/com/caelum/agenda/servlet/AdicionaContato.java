package com.caelum.agenda.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.jdbc.dao.ContatoDao;
import com.caelum.jdbc.model.Contato;

public class AdicionaContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		boolean add = false;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			
			Contato contato = new Contato();
			
			contato.setNome(nome);
			contato.setDataNascimento(dataNascimento);
			contato.setEmail(email);
			contato.setEndereco(endereco);
		
			Connection connection = (Connection) request.getAttribute("connection");
			
			ContatoDao contatoDao = new ContatoDao(connection);
			
			add = contatoDao.add(contato);
			
		} catch (ParseException e) {
			// Ignore
		}
		
		String url = add ? "/contato-adicionado.jsp" : "/erro.html";
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		
		rd.forward(request, response);
	}
}
