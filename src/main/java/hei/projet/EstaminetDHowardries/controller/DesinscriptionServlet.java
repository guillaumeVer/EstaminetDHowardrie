package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;
import hei.projet.EstaminetDHowardries.utils.SendTextMessage;

@WebServlet("/prive/Desinscription")
public class DesinscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recuperation de l'utilisateur
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		req.setAttribute("user", user);

		UtilisateurManager.getInstance().deleteUser(user);

		String message = "Votre compte à bien été supprimé.";

		SendTextMessage envoyeurDeMail = new SendTextMessage();
		try {
			envoyeurDeMail.envoyer_email("smtp.gmail.com", "465","estaminet.howardries.resto@gmail.com",
					user.getMail(), "Confirmation de désinscription", message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.sendRedirect("Deconnexion");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
