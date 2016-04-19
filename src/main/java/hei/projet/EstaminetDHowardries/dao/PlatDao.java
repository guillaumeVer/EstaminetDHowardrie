package hei.projet.EstaminetDHowardries.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Plat;
import hei.projet.EstaminetDHowardries.entite.Reservation;


public class PlatDao {

	public void ajouterPlat(Plat plat) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO `plat`(`idPlat`, `nomPlat`, `descriptionPlat`, `prix`, `platDuJour`) VALUES (?,?,?,?,?)");
			stmt.setString(2,plat.getNomPlat());
			stmt.setString(3, plat.getDescriptionPlat());
			stmt.setDouble(4,plat.getPrixPlat());
			stmt.setBoolean(5,plat.getPlatDuJour());
			
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Plat getPlat(int idPlat) {
		Plat plat=new Plat();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `plat` WHERE platDuJour");
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				plat.setIdPlat(resultSet.getInt("idPlat"));
				plat.setNomPlat(resultSet.getString("nomPlat"));
				plat.setDescriptionPlat(resultSet.getString("descriptionPlat"));
				plat.setPlatDuJour(resultSet.getBoolean("platDuJour"));
				plat.setPrixPlat(resultSet.getDouble("prixPlat"));
			}
			connection.close();
			return plat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
