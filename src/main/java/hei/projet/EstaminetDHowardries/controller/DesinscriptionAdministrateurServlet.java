package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/prive/admin/DesinscriptionAdministrateur")
public class DesinscriptionAdministrateurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recuperation de l'utilisateur
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);
		
		UtilisateurManager.getInstance().deleteUser(admin);

		SendMail mailEnvoie = new SendMail();

		String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
				+ "Votre compte a bien &eacute;t&eacute; supprim&eacute; "
				+"Nous &eacute;sperons vous revoir bient&ocirc;t";
				
				

		mailEnvoie.start(admin.getMail(), "[Estaminet d'Howardries] - Suppression de Compte", message);

		System.out.println("Mail envoyé");

		resp.sendRedirect("Deconnexion");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
