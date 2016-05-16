package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.daoImpl.HoraireDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Horaire;

public class HoraireManager {

	private static HoraireManager instance;

	public static HoraireManager getInstance() {
		if (instance == null) {
			instance = new HoraireManager();
		}
		return instance;
	}

	private HoraireDaoImpl horaireDao = new HoraireDaoImpl();

	public List<Horaire> listerHoraire() {
		return horaireDao.listerHoraire();
	}

	public Horaire getUnHoraire(Integer idhoraire) {
		return horaireDao.getUnHoraire(idhoraire);
	}
}
