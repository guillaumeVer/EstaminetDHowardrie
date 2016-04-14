package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hei.projet.EstaminetDHowardries.entite.Utilisateur;

import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = -503526558773322139L;
	
	private Map<String, String> utilisateursAutorises;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String utilisateur = (String) req.getSession().getAttribute("utilisateurConnecte");
		
		
		RequestDispatcher view = req.getRequestDispatcher("/connexion.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	List<Utilisateur> lstUser=UtilisateurManager.getInstance().listerUtilisateur();
	
	//Recuperation du formulaire de connexion
	String mail = req.getParameter("username");	
	String password = req.getParameter("password");	
	System.out.println(mail);
	System.out.println(password);
	
	//recuperation de l'admin de la base de donnée
	Utilisateur admin= UtilisateurManager.getInstance().getAdministrateur();
	System.out.println(admin.getMail());
	System.out.println(admin.getPassword());
	
	//Recuperation de l'utilisateur saisie
	Utilisateur user = null;
	int i=0;
	while(user==null && i<lstUser.size()){
		if(lstUser.get(i).getMail().equals(mail)){
			user=lstUser.get(i);
		}else{
			i++;
		}
	}
	
	
	String connexion="";
	req.setAttribute( "connexion", connexion );
	
	if(mail!=null && mail.equals(admin.getMail())){
		try {
			if(password.equals(admin.getPassword())) {
				resp.sendRedirect("AcceuilAdministrateur");
				System.out.println("Connection en tant que administrateur");
			} else {
				System.err.println("Erreur d'identification administrateur!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}else{
		//test du password
		if(user==null){
			System.out.println("user inconnu");
		
			connexion= "Utilisateur inconnu";
			req.setAttribute( "connexion", connexion );
			resp.sendRedirect("Connexion");
		}
		else{
		
	
		try {
			if(password.equals(user.getPassword())) {
				System.out.println("Enregistrement de l'utilisateur en session");
				req.getSession().setAttribute("utilisateurConnecte", user.getNom());
			} else {
				
				System.err.println("Erreur d'identification !!");
					
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} 
	

	resp.sendRedirect("prive/Intro");
	}
	}
	}
	
	
}
