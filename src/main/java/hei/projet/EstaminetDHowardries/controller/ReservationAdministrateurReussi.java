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

@WebServlet("/prive/admin/ReservationAdministrateurReussi")
public class ReservationAdministrateurReussi extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);
		
		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		req.setAttribute("reservation", reservation);
		req.setAttribute("table", reservation.getTable());
		req.setAttribute("horaire", reservation.getHoraire());
		
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationReussiAdministrateur.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			}

}
