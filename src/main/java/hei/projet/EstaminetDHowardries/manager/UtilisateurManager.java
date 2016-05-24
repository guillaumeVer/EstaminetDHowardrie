package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.daoImpl.UtilisateurDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;

public class UtilisateurManager {

	private static UtilisateurManager inst;

	private UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();

	public static UtilisateurManager getInstance() {
		if (inst == null) {
			inst = new UtilisateurManager();
		}
		return inst;
	}

	public List<Utilisateur> listerUtilisateur() {
		return userDao.listerUtilisateur();
	}

	public Utilisateur getUnUtilisateur(Integer iduser) {
		return userDao.getUnUtilisateur(iduser);
	}

	public void creatUtilisateur(Utilisateur utilisateur) {
		userDao.creatUtilisateur(utilisateur);
	}

	public Utilisateur getUnUtilisateurbyNom(String nom) {
		return userDao.getUnUtilisateurbyNom(nom);
	}

	public void deleteUser(Utilisateur user) {
		userDao.deleteUser(user);
	}

	public Utilisateur getAdministrateur(String email) {
		return userDao.getAdministrateur(email);
	}

	public Utilisateur updateUser(Utilisateur user) {
		return userDao.updateUser(user);
	}

	public Utilisateur updateAdministrateur(Utilisateur user) {
		return userDao.updateAdministrateur(user);
	}
	
	public Utilisateur getUnUtilisateurbyMail(String mail){
		return userDao.getUnUtilisateurbyMail(mail);
	}
	
	public void creatAdministrateur(Utilisateur utilisateur){
		userDao.creatAdministrateur(utilisateur);
	}
}
