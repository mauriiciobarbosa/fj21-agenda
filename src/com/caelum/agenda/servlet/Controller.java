package com.caelum.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.agenda.logica.Logica;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "com.caelum.agenda.logica." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			
			String page = logica.executa(request, response);
			
			System.out.println(Controller.class.getName() + ": Redirecionando para " + page + " ...");
			
			request.getRequestDispatcher(page).forward(request, response);

			System.out.println(Controller.class.getName() + ": Requisição redirecionada com suceso!");
		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma excessao", e);
		}
	}
}
