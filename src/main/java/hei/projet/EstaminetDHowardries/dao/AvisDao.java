package hei.projet.EstaminetDHowardries.dao;

import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Avis;

public interface AvisDao {

	public void ajouterAvis(Avis avis);

	public List<Avis> listerAvis();

}
