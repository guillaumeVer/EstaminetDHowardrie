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

@WebServlet("/prive/admin/SupprimerAdministrateurReservation")
public class SupprimeReservationAdministrateurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		String idResa = req.getParameter("idReservation");
		Integer id = Integer.parseInt(idResa);

		Reservation resa = ReservationManager.getInstance().getReservationById(id);
		ReservationManager.getInstance().SupprimerReservation(resa);

		resp.sendRedirect("AcceuilAdministrateur");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
