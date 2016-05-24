package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Table;
import hei.projet.EstaminetDHowardries.manager.ReservationManager;
import hei.projet.EstaminetDHowardries.manager.TableManager;
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/Reservation2")
public class PageReservation2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");

		List<Table> lstTable = TableManager.getInstance().listerTableLibre(reservation.getDate(),reservation.getHoraire());
		req.setAttribute("listeDeTable", lstTable);

		if (lstTable.size() == 0) {
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationImpossible.jsp");
			view.forward(req, resp);
		} else {
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservation2.jsp");
			view.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idTable = Integer.parseInt(req.getParameter("table"));
		Table table = TableManager.getInstance().getUneTable(idTable);

		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		reservation.setTable(table);

		ReservationManager.getInstance().ajouterReservation(reservation);
		
		if (reservation.getUtilisateur() != null) {

			SendMail mailEnvoie = new SendMail();

			String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
					+ ",</p><p>Votre avez effectué un réservation" + "au nom de : " + reservation.getNomReservation()
					+ "" + "à la date de " + reservation.getDate() + "et à " + reservation.getHoraire().getIntervalle()+"";
			
			mailEnvoie.start(reservation.getUtilisateur().getMail(), "[Estaminet d'Howardries] - Réservation", message);

			System.out.println("Mail envoyé");
		}
		
		String email = (String) req.getSession().getAttribute("mail");
		if(email!=null){
			SendMail mailEnvoie = new SendMail();

			String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
					+ ",</p><p>Votre avez effectué un réservation" + "au nom de : " + reservation.getNomReservation()
					+ "" + "à la date de " + reservation.getDate() + "et à " + reservation.getHoraire().getIntervalle()+"";
			
			mailEnvoie.start(reservation.getUtilisateur().getMail(), "[Estaminet d'Howardries] - Réservation", message);

			System.out.println("Mail envoyé");
		}

		
		resp.sendRedirect("ReservationReussi");

	}

}
