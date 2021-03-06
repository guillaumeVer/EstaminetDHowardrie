package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.HoraireManager;
import hei.projet.EstaminetDHowardries.manager.ReservationManager;

@WebServlet("/prive/Reservation")
public class PageReservationConnecteServlet extends HttpServlet {

	private static final long serialVersionUID = -159275287852148698L;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		req.setAttribute("user", user);

		List<Horaire> lstHoraire = HoraireManager.getInstance().listerHoraire();
		req.setAttribute("listedHoraires", lstHoraire);

		List<Reservation> lstReservation = ReservationManager.getInstance().listerReservationParCLient(user.getIdUtilisateur());
		req.setAttribute("listeDeReservation", lstReservation);

		if (lstReservation.size() > 0) {
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationConnecte.jsp");
			view.forward(req, resp);
		} else {
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/reservationConnecteVide.jsp");
			view.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");

		String nomReservation = req.getParameter("Nom");
		Date date_compte = null;
		String bookdate= req.getParameter("bookDate");
		if(bookdate.indexOf("/")!=-1){
			String jour = bookdate.substring(3,5);
			String mois = bookdate.substring(0,2);
			String year = bookdate.substring(6,10);
			bookdate = year+"-"+mois+"-"+jour;
			
			try {
				date_compte = dateFormat.parse(bookdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			
		
		try {
			date_compte = dateFormat.parse(req.getParameter("bookDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		int nbPersonne = Integer.parseInt(req.getParameter("nbPersonne"));

		Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
		Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

		Reservation reservation = new Reservation(user, null, horaire, date_compte, nomReservation, nbPersonne);

		req.getSession().setAttribute("reservation", reservation);

		resp.sendRedirect("Reservation2");
	}

}
