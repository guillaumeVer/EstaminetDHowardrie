package hei.projet.EstaminetDHowardries.dao;

import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Horaire;

public interface HoraireDao {
	public List<Horaire> listerHoraire();

	public Horaire getUnHoraire(Integer idHoraire);
}
