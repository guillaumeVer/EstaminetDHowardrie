package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prive/Deconnexion")
public class DeconnexionServlet extends HttpServlet {

		private static final long serialVersionUID = -2793586799100543352L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			String utilisateur = (String) req.getSession().getAttribute("utilisateurConnecte");
			req.setAttribute( "nom", utilisateur );
			
			
			req.getSession().removeAttribute("utilisateurConnecte");
			resp.sendRedirect("Index");
		}

	}

