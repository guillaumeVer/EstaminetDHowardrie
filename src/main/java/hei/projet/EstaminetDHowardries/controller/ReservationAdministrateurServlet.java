package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.manager.HoraireManager;

@WebServlet("/prive/admin/ReservationAdministrateur")
public class ReservationAdministrateurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Horaire> lstHoraire = HoraireManager.getInstance().listerHoraire();
		req.setAttribute("listedHoraires", lstHoraire);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationAdministrateur.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String nomReservation = req.getParameter("Nom");
		String date = req.getParameter("bookDate");
		if(date==null){
			resp.sendRedirect("ReservationAdministrateur");
		}
		
		String nb=req.getParameter("nb");
		int nbPersonne = Integer.parseInt(nb);

		Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
		Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

		Reservation reservation = new Reservation(null, null, horaire, date, nomReservation, nbPersonne);
		
		req.getSession().setAttribute("reservation", reservation);

		resp.sendRedirect("ReservationAdministrateur2");
	}

}
