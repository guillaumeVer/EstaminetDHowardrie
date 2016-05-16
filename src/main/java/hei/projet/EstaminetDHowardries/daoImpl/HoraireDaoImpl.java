package hei.projet.EstaminetDHowardries.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.dao.HoraireDao;
import hei.projet.EstaminetDHowardries.entite.Horaire;

public class HoraireDaoImpl implements HoraireDao {

	public List<Horaire> listerHoraire() {
		List<Horaire> listeHoraire = new ArrayList<Horaire>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM horaire");
			while (results.next()) {
				Horaire horaire = new Horaire(results.getInt("idHoraire"), results.getString("intervalle"));
				listeHoraire.add(horaire);

			}
			connection.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return listeHoraire;
	}

	public Horaire getUnHoraire(Integer idHoraire) {
		Horaire horaire = new Horaire();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM `horaire` WHERE idHoraire =" + idHoraire);

			while (results.next()) {
				horaire.setIdHoraire(idHoraire);
				horaire.setIntervalle(results.getString("intervalle"));

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horaire;
	}
}
