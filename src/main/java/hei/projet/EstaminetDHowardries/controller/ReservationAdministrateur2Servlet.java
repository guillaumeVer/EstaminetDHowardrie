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
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.ReservationManager;
import hei.projet.EstaminetDHowardries.manager.TableManager;

@WebServlet("/prive/admin/ReservationAdministrateur2")
public class ReservationAdministrateur2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");

		List<Table> lstTable = TableManager.getInstance().listerTableLibre(reservation.getDate(),
				reservation.getHoraire());
		req.setAttribute("listeDeTable", lstTable);

		if(lstTable.size()==0){
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationImpossibleAdmnistrateur.jsp");
			view.forward(req, resp);
		}else{
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationAdministrateur2.jsp");
		view.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Integer idTable = Integer.parseInt(req.getParameter("table"));
		Table table = TableManager.getInstance().getUneTable(idTable);

		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		reservation.setTable(table);

		ReservationManager.getInstance().ajouterReservation(reservation);
		req.getSession().setAttribute("reservation", reservation);

		resp.sendRedirect("ReservationAdministrateurReussi");

	}

}
