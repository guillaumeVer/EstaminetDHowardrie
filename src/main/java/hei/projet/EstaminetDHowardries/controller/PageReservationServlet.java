package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/Reservation")
public class PageReservationServlet extends HttpServlet {

	private static final long serialVersionUID = 5116801608350465763L;

	private String messageErreur = "";

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
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

		String nom = req.getParameter("Nom");
		String prenom = req.getParameter("Prenom");
		String email = req.getParameter("email");
		
		Date date_compte = null;
		
		String password = "";

		String etatCheckBox = req.getParameter("creationcompte");
		if (etatCheckBox != null) {

			Boolean emailBoolean = false;
			emailBoolean = validationEmail(email);

			if (emailBoolean == true) {
				req.setAttribute("erreurs", messageErreur);
				List<Horaire> lstHoraire = HoraireManager.getInstance().listerHoraire();
				req.setAttribute("listedHoraires", lstHoraire);
				this.getServletContext().getRequestDispatcher("/WEB-INF/reservation.jsp").forward(req, resp);
			} else {

				Random rand = new Random();
				Integer nombre;
				for (int i = 0; i < 8; i++) {
					nombre = rand.nextInt(10);
					nombre.toString();
					password = password + nombre;
				}

				Utilisateur utilisateur = new Utilisateur(null, nom, prenom, email, password);

				UtilisateurManager.getInstance().creatUtilisateur(utilisateur);

				SendMail mailEnvoie = new SendMail();

				String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
						+ "Bonjour " + prenom + " " + nom
						+ ",</p><p>Votre mot de passe de connexion est: <span style=\"background-color:yellow;\"><strong>"
						+ password
						+ "</strong></span>.</p><p>Vous pouvez le modifier une fois connect&eacute; dans l&#39;onglet &quot;<strong>Mon profil</strong></p><p>Voici l'adresse de la plateforme web: <a href="+"estaminet-howardries.eu"+">estaminet-howardries.eu</a></p><p>Nous sommes &agrave; votre &eacute;coute pour toutes futures demandes.</p>";

				mailEnvoie.start(utilisateur.getMail(), "[Estaminet d'Howardries] - Création de votre compte", message);

				System.out.println("Mail envoyé");

				String bookdate= req.getParameter("bookDate");
				if(bookdate.indexOf("/")!=-1){
					String jour = bookdate.substring(3,5);
					String mois = bookdate.substring(0,2);
					String year = bookdate.substring(6,10);
					bookdate = year+"-"+mois+"-"+jour;
					
					try {
						date_compte = dateFormat.parse(bookdate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					int nbPersone = Integer.parseInt(req.getParameter("nb"));

					Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
					Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

					Utilisateur user = UtilisateurManager.getInstance().getUnUtilisateurbyMail(email);
					Reservation reservation = new Reservation(user, null, horaire, date_compte, utilisateur.getNom(), nbPersone);

					req.getSession().setAttribute("reservation", reservation);
					resp.sendRedirect("Reservation2");
				}else{
			
			try {
				date_compte = dateFormat.parse(req.getParameter("bookDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			int nbPersone = Integer.parseInt(req.getParameter("nb"));

			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

			Utilisateur user = UtilisateurManager.getInstance().getUnUtilisateurbyMail(email);
			Reservation reservation = new Reservation(user, null, horaire, date_compte, utilisateur.getNom(), nbPersone);

			req.getSession().setAttribute("reservation", reservation);
			resp.sendRedirect("Reservation2");
			}
			}
		} else {
			String bookdate= req.getParameter("bookDate");
			if(bookdate.indexOf("/")!=-1){
				String jour = bookdate.substring(3,5);
				String mois = bookdate.substring(0,2);
				String year = bookdate.substring(6,10);
				bookdate = year+"-"+mois+"-"+jour;
				
				try {
					date_compte = dateFormat.parse(bookdate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				
			
			try {
				date_compte = dateFormat.parse(req.getParameter("bookDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			}
			
			int nbPersone = Integer.parseInt(req.getParameter("nb"));

			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

			Reservation reservation = new Reservation(null, null, horaire, date_compte, nom, nbPersone);

			req.getSession().setAttribute("reservation", reservation);
			resp.sendRedirect("Reservation2");

		}
	}
	

	// validation de l'email
	public boolean validationEmail(String email) {
		Utilisateur user = UtilisateurManager.getInstance().getUnUtilisateurbyMail(email);
		Boolean utilise = false;
		if (user == null) {
			utilise = false;
		} else {
			utilise = true;
			messageErreur = "Email déjà utilisé";
		}
		return utilise;
	}

}
