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
import hei.projet.EstaminetDHowardries.utils.SendTextMessage;

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

		String message = "L'annulation de votre réservation à bien été prise en compte.";
		SendTextMessage envoyeurDeMail = new SendTextMessage();
		try {
			envoyeurDeMail.envoyer_email("smtp.gmail.com", "465","estaminet.howardries.resto@gmail.com",
					user.getMail(), "Confirmation d'annulation", message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.sendRedirect("Reservation");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
