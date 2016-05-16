package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private Map<String, String> erreurs = new HashMap<String, String>();

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
		Utilisateur admin = UtilisateurManager.getInstance().getAdministrateur();

		List<Utilisateur> lstUser = UtilisateurManager.getInstance().listerUtilisateur();

		Utilisateur utilisateur = null;
		Boolean password = false;
		/* Validation du champ email. */
		try {
			utilisateur = validationEmail(mail, admin, lstUser);
		} catch (Exception e) {
			setErreur("username", e.getMessage());
		}

		if (utilisateur != null) {
			/* Validation du champ mot de passe. */
			try {
				password = validationMotDePasse(mp, utilisateur);
			} catch (Exception e) {
				setErreur("password", e.getMessage());
			}
		}

		if (utilisateur == null || password != true) {
			req.setAttribute("utilisateur", utilisateur);
			req.setAttribute("erreurs", erreurs);
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);

		} else {
			if (utilisateur.getMail().equals(admin.getMail())) {

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

	/*
	 * // test si l'admin essaye de se connecter if (mail != null &&
	 * mail.equals(admin.getMail()) && admin != null) { try { if
	 * (password.equals(admin.getPassword())) { // mise en session de l'admin
	 * req.getSession().setAttribute("administrateurConnecte", admin);
	 * req.getSession().setAttribute("utilisateurConnecte", admin);
	 * 
	 * // Redirection resp.sendRedirect("prive/admin/AcceuilAdministrateur");
	 * System.out.println("Connection en tant que administrateur"); } else {
	 * system.err.println("Erreur d'identification administrateur!!"); } } catch
	 * (Exception e) { e.printStackTrace(); } } else {
	 * 
	 * int i = 0; while (user == null && i < lstUser.size()) { if
	 * (lstUser.get(i).getMail().equals(mail)) { user = lstUser.get(i); } else {
	 * i++; } }
	 * 
	 * // test si l'utilisateur n'existe pas if (user == null) {
	 * System.out.println("user inconnu"); // redirection vers connexion si
	 * l'utilisateur n'existe pas resp.sendRedirect("Connexion"); } else {
	 * 
	 * try { // test du mdp de l'utilisateur if
	 * (password.equals(user.getPassword())) { // mise en session du client
	 * System.out.println("Enregistrement de l'utilisateur en session");
	 * req.getSession().setAttribute("utilisateurConnecte", user);
	 * resp.sendRedirect("prive/Index"); } else {
	 * 
	 * System.err.println("Erreur d'identification !!");
	 * resp.sendRedirect("Connexion"); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * } }
	 * 
	 * }
	 */

	// set Erreur
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	// validation email et recuperation de l'user
	public Utilisateur validationEmail(String email, Utilisateur admin, List<Utilisateur> lstUser) throws Exception {
		Utilisateur user = null;
		// verifie si c'est l'admin
		if (email != null && email.equals(admin.getMail())) {
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
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	// validation de mot de passe
	private Boolean validationMotDePasse(String motDePasse, Utilisateur user) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.equals(user.getPassword())) {
				return true;
			} else {
				throw new Exception("Merci de saisir un mot de passe valide");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}
}
