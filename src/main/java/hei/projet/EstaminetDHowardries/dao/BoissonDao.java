package hei.projet.EstaminetDHowardries.dao;

import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Boisson;

public interface BoissonDao {
	
	public void ajouterBoisson(Boisson boisson);

	public Boisson getBoissonDuMois();

	public List<Boisson> listerBoisson();

	public void deleteBoisson(int idBoisson);
}