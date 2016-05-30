package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Reservation;

@WebServlet("/ReservationReussi")
public class PageReservationReussiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		if(reservation==null){
			resp.sendRedirect("Reservation");
		}else{
		reservation.setDate(new Date(reservation.getDate().getTime()));
		
		req.setAttribute("reservation", reservation);
		req.setAttribute("table", reservation.getTable());
		req.setAttribute("horaire", reservation.getHoraire());

		
		
		String mail = (String) req.getSession().getAttribute("mail");
		req.setAttribute("mail", mail);
		

		
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationReussi.jsp");
		view.forward(req, resp);

		req.getSession().removeAttribute("reservation");

	}}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
