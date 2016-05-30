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
import hei.projet.EstaminetDHowardries.utils.SendMail;

@WebServlet("/prive/ModifierMDP")
public class ModifierMDPServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String messageErreur = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");

		req.setAttribute("user", user);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/modifierMDP.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		
		Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateurConnecte");

		
		// recuperation des mot de passe
		String oldmp = req.getParameter("oldpassword");
		String newmp1 = req.getParameter("newmp1");
		String newmp2 = req.getParameter("newmp2");
		
		String mp = validationMp(oldmp,newmp1,newmp2, user);
		if (messageErreur.equals("")) {

		Utilisateur usermodifier = new Utilisateur(user.getIdUtilisateur(), user.getNom(), user.getPrenom(), user.getMail(), mp);

		// appel de la modification
		UtilisateurManager.getInstance().updateUser(usermodifier);

		SendMail mailEnvoie = new SendMail();

		String message = "<h3><span style=\"color:#3399ff;\">Bienvenue chez l'Estaminet d'Howardries !</span></h3><p>"
				+ ",</p><p>Votre nouveau mot de passe de connexion est: <span style=\"background-color:yellow;\"><strong>"
				+ usermodifier.getPassword() + "";
		mailEnvoie.start(usermodifier.getMail(), "[Estaminet d'Howardries] - Modification de mot de passe", message);

		System.out.println("Mail envoyé");

		// modification de l'utilisateur en session
		req.getSession().removeAttribute("utilisateurConnecte");
		req.getSession().setAttribute("utilisateurConnecte", usermodifier);
		// redirection
		resp.sendRedirect("MonProfil");
		}else{
			req.setAttribute("erreurs", messageErreur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierMDP.jsp").forward(req, resp);
		} 
	}
	
	// validation du mot de passe
		public String validationMp(String oldmp, String newmp1, String newmp2, Utilisateur user) {
			// test de mot de passe
			if (oldmp != null && newmp1 != null && newmp2 != null) {
				if(oldmp.equals(user.getPassword())){
					if(newmp1.equals(newmp2)){
						oldmp=newmp1;
						
						return oldmp;
					}else{
						messageErreur="Les mots de passe ne concordent pas.";
					}
				}else{
					messageErreur="L'ancien mot de passe est faux";	
				}
			} 
			return oldmp;
		}
}
