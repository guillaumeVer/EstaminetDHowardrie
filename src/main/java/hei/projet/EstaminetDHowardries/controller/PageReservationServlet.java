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

import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.HoraireManager;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;
import hei.projet.EstaminetDHowardries.utils.MdpGenerator;
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/Reservation")
public class PageReservationServlet extends HttpServlet {

	private static final long serialVersionUID = 5116801608350465763L;

	private Map<String, String> erreurs = new HashMap<String, String>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Horaire> lstHoraire = HoraireManager.getInstance().listerHoraire();
		req.setAttribute("listedHoraires", lstHoraire);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservation.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Utilisateur utilisateur = new Utilisateur();
		String nom = req.getParameter("Nom");
		utilisateur.setNom(nom);
		String prenom = req.getParameter("Prenom");
		utilisateur.setPrenom(prenom);
		String email = req.getParameter("email");
		req.getSession().setAttribute("mail", email);

		utilisateur.setMail(email);
		String password = "";

		Utilisateur user = new Utilisateur();
		String etatCheckBox = req.getParameter("creationcompte");
		if (etatCheckBox != null) {

			String mail = req.getParameter("Email");
			Boolean emailBoolean = false;
			try {
				emailBoolean = validationEmail(mail);
			} catch (Exception e) {
				setErreur("mail", e.getMessage());
			}
			if (emailBoolean) {
				req.setAttribute("erreurs", erreurs);
				this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
			} else {
				user.setMail(mail);

				MdpGenerator mdp = new MdpGenerator();
				password = mdp.generate();
				/*
				 * Random rand = new Random(); Integer nombre; for (int i = 0; i
				 * < 8; i++) { nombre = rand.nextInt(10); nombre.toString();
				 * password = password + nombre; }
				 */

				utilisateur.setPassword(password);

				UtilisateurManager.getInstance().creatUtilisateur(utilisateur);

				SendMail mailEnvoie = new SendMail();

				String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
						+ "Bonjour " + prenom + " " + nom
						+ ",</p><p>Votre mot de passe de connexion est: <span style=\"background-color:yellow;\"><strong>"
						+ password
						+ "</strong></span>.</p><p>Vous pouvez le modifier une fois connect&eacute; dans l&#39;onglet &quot;<strong>Mon profil</strong></p><p>Voici l'adresse de la plateforme web:  .</p><p>Nous sommes &agrave; votre &eacute;coute pour toutes futures demandes.</p>";

				mailEnvoie.start(utilisateur.getMail(), "[Estaminet d'Howardries] - Création de votre compte", message);

				System.out.println("Mail envoyé");

			}
			String date = req.getParameter("bookDate");

			int nbPersone = Integer.parseInt(req.getParameter("nb"));

			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

			Reservation reservation = new Reservation(user, null, horaire, date, user.getNom(), nbPersone);

			req.getSession().setAttribute("reservation", reservation);

		} else {

			String date = req.getParameter("bookDate");

			int nbPersone = Integer.parseInt(req.getParameter("nb"));

			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

			Reservation reservation = new Reservation(null, null, horaire, date, nom, nbPersone);

			req.getSession().setAttribute("reservation", reservation);

		}
		resp.sendRedirect("Reservation2");
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
