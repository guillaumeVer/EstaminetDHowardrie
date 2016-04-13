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
import hei.projet.EstaminetDHowardries.entite.Table;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.HoraireManager;
import hei.projet.EstaminetDHowardries.manager.ReservationManager;
import hei.projet.EstaminetDHowardries.manager.TableManager;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

@WebServlet("/Reservation")
public class PageReservationServlet extends HttpServlet {

	

	private static final long serialVersionUID = 5116801608350465763L;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Horaire> lstHoraire = HoraireManager.getInstance().listerHoraire();
		req.setAttribute("listedHoraires", lstHoraire);
		
		List<Table> lstTable = TableManager.getInstance().listerTable();
		req.setAttribute("listeDeTable",lstTable);
		
		RequestDispatcher view = req.getRequestDispatcher("/reservation.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Utilisateur utilisateur=new Utilisateur();
		String nom = req.getParameter("Nom");
		utilisateur.setNom(nom);
		String prenom = req.getParameter("Prenom");
		utilisateur.setPrenom(prenom);
		String email = req.getParameter("email");
		utilisateur.setMail(email);
		String password;
		
		
		Utilisateur user=new Utilisateur();
		String etatCheckBox=req.getParameter( "creationcompte" );
		if(etatCheckBox!=null){	
			password="gg";
			utilisateur.setPassword(password);
			
			UtilisateurManager.getInstance().creatUtilisateur(utilisateur);
		
			user = UtilisateurManager.getInstance().getUnUtilisateurbyNom(nom);
			
			
			String date = req.getParameter("date");
			
			int nbPersone = Integer.parseInt(req.getParameter("nb"));

			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);
		
			Integer idTable = Integer.parseInt(req.getParameter("table"));
			Table table = TableManager.getInstance().getUneTable(idTable);
		
		
			Reservation reservation =new Reservation(user,table, horaire,date,user.getNom(),nbPersone);
			ReservationManager.getInstance().ajouterReservation(reservation);
		}
		else{
		
			
			String date = req.getParameter("date");
		
			int nbPersone = Integer.parseInt(req.getParameter("nb"));
			
			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

			Integer idTable = Integer.parseInt(req.getParameter("table"));
			Table table = TableManager.getInstance().getUneTable(idTable);
		
			Reservation reservation =new Reservation(null,table, horaire,date,nom,nbPersone);
			ReservationManager.getInstance().ajouterReservation(reservation);

		}
		resp.sendRedirect("ReservationReussi");
	}
	
}
