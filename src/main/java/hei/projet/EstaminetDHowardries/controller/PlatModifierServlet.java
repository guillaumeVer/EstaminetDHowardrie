package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Plat;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.PlatManager;

@WebServlet("/prive/admin/ModifierPlat")
public class PlatModifierServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	Integer id;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		String idPlat = req.getParameter("id");
		id = Integer.parseInt(idPlat);

		Plat plat = PlatManager.getInstance().getPlat(id);
		req.setAttribute("plat", plat);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/modifierplat.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Plat platmodifier =new Plat();
		
		platmodifier.setIdPlat(id);
		
		String nomPlat = req.getParameter("Nom");
		platmodifier.setNomPlat(nomPlat);
		
		String prix = req.getParameter("Prix");
		Float prixPlat = Float.parseFloat(prix);
		platmodifier.setPrixPlat(prixPlat);
		
		String description = req.getParameter("Description");
		platmodifier.setDescriptionPlat(description);
		
		String platDuJour = req.getParameter("PlatDuJour");
		
		if(platDuJour!=null){
			platmodifier.setPlatDuJour(true);
		}else{
			platmodifier.setPlatDuJour(false);
		}
		
		PlatManager.getInstance().modifierPlat(platmodifier);
		
		resp.sendRedirect("Plats");
	}

}
