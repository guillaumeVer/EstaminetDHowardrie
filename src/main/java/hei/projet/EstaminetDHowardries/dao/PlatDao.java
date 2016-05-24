package hei.projet.EstaminetDHowardries.dao;

import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Plat;

public interface PlatDao {
	public void ajouterPlat(Plat plat);

	public Plat getPlatDuJour();

	public List<Plat> listerPlat();

	public void deletePlat(int idPlat);

	public Plat getPlat(int idPlat);
	
	public void modifierPlat(Plat plat);
	
	public void passerEnPlatDuJour(int idPlat);
}
