package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.ReservationManager;
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/prive/SupprimerReservation")
public class SupprimeReservationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		req.setAttribute("user", user);

		String idResa = req.getParameter("idReservation");
		Integer id = Integer.parseInt(idResa);

		Reservation resa = ReservationManager.getInstance().getReservationById(id);
		ReservationManager.getInstance().SupprimerReservation(resa);

		SendMail mailEnvoie = new SendMail();

		String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
				+ ",</p><p>Votre réservation a bien été supprimé<p>";
				
		mailEnvoie.start(resa.getUtilisateur().getMail(), "[Estaminet d'Howardries] - Annulation de réservation", message);

		System.out.println("Mail envoyé");

		resp.sendRedirect("Reservation");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
