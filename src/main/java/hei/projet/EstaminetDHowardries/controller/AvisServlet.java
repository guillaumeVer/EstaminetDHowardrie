package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Avis;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.AvisManager;

@WebServlet("/prive/Avis")
public class AvisServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		req.setAttribute("user", user);
		
		List<Avis> lstDeAvis = AvisManager.getInstance().listerAvis();
		req.setAttribute("lstDeAvis", lstDeAvis);
		
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/avis.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Avis avis = new Avis();
		
		String note = req.getParameter("rating");
		Integer note1 = Integer.parseInt(note);
		avis.setNote(note1);
		
		String commentaire = req.getParameter("comment");
		avis.setCommentaire(commentaire);
		
		AvisManager.getInstance().ajouterAvis(avis);
		
		resp.sendRedirect("Avis");
	}

}
