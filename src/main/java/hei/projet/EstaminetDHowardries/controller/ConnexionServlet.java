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
		
	String nom = req.getParameter("username");	
	String password = req.getParameter("password");	
	
	
	Utilisateur user = null;
	int i=0;
	while(user==null && i<lstUser.size()){
		if(lstUser.get(i).getNom().equals(nom)){
			user=lstUser.get(i);
		}else{
			i++;
		}
	}
	
	if(user==null){
		System.out.println("user inconnu");
		
	}else{
	
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
