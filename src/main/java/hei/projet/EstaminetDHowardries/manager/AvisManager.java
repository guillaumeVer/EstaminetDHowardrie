package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.daoImpl.AvisDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Avis;

public class AvisManager {
	private static AvisManager instance;

	private AvisDaoImpl avisDao = new AvisDaoImpl();

	public static AvisManager getInstance() {
		if (instance == null) {
			instance = new AvisManager();
		}
		return instance;
	}

	public void ajouterAvis(Avis avis) {
		avisDao.ajouterAvis(avis);
	}

	public List<Avis> listerAvis() {
		return avisDao.listerAvis();
	}
}
