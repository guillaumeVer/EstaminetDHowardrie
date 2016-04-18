package hei.projet.EstaminetDHowardries.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/prive/*")
public class AuthentificationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String identifiant = (String) httpRequest.getSession().getAttribute("utilisateurConnecte");
		if (identifiant == null || "".equals(identifiant)) {
			System.out.println("Il faut etre connecté pour accéder à  cette page !");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("../Connexion");
			
		}
		chain.doFilter(request, response);

		
	}

	@Override
	public void destroy() {
		
		
	}

	
}
