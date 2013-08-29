package com.caelum.agenda.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RunTime implements Filter {

	@Override
	public void destroy() {};

	@Override
	public void init(FilterConfig arg0) throws ServletException {};
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		
		filter.doFilter(req, resp);
		
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Tempo de requisicao de " + ((HttpServletRequest) req).getRequestURI() + 
						    " demorou " + (tempoFinal - tempoInicial) + "ms");
	}
}
