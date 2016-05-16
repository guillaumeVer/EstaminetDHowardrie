package hei.projet.EstaminetDHowardries.dao;

import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Table;

public interface TableDao {

	public List<Table> listerTable();

	public Table getUneTable(int idTable);

	public List<Table> listerTableLibre(String date, Horaire horaire);
}
