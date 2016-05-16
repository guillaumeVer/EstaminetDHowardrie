package hei.projet.EstaminetDHowardries.manager;

import java.util.List;

import hei.projet.EstaminetDHowardries.daoImpl.TableDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Table;

public class TableManager {
	private static TableManager inst;

	private TableDaoImpl tableDao = new TableDaoImpl();

	public static TableManager getInstance() {
		if (inst == null) {
			inst = new TableManager();
		}
		return inst;
	}

	public List<Table> listerTable() {
		return tableDao.listerTable();
	}

	public Table getUneTable(Integer idTable) {
		return tableDao.getUneTable(idTable);
	}
	
	public List<Table> listerTableLibre(String date, Horaire horaire) {
		return tableDao.listerTableLibre(date, horaire);
	}
}
