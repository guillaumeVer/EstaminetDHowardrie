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

@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher view = req.getRequestDispatcher("/inscription.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user=new Utilisateur();
		
		String nom=req.getParameter("Nom");
		user.setNom(nom);
		String prenom=req.getParameter("Prenom");
		user.setPrenom(prenom);
		String mail=req.getParameter("email");
		user.setMail(mail);
		String password=req.getParameter("password");
		user.setPassword(password);

		UtilisateurManager.getInstance().creatUtilisateur(user);
		
		resp.sendRedirect("InscriptionReussi");
	}
	
	

}
