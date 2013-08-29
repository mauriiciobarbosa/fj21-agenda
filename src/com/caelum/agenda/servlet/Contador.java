package com.caelum.agenda.servlet;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contador extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int contador;
	
	public Contador() {
		contador = 0;
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando Servlet");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log("Finalizando Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,java.io.IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("Página visitada por "+ ++contador + "cliente(s)");
		out.println("</body>");
		out.println("</html>");
		
	}
}
