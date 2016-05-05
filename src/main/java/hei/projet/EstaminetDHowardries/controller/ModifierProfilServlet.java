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

@WebServlet("/prive/ModifierProfil")
public class ModifierProfilServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");
		
		req.setAttribute("user",user);
		
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/modifierprofil.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Utilisateur usermodifier = new Utilisateur();
			Utilisateur user= (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");	
				
			usermodifier.setIdUtilisateur(user.getIdUtilisateur());
			usermodifier.setMail(user.getMail());
			
		String nom=req.getParameter("Nom");
		usermodifier.setNom(nom);
		String prenom=req.getParameter("Prenom");
		usermodifier.setPrenom(prenom);
		
		String oldmp=req.getParameter("oldpassword");
		String newmp1=req.getParameter("newmp1");
		String newmp2=req.getParameter("newmp2");
		
		if(oldmp!=null && newmp1 != null && newmp2 != null){
			if(oldmp.equals(user.getPassword()) && newmp1.equals(newmp2)){
				usermodifier.setPassword(newmp1);
			}
			else{
				
			}
		}else{
			usermodifier.setPassword(user.getPassword());
		}
		
		UtilisateurManager.getInstance().updateUser(usermodifier);
		
		//Envoie de mail
				String message = "Vous venez de modifier votre profil. "
						+ "Votre nouveau mot de passe est : "+usermodifier.getPassword()+". "
						+"Votre nom de reservation est : "+usermodifier.getNom()+"."
						+"Votre prenom de reservation est : "+usermodifier.getPrenom()+".";
				SendTextMessage envoyeurDeMail = new SendTextMessage();
				try {
					envoyeurDeMail.envoyer_email("smtp.gmail.com", "465", "estaminet.howardries.resto@gmail.com",usermodifier.getMail(), "Modificaton du mot de passe",message);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
		req.getSession().removeAttribute("utilisateurConnecte");
		req.getSession().setAttribute("utilisateurConnecte", usermodifier);
		
		resp.sendRedirect("MonProfil");
	}

}
