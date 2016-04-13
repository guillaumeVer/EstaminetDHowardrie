package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.dao.ReservationDao;
import hei.projet.EstaminetDHowardries.dao.TableDao;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Table;

public class TableManager {
	private static TableManager inst;
	
	private TableDao tableDao = new TableDao();

	public static TableManager getInstance() {
	    if (inst == null) {
	        inst = new TableManager();
	    }
	    return inst;
	}
	
	public List<Table> listerTable(){
		return tableDao.listerTable();
	}
	
	public Table getUneTable(Integer idTable) {
		return tableDao.getUneTable(idTable);
	}
}
