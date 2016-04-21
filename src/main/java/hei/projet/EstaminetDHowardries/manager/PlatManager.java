package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.dao.PlatDao;
import hei.projet.EstaminetDHowardries.entite.Plat;
import hei.projet.EstaminetDHowardries.entite.Reservation;

public class PlatManager {

	private static PlatManager instance;
	
	
	private PlatDao platDao = new PlatDao();
	
	public static PlatManager getInstance() {
	    if (instance == null) {
	        instance = new PlatManager();
	    }
	    return instance;
	}
	
	public void ajouterPlat(Plat plat) {
		platDao.ajouterPlat(plat);
	}
	
	public Plat getPlatDuJour(){
		return platDao.getPlatDuJour();
	}
	
	public List<Plat> listerPlat(){
		return platDao.listerPlat();
	}
	
	public void deletePlat(int idPlat){
		platDao.deletePlat(idPlat);
	}
}
