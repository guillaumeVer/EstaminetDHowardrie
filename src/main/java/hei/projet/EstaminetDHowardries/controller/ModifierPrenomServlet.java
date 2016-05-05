package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

@WebServlet("/prive/ModifierPrenom")
public class ModifierPrenomServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		
		req.setAttribute("user",user);
		
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/modifierprenom.jsp");
		view.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String prenom = req.getParameter("Prenom");
		
		Utilisateur usermodifier = new Utilisateur();
		Utilisateur user= (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		
		usermodifier.setNom(user.getNom());
		usermodifier.setPrenom(prenom);
		usermodifier.setIdUtilisateur(user.getIdUtilisateur());
		usermodifier.setMail(user.getMail());
		usermodifier.setPassword(user.getPassword());
		
		UtilisateurManager.getInstance().updateUser(usermodifier);
		
		req.getSession().removeAttribute("utilisateurConnecte");
		req.getSession().setAttribute("utilisateurConnecte", usermodifier);
		
		resp.sendRedirect("MonProfil");
	}

}
