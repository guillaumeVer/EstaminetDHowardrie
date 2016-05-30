package hei.projet.EstaminetDHowardries.dao;

import java.util.Date;
import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Table;

public interface TableDao {

	public List<Table> listerTable();

	public Table getUneTable(int idTable);

	public List<Table> listerTableLibre(Date date, Horaire horaire);
}
