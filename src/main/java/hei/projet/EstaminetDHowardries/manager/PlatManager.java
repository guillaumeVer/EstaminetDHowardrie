package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.daoImpl.PlatDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Plat;

public class PlatManager {

	private static PlatManager instance;

	private PlatDaoImpl platDao = new PlatDaoImpl();

	public static PlatManager getInstance() {
		if (instance == null) {
			instance = new PlatManager();
		}
		return instance;
	}

	public Plat getPlat(int idPlat){
		return platDao.getPlat(idPlat);
	}
	
	public void ajouterPlat(Plat plat) {
		platDao.ajouterPlat(plat);
	}

	public Plat getPlatDuJour() {
		return platDao.getPlatDuJour();
	}

	public List<Plat> listerPlat() {
		return platDao.listerPlat();
	}

	public void deletePlat(int idPlat) {
		platDao.deletePlat(idPlat);
	}
	
	public void modifierPlat(Plat plat){
		platDao.modifierPlat(plat);
	}
	
	public void passerEnPlatDuJour(int idPlat){
		platDao.passerEnPlatDuJour(idPlat);
	}
}
