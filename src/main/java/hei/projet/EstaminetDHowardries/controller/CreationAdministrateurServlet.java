package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/prive/admin/CreationAdministrateur")
public class CreationAdministrateurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, String> erreurs = new HashMap<String, String>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/creationadministrateur.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = new Utilisateur();

		String nom = req.getParameter("Nom");
		user.setNom(nom);
		String prenom = req.getParameter("Prenom");
		user.setPrenom(prenom);

		String mail = req.getParameter("Email");
		Boolean email = false;
		try {
			email = validationEmail(mail);
		} catch (Exception e) {
			setErreur("mail", e.getMessage());
		}
		if (email) {
			req.setAttribute("erreurs", erreurs);
			this.getServletContext().getRequestDispatcher("/WEB-INF/creationadministrateur.jsp").forward(req, resp);
		} else {
			user.setMail(mail);
			System.out.println(mail);
			String password = req.getParameter("password");
			user.setPassword(password);

			UtilisateurManager.getInstance().creatAdministrateur(user);

			SendMail mailEnvoie = new SendMail();

			String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
					+ "<p>Vous venez de créer un nouveau compte administrateur</p>" + "Bonjour " + prenom + " " + nom
					+ ",</p><p>Votre mot de passe de connexion est: <span style=\"background-color:yellow;\"><strong>"
					+ password
					+ "</strong></span>.</p><p>Vous pouvez le modifier une fois connect&eacute; dans l&#39;onglet &quot;<strong>Mon profil</strong></p><p>Voici l'adresse de la plateforme web:  .</p><p>Nous sommes &agrave; votre &eacute;coute pour toutes futures demandes.</p>";

			mailEnvoie.start(mail, "[Estaminet d'Howardries] - Création de votre compte administrateur", message);

			System.out.println("Mail envoyé");

			resp.sendRedirect("CreationAdministrateurReussi");
		}
	}

	// validation de l'email
	public boolean validationEmail(String email) throws Exception {
		Utilisateur user = UtilisateurManager.getInstance().getUnUtilisateurbyMail(email);

		Boolean utilise = false;
		if (user.getMail() == null) {
			utilise = false;
		} else {
			utilise = true;
			throw new Exception("L'e-mail saisie est déjà utilisé");
		}
		return utilise;
	}

	// set Erreur
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

}
