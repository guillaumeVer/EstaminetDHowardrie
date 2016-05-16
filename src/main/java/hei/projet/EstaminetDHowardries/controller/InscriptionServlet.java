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
import hei.projet.EstaminetDHowardries.utils.SendTextMessage;

@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, String> erreurs = new HashMap<String, String>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/inscription.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = new Utilisateur();

		String nom = req.getParameter("Nom");
		user.setNom(nom);
		String prenom = req.getParameter("Prenom");
		user.setPrenom(prenom);
		String mail = req.getParameter("email");
		
		Boolean email = false;
		try {
			email = validationEmail(mail);
		} catch (Exception e) {
			setErreur("mail", e.getMessage());
		}
		
		if(email == false){
		req.setAttribute("erreurs", erreurs);
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
		}else{
		user.setMail(mail);
		String password = req.getParameter("password");
		user.setPassword(password);

		UtilisateurManager.getInstance().creatUtilisateur(user);

		String message = "Merci d'avoir crée un compte sur notre site. Votre nom de Reservation est " + nom
				+ " et votre mot de passe est " + password + ".";

		SendTextMessage envoyeurDeMail = new SendTextMessage();
		try {
			envoyeurDeMail.envoyer_email("smtp.gmail.com", "465","estaminet.howardries.resto@gmail.com", mail,
					"Inscription", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("InscriptionReussi");
		}
	}

	// validation de l'email
	public boolean validationEmail(String email) throws Exception {
		Utilisateur admin = UtilisateurManager.getInstance().getAdministrateur();
		List<Utilisateur> lstUser = UtilisateurManager.getInstance().listerUtilisateur();

		Boolean utilise = false;
		if (email.equals(admin.getMail())) {
			throw new Exception("L'e-mail saisie est déjà utilisé");
		} else {
			// test si le mail existe
			int i = 0;
			while (i < lstUser.size()) {
				if (lstUser.get(i).getMail().equals(email)) {
					utilise = true;
					i = lstUser.size() + 1;
				} else {
					i++;
				}
			}
			// mise en place de l'exception si il exuste
			if (utilise) {
				throw new Exception("L'e-mail saisie est déjà utilisé");
			}
		}
		return utilise;
	}

	// set Erreur
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

}
