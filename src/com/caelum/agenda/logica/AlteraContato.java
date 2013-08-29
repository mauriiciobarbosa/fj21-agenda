package com.caelum.agenda.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.jdbc.dao.ContatoDao;
import com.caelum.jdbc.model.Contato;

public class AlteraContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contato contato = new Contato();
		
		contato.setId(new Long(request.getParameter("id")));
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		String dataEmTexto = request.getParameter("dataNascimento");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data = Calendar.getInstance();
		
		data.setTime(formato.parse(dataEmTexto));
		
		contato.setDataNascimento(data);
		
		System.out.println("Atualizando contato...");
		
		Connection connection = (Connection) request.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		
		String status = dao.update(contato) ? "Contato atualizado com sucesso" : "Erro ao atualizar contato";
		
		System.out.println(AlteraContato.class.getName() + ": " + status);
		
		return "/lista-contato-elegante.jsp";
	}

}
