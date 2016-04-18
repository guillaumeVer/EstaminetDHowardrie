package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

@WebServlet("/prive/ReservationReussi")
public class PageReservationConnecteReussiServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		String utilisateur = (String) req.getSession().getAttribute("utilisateurConnecte");
		Utilisateur user = UtilisateurManager.getInstance().getUnUtilisateurbyNom(utilisateur);
		
		req.setAttribute("user",user);
		
		
		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		req.setAttribute("reservation", reservation);
		req.setAttribute("table",reservation.getTable());
		req.setAttribute("horaire",reservation.getHoraire());
		
		RequestDispatcher view = req.getRequestDispatcher("/reservationReussiConnecte.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	

}
