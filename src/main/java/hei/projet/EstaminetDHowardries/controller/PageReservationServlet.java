package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import java.util.List;
import java.util.Random;

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
		String password = "";
		
		
		Utilisateur user=new Utilisateur();
		String etatCheckBox=req.getParameter( "creationcompte" );
		if(etatCheckBox!=null){	
			Random rand = new Random();
			Integer nombre;
			for(int i=0;i<8;i++){
				nombre = rand.nextInt(10);
				nombre.toString();
				password=password+nombre;
			}
			//password="gg";
			utilisateur.setPassword(password);
			
			UtilisateurManager.getInstance().creatUtilisateur(utilisateur);
			
			user = UtilisateurManager.getInstance().getUnUtilisateurbyNom(nom);
			String message = "Nous vous avons crée un compte sur notre site. Votre nom de reservation est "+user.getNom()+" et votre mot de passe est "+user.getPassword()+".";
			
			SendTextMessage envoyeurDeMail = new SendTextMessage();
			try {
				envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "estaminet.howardries.resto@gmail.com",user.getMail(), "Inscription",message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String date = req.getParameter("bookDate");
			
			int nbPersone = Integer.parseInt(req.getParameter("nb"));

			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);
		
			//Integer idTable = Integer.parseInt(req.getParameter("table"));
			//Table table = TableManager.getInstance().getUneTable(idTable);
		
		
			Reservation reservation =new Reservation(user,null, horaire,date,user.getNom(),nbPersone);
			//ReservationManager.getInstance().ajouterReservation(reservation);
			
			req.getSession().setAttribute("reservation", reservation);

		}
		else{
		
			
			String date = req.getParameter("bookDate");
		
			int nbPersone = Integer.parseInt(req.getParameter("nb"));
			
			Integer idhoraire = Integer.parseInt(req.getParameter("horaire"));
			Horaire horaire = HoraireManager.getInstance().getUnHoraire(idhoraire);

			//Integer idTable = Integer.parseInt(req.getParameter("table"));
			//Table table = TableManager.getInstance().getUneTable(idTable);
		
			Reservation reservation =new Reservation(null,null, horaire,date,nom,nbPersone);
			//ReservationManager.getInstance().ajouterReservation(reservation);
			
			req.getSession().setAttribute("reservation", reservation);

		}
		resp.sendRedirect("Reservation2");
	}
	
}
