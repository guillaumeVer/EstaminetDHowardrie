package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Boisson;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.BoissonManager;

@WebServlet("/prive/admin/Boissons")
public class BoissonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		List<Boisson> lstBoisson = BoissonManager.getInstance().listerBoisson();
		req.setAttribute("listeDeBoisson", lstBoisson);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/menuboisson.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Boisson boisson = new Boisson();
		
		String nomBoisson = req.getParameter("Nom");
		boisson.setNomBoisson(nomBoisson);
		
		String description = req.getParameter("Description");
		boisson.setDescriptionBoisson(description);
		
		String prix = req.getParameter("Prix");
		Float prixBoisson = Float.parseFloat(prix);
		boisson.setPrix(prixBoisson);
			
		
		BoissonManager.getInstance().ajouterBoisson(boisson);
		resp.sendRedirect("Boissons");
	}

}
