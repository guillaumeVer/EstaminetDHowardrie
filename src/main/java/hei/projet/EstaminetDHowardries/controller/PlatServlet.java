package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Plat;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.PlatManager;

@WebServlet("/prive/admin/Plats")
public class PlatServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		List<Plat> lstPlat = PlatManager.getInstance().listerPlat();
		req.setAttribute("listeDePlat", lstPlat);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/menuplat.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Plat plat =new Plat();
		
		String nomPlat = req.getParameter("nomPlat");
		plat.setNomPlat(nomPlat);
		
		String prix = req.getParameter("Prix");
		Float prixPlat = Float.parseFloat(prix);
		plat.setPrixPlat(prixPlat);
		
		String description = req.getParameter("Description");
		plat.setDescriptionPlat(description);
		
		String platDuJour = req.getParameter("PlatDuJour");
		
		if(platDuJour==null){
			plat.setPlatDuJour(false);
		}else{
			plat.setPlatDuJour(true);
		}
		

		PlatManager.getInstance().ajouterPlat(plat);
		resp.sendRedirect("Plats");

	}

}
