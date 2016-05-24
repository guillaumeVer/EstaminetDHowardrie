package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.daoImpl.BoissonDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Boisson;

public class BoissonManager {

	private static BoissonManager instance;

	private BoissonDaoImpl boissonDao = new BoissonDaoImpl();

	public static BoissonManager getInstance() {
		if (instance == null) {
			instance = new BoissonManager();
		}
		return instance;
	}

	public void ajouterBoisson(Boisson boisson) {
		boissonDao.ajouterBoisson(boisson);
	}

	public Boisson getBoissonDuMois() {
		return boissonDao.getBoissonDuMois();
	}

	public List<Boisson> listerBoisson() {
		return boissonDao.listerBoisson();
	}

	public void deleteBoisson(int idBoisson) {
		boissonDao.deleteBoisson(idBoisson);
	}
	
	public void modifierBoisson(Boisson boisson){
		boissonDao.modifierBoisson(boisson);
	}
	
	public void passerEnBoissonDuMois(int idBoisson){
		boissonDao.passerEnBoissonDuMois(idBoisson);
	}

	public Boisson getBoisson(int id) {
		return boissonDao.getBoisson(id);
	}
}
