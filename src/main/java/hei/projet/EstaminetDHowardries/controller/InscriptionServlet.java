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
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String messageErreur = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/inscription.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String nom = req.getParameter("Nom");
		String prenom = req.getParameter("Prenom");
		String mail = req.getParameter("Email");

		Boolean email = false;
		email = validationEmail(mail);

		if (email == true) {
			req.setAttribute("erreurs", messageErreur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
		} else {
			String password = req.getParameter("password");

			Utilisateur user = new Utilisateur(null, nom, prenom, mail, password);

			UtilisateurManager.getInstance().creatUtilisateur(user);

			
			  SendMail mailEnvoie = new SendMail();
			  
			  String message =
			  "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
			  + "Bonjour " + prenom + " " + nom +
			",</p><p>Votre mot de passe de connexion est: <span style=\"background-color:yellow;\"><strong>"
			 + password +
			  "</strong></span>.</p><p>Vous pouvez le modifier une fois connect&eacute; dans l&#39;onglet<strong>Mon profil</strong></p><p>Voici l'adresse de la plateforme web: estaminet-howardries.eu .</p><p>Nous sommes &agrave; votre &eacute;coute pour toutes futures demandes.</p>"
			  ;
			 
			  mailEnvoie.start(mail,"[Estaminet d'Howardries] - Création de votre compte", message);
			 
			 System.out.println("Mail envoyé");
			 

			resp.sendRedirect("InscriptionReussi");
		}
	}

	// validation de l'email
	public boolean validationEmail(String email) {
		Utilisateur user = UtilisateurManager.getInstance().getUnUtilisateurbyMail(email);
		System.out.println(user);
		Boolean utilise = false;
		if (user == null) {
			utilise = false;
		} else {
			utilise = true;
			messageErreur = "Merci de saisir une adresse mail valide.";
		}
		return utilise;
	}
}
