package com.caelum.agenda.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.caelum.jdbc.ConnectionFactory;
import com.caelum.jdbc.MysqlConnection;

public class ConnectionFilter implements Filter {

	@Override
	public void destroy() {};
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {};
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		ConnectionFactory factory = new MysqlConnection();
		Connection connection = factory.getConnection("localhost", "fj21", "mbarbosa", "h8hzvaxk19");
		
		req.setAttribute("connection", connection);
		
		filter.doFilter(req, resp);
		
		try {
			if(!connection.isClosed())
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
