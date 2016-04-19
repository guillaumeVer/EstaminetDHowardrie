package hei.projet.EstaminetDHowardries.manager;

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
	
	public void ajouterReservation(Plat plat) {
		platDao.ajouterPlat(plat);
	}
	
	public Plat getPlat(int idPlat){
		return platDao.getPlat(idPlat);
	}
}
