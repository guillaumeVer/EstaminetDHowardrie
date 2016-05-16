package hei.projet.EstaminetDHowardries.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.dao.TableDao;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Table;
import hei.projet.EstaminetDHowardries.manager.ReservationManager;
import hei.projet.EstaminetDHowardries.manager.TableManager;

public class TableDaoImpl implements TableDao {

	public List<Table> listerTable() {
		List<Table> listeTable = new ArrayList<Table>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM `table`");
			while (results.next()) {
				Table table = new Table(results.getInt("idTable"), results.getString("nomTable"),
						results.getInt("nbPlace"));
				listeTable.add(table);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeTable;
	}

	public Table getUneTable(int idTable) {
		Table table = new Table();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM `table` WHERE idTable =" + idTable);

			while (results.next()) {
				table.setIdTable(idTable);
				table.setNomTable(results.getString("nomTable"));
				table.setNbPlace(results.getInt("nbPlace"));

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public List<Table> listerTableLibre(String date, Horaire horaire) {
		List<Reservation> lstResa = ReservationManager.getInstance().listerReservationParDateHoraire(date, horaire);
		List<Table> lstTableTrier = new ArrayList<Table>();
		List<Table> lstTable = TableManager.getInstance().listerTable();

		if (lstResa.size() == 0) {
			return lstTable;	
		} else {
			if (lstResa.size() == lstTable.size()) {
				return null;
			} else {
				Boolean tablelibre = null;
				
				for (int i = 0; i < lstTable.size(); i++) {
					int j = 0;
					int t = 0;
					while ((j < lstResa.size() && t == 0)) {
						if (lstResa.get(j).getTable().getIdTable() != lstTable.get(i).getIdTable()) {
							tablelibre = true;
							j++;
							t = 0;
						} else {
							System.out.println(i+""+j);
							tablelibre = false;
							t = 1;
						}
					}
					if (tablelibre) {
						lstTableTrier.add(lstTable.get(i));
						System.out.println(lstTable.get(i).getIdTable());
					}

				}
				
			}
		}
	return 	lstTableTrier;
	}
	
}
