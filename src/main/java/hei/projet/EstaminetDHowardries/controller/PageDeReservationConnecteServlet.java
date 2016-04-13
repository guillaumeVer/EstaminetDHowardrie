package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

@WebServlet("/prive/Reservation")
public class PageDeReservationConnecteServlet extends HttpServlet {


	private static final long serialVersionUID = -159275287852148698L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String utilisateur = (String) req.getSession().getAttribute("utilisateurConnecte");
		req.setAttribute( "nom", utilisateur );
		
		//Utilisateur user = UtilisateurManager.getInstance().getUnUtilisateur(idUtilisateur);
		//req.setAttribute( "nomUser", user.getNom() );
		//req.setAttribute( "prenomUser", user.getPrenom() );
		//req.setAttribute( "mailUser", user.getMail() );
		
		RequestDispatcher view = req.getRequestDispatcher("/reservationConnecte.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
