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

@WebServlet("/prive/admin/ModifierInfoAdmin")
public class ModifierInfoAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String messageErreur = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/modifierMDPAdmin.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// recuperation de l'admin en session
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");

		// recuperation des mot de passe
		String oldmp = req.getParameter("oldpassword");
		String newmp1 = req.getParameter("newmp1");
		String newmp2 = req.getParameter("newmp2");

		String mp = validationMp(oldmp, newmp1, newmp2, admin);
		if (messageErreur.equals("")) {

			Utilisateur adminModifier = new Utilisateur(admin.getIdUtilisateur(), admin.getNom(), admin.getPrenom(),
					admin.getMail(), mp);

			// appel de la modification
			UtilisateurManager.getInstance().updateAdministrateur(adminModifier);

			// modification de l'utilisateur en session
			req.getSession().removeAttribute("utilisateurConnecte");
			req.getSession().setAttribute("utilisateurConnecte", adminModifier);

			req.getSession().removeAttribute("administrateurConnecte");
			req.getSession().setAttribute("administrateurConnecte", adminModifier);

			// redirection
			resp.sendRedirect("AcceuilAdministrateur");
		} else {
			req.setAttribute("erreurs", messageErreur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierMDPAdmin.jsp").forward(req, resp);
		}
	}

	// validation du mot de passe
	public String validationMp(String oldmp, String newmp1, String newmp2, Utilisateur user) {
		// test de mot de passe
		
		if(oldmp.length()<3 || newmp1.length()<3 || newmp2.length()<3){
			messageErreur = "Les mots de passe doivent faire plus de 3 caractères.";
		}
		if (oldmp != null && newmp1 != null && newmp2 != null) {
			if (oldmp.equals(user.getPassword())) {
				if (newmp1.equals(newmp2)) {
					oldmp = newmp1;

					return oldmp;
				} else {
					messageErreur = "Les mots de passe ne concordent pas.";
				}
			} else {
				messageErreur = "L'ancien mot de passe est faux";
			}
		}
		return oldmp;
	}

}
