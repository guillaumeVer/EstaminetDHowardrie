package hei.projet.EstaminetDHowardries.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;

@WebServlet("/prive/Deconnexion")
public class DeconnexionServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2793586799100543352L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utilisateur user = (Utilisateur) req.getSession().getAttribute("administrateurConnecte");
		req.setAttribute("user", user);

		HttpSession session = req.getSession();
		session.invalidate();

		resp.sendRedirect("../Index");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
