package com.caelum.agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(PrimeiraLogica.class.getName() + ": Executando a Logica e Redirecionando...");
		
		return "/primeira-logica.jsp";
	}

}
