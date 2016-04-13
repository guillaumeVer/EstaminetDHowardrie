package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prive/Intro")
public class IntroConnecteServlet extends HttpServlet {
	

	private static final long serialVersionUID = 9019104487953296241L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String utilisateur = (String) req.getSession().getAttribute("utilisateurConnecte");
			req.setAttribute( "nom", utilisateur );
			
			
			RequestDispatcher view = req.getRequestDispatcher("/introConnecté.jsp");
			view.forward(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		}

		
	}

