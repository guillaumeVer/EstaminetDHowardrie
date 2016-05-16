package hei.projet.EstaminetDHowardries.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.dao.BoissonDao;
import hei.projet.EstaminetDHowardries.entite.Boisson;

public class BoissonDaoImpl implements BoissonDao {
	public void ajouterBoisson(Boisson boisson) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO `boisson`(`idBoisson`, `nomBoisson`, `descriptionBoisson`, `prix`, `alcoolise`, `boissonDuMoi`) VALUES (?,?,?,?,?,?)");
			stmt.setString(2, boisson.getNomBoisson());
			stmt.setString(3, boisson.getDescriptionBoisson());
			stmt.setDouble(4, boisson.getPrix());
			stmt.setBoolean(5, boisson.getAlcoolise());
			stmt.setBoolean(6, boisson.getBoissonDuMois());

			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Boisson getBoissonDuMois() {
		Boisson boisson = new Boisson();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `boisson` WHERE boissonDuMoi");
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				boisson.setIdBoisson(resultSet.getInt("idBoisson"));
				boisson.setNomBoisson(resultSet.getString("nomBoisson"));
				boisson.setDescriptionBoisson(resultSet.getString("descriptionBoisson"));
				boisson.setPrix(resultSet.getDouble("prix"));
				boisson.setBoissonDuMois(resultSet.getBoolean("boissonDuMoi"));
				boisson.setAlcoolise(resultSet.getBoolean("alccolise"));
			}
			connection.close();
			return boisson;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Boisson> listerBoisson() {
		List<Boisson> listeBoisson = new ArrayList<Boisson>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM boisson");

			while (results.next()) {
				Boisson boisson = new Boisson();

				boisson.setIdBoisson(results.getInt("idBoisson"));
				boisson.setNomBoisson(results.getString("nomBoisson"));
				boisson.setDescriptionBoisson(results.getString("descriptionBoisson"));
				boisson.setPrix(results.getDouble("prix"));
				boisson.setBoissonDuMois(results.getBoolean("boissonDuMoi"));
				boisson.setAlcoolise(results.getBoolean("alccolise"));

				listeBoisson.add(boisson);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeBoisson;
	}

	public void deleteBoisson(int idBoisson) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM `boisson` WHERE `idBoisson`=?");
			stmt.setInt(1, idBoisson);

			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
