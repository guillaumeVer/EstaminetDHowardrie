package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hei.projet.EstaminetDHowardries.entite.Boisson;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.BoissonManager;

@WebServlet("/prive/admin/ModifierBoisson")
public class BoissonModifierServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Integer id;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utilisateur admin = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("admin", admin);

		String idBoisson = req.getParameter("id");
		id = Integer.parseInt(idBoisson);

		Boisson boisson = BoissonManager.getInstance().getBoisson(id);
		req.setAttribute("boisson", boisson);

		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/modifierboisson.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Boisson boissonmodifier = new Boisson();

		boissonmodifier.setIdBoisson(id);

		String nomBoisson = req.getParameter("Nom");
		boissonmodifier.setNomBoisson(nomBoisson);

		String description = req.getParameter("Description");
		boissonmodifier.setDescriptionBoisson(description);

		String prix = req.getParameter("Prix");
		Float prixBoisson = Float.parseFloat(prix);
		boissonmodifier.setPrix(prixBoisson);

		String boissonDuMois = req.getParameter("BoissonDuMois");

		if (boissonDuMois != null) {
			boissonmodifier.setBoissonDuMois(true);
		}else{
			boissonmodifier.setBoissonDuMois(false);
		}

		BoissonManager.getInstance().modifierBoisson(boissonmodifier);
		resp.sendRedirect("Boissons");
	}

}
