package com.caelum.agenda.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.jdbc.dao.ContatoDao;
import com.caelum.jdbc.model.Contato;

public class RemoveContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contato contato = new Contato();
	
		contato.setId(new Long(request.getParameter("id")));
		
		System.out.println("Removendo contato " + contato.getId() + "...");
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		String status = new ContatoDao(connection).delete(contato) ? "Contato removido com sucesso" : "Erro ao remover contato";
		
		System.out.println(RemoveContato.class.getName() + ": " + status);
		
		return "/lista-contato-elegante.jsp";
	}

}
