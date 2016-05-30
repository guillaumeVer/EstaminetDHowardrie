package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Boisson;
import hei.projet.EstaminetDHowardries.entite.Plat;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.BoissonManager;
import hei.projet.EstaminetDHowardries.manager.PlatManager;

@WebServlet("/prive/Index")
public class IndexConnecteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		req.setAttribute("user", user);

		Plat platDuJour = PlatManager.getInstance().getPlatDuJour();
		req.setAttribute("platDuJour",platDuJour);
		
		Boisson boissonDuMois = BoissonManager.getInstance().getBoissonDuMois();
		req.setAttribute("boissonDuMois", boissonDuMois);
		
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/indexConnecte.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
