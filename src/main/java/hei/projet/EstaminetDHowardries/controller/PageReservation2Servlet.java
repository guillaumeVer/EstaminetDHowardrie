package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.dao.SendTextMessage;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Table;
import hei.projet.EstaminetDHowardries.manager.HoraireManager;
import hei.projet.EstaminetDHowardries.manager.ReservationManager;
import hei.projet.EstaminetDHowardries.manager.TableManager;

@WebServlet("/Reservation2")
public class PageReservation2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Table> lstTable = TableManager.getInstance().listerTable();
		req.setAttribute("listeDeTable",lstTable);
		
		RequestDispatcher view = req.getRequestDispatcher("/reservation2.jsp");
		view.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer idTable = Integer.parseInt(req.getParameter("table"));
		Table table = TableManager.getInstance().getUneTable(idTable);
		
		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		reservation.setTable(table);
		
		ReservationManager.getInstance().ajouterReservation(reservation);
		req.getSession().setAttribute("reservation", reservation);
		
		if(reservation.getUtilisateur()!=null){
			String message = "Vous avez effectuez une reservation pour le "+reservation.getDate()+" à "+reservation.getHoraire().getIntervalle()+" au nom de "+reservation.getNomReservation()+".";
			SendTextMessage envoyeurDeMail = new SendTextMessage();
			try {
				envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "estaminet.howardries.resto@gmail.com",reservation.getUtilisateur().getMail(), "Confirmation de reservation",message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("ReservationReussi");
		}else{
			resp.sendRedirect("ReservationReussi");
		}
		
	
	}

}
