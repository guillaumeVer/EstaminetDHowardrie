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

@WebServlet("/prive/admin/ModifierInfoAdmin")
public class ModifierInfoAdminServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin",admin);
		
		RequestDispatcher view = req.getRequestDispatcher("/modifierMDPAdmin.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//recuperation de l'admin en session
		Utilisateur adminModifier = new Utilisateur();
		Utilisateur admin= (Utilisateur) req.getSession().getAttribute("administrateurConnecte");	
		
		adminModifier.setIdUtilisateur(admin.getIdUtilisateur());
		adminModifier.setMail(admin.getMail());
		adminModifier.setNom(admin.getNom());
		adminModifier.setPrenom(admin.getPrenom());
		
		//recuperation des mot de passe
		String oldmp=req.getParameter("oldpassword");
		String newmp1=req.getParameter("newmp1");
		String newmp2=req.getParameter("newmp2");
		
		//test de mot de passe
		if(oldmp!=null && newmp1 != null && newmp2 != null){
			if(oldmp.equals(admin.getPassword()) && newmp1.equals(newmp2)){
				adminModifier.setPassword(newmp1);
			}
			else{
				
			}
		}else{
			adminModifier.setPassword(adminModifier.getPassword());
		}
		
		//appel de la modification
		UtilisateurManager.getInstance().updateUser(adminModifier);
		

		//modification de l'utilisateur en session
		req.getSession().removeAttribute("utilisateurConnecte");
		req.getSession().setAttribute("utilisateurConnecte", adminModifier);
		
		req.getSession().removeAttribute("administrateurConnecte");
		req.getSession().setAttribute("administrateurConnecte", adminModifier);
		
		//redirection
		resp.sendRedirect("AcceuilAdministrateur");
	}
	
}
