package hei.projet.EstaminetDHowardries.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;

@WebFilter("/prive/admin/*")
public class AuthentificationAdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Utilisateur identifiant = (Utilisateur) httpRequest.getSession().getAttribute("utilisateurConnecte");
		Utilisateur admin = (Utilisateur) httpRequest.getSession().getAttribute("administrateurConnecte");
		if (identifiant == null || "".equals(identifiant)) {
			System.out.println("Il faut être connecté en tant que administrateur pour accéder à cette page !");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("../connexion");
			return;
		}
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
