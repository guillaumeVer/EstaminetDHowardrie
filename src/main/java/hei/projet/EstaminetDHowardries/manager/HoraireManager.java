package hei.projet.EstaminetDHowardries.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


import hei.projet.EstaminetDHowardries.dao.HoraireDao;
import hei.projet.EstaminetDHowardries.entite.Horaire;

public class HoraireManager {

	private static HoraireManager instance;

	private TreeMap<Integer, Horaire> listeHoraire;

	public static HoraireManager getInstance() {
	    if (instance == null) {
	    	instance = new HoraireManager();
	    }
	    return instance;
	}
	
	private HoraireDao horaireDao = new HoraireDao();
	
	public List<Horaire> listerHoraire(){
		return horaireDao.listerHoraire();
	}

	public Horaire getUnHoraire(Integer idhoraire) {
		return horaireDao.getUnHoraire(idhoraire);
	}
}
