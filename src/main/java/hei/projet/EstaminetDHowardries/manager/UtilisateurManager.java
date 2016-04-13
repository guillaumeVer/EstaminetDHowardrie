package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.dao.UtilisateurDao;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;



public class UtilisateurManager {

private static UtilisateurManager inst;
	
	private UtilisateurDao userDao = new UtilisateurDao();

	public static UtilisateurManager getInstance() {
	    if (inst == null) {
	        inst = new UtilisateurManager();
	    }
	    return inst;
	}
	
	public List<Utilisateur> listerUtilisateur(){
		return userDao.listerUtilisateur();
	}
	
	public Utilisateur getUnUtilisateur(Integer iduser) {
		return userDao.getUnUtilisateur(iduser);
	}
	
	public void creatUtilisateur(Utilisateur utilisateur) {
		 userDao.creatUtilisateur(utilisateur);
	}
	
	public Utilisateur getUnUtilisateurbyNom(String nom){
		return userDao.getUnUtilisateurbyNom(nom);
	}
	
	public void deleteUser(Utilisateur user){
		userDao.deleteUser(user);
	}
	
}
