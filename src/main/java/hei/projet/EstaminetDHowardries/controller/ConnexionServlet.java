package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = -503526558773322139L;

	private String messageErreurMail = "";
	private String messageErreurMp = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/connexion.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Recuperation du formulaire de connexion String mail =
		String mail = req.getParameter("username");
		String mp = req.getParameter("password");

		// recuperation de l'admin de la base de donnée Utilisateur admin =
		Utilisateur admin = UtilisateurManager.getInstance().getAdministrateur(mail);

		List<Utilisateur> lstUser = UtilisateurManager.getInstance().listerUtilisateur();

		Utilisateur utilisateur = null;
		Boolean password = false;
		/* Validation du champ email. */
		utilisateur = validationEmail(mail, admin, lstUser);
		if (utilisateur == null) {
			req.setAttribute("erreursMail", messageErreurMail);

		}

		/* Validation du champ mot de passe. */
		if (utilisateur != null) {
			password = validationMotDePasse(mp, utilisateur);
			if (password != true) {
				req.setAttribute("erreursMp", messageErreurMp);
			}
		}

		if (utilisateur == null || password != true) {
			req.setAttribute("utilisateur", utilisateur);

			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);

		} else {
			if (admin != null && utilisateur.getMail().equals(admin.getMail())) {

				req.getSession().setAttribute("administrateurConnecte", utilisateur);
				req.getSession().setAttribute("utilisateurConnecte", utilisateur);
				System.out.println("Mise en session de l'admin");
				resp.sendRedirect("prive/admin/AcceuilAdministrateur");

			} else {
				
				req.getSession().setAttribute("utilisateurConnecte", utilisateur);
				System.out.println("Mise en session de l'utilisateur");
				resp.sendRedirect("prive/Intro");

			}
		}

	}


	// validation email et recuperation de l'user
	public Utilisateur validationEmail(String email, Utilisateur admin, List<Utilisateur> lstUser) {
	

		Utilisateur user = null;
		// verifie si c'est l'admin
		if (email != null && admin != null && email.equals(admin.getMail())) {
			user = admin;
		} else {
			// verifie si c'est un autre client
			int i = 0;
			while (user == null && i < lstUser.size()) {
				if (lstUser.get(i).getMail().equals(email)) {
					user = lstUser.get(i);
				} else {
					i++;
				}
			}
		}
		if (user != null) {
			return user;
		} else {
			messageErreurMail = "Merci de saisir une adresse mail valide.";
		}
		return user;
	}

	// validation de mot de passe
	private Boolean validationMotDePasse(String motDePasse, Utilisateur user) {
		if (motDePasse != null) {
			if (motDePasse.equals(user.getPassword())) {
				return true;
			} else {
				messageErreurMp = "Merci de saisir un mot de passe valide";
			}
		} else {
			messageErreurMp = "Merci de saisir votre mot de passe.";
		}
		return false;
	}
}
