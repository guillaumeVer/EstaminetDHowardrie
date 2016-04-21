package hei.projet.EstaminetDHowardries.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hei.projet.EstaminetDHowardries.dao.BoissonDao;
import hei.projet.EstaminetDHowardries.dao.DataSourceProvider;
import hei.projet.EstaminetDHowardries.entite.Boisson;

public class BoissonManager {

private static BoissonManager instance;
	
	
	private BoissonDao boissonDao = new BoissonDao();
	
	public static BoissonManager getInstance() {
	    if (instance == null) {
	        instance = new BoissonManager();
	    }
	    return instance;
	}
	
	public void ajouterBoisson(Boisson boisson) {
		boissonDao.ajouterBoisson(boisson);
	}
	
	public Boisson getBoissonDuMois(){
		return boissonDao.getBoissonDuMois();
	}
	
	public List<Boisson> listerBoisson(){
		return boissonDao.listerBoisson();
	}
	
	public void deleteBoisson(int idBoisson){
		boissonDao.deleteBoisson(idBoisson);
	}
}
