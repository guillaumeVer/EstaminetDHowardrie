package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.dao.SendTextMessage;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/inscription.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user=new Utilisateur();
		
		String nom=req.getParameter("Nom");
		user.setNom(nom);
		String prenom=req.getParameter("Prenom");
		user.setPrenom(prenom);
		String mail=req.getParameter("email");
		user.setMail(mail);
		String password=req.getParameter("password");
		user.setPassword(password);

		UtilisateurManager.getInstance().creatUtilisateur(user);
		
		String message = "Merci d'avoir crée un compte sur notre site. Votre nom de Reservation est "+nom+" et votre mot de passe est "+password+".";
		
		SendTextMessage envoyeurDeMail = new SendTextMessage();
		try {
			envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "estaminet.howardries.resto@gmail.com",mail, "Inscription",message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("InscriptionReussi");
	}
	
	

}
