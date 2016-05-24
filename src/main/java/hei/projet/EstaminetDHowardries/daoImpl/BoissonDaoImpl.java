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
import hei.projet.EstaminetDHowardries.manager.BoissonManager;

public class BoissonDaoImpl implements BoissonDao {
	
	public void ajouterBoisson(Boisson boisson) {
		if (boisson.getBoissonDuMois() == true) {
			Boisson boisson2 = BoissonManager.getInstance().getBoissonDuMois();
			boisson2.setBoissonDuMois(false);
			BoissonManager.getInstance().modifierBoisson(boisson2);
		}
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO `boisson`(`nomBoisson`, `descriptionBoisson`, `prix`, `alcoolise`, `boissonDuMoi`) VALUES (?,?,?,?,?)");
			stmt.setString(1, boisson.getNomBoisson());
			stmt.setString(2, boisson.getDescriptionBoisson());
			stmt.setDouble(3, boisson.getPrix());
			stmt.setInt(4, 1);
			stmt.setBoolean(5, boisson.getBoissonDuMois());

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
				boisson.setPrix(resultSet.getFloat("prix"));
				boisson.setBoissonDuMois(resultSet.getBoolean("boissonDuMoi"));
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
				boisson.setPrix(results.getFloat("prix"));
				boisson.setBoissonDuMois(results.getBoolean("boissonDuMoi"));

				listeBoisson.add(boisson);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeBoisson;
	}

	public void modifierBoisson(Boisson boisson) {
		if(boisson.getBoissonDuMois()==null){
			boisson.setBoissonDuMois(false);
		}
		if (boisson.getBoissonDuMois() == true) {
			Boisson boisson2 = BoissonManager.getInstance().getBoissonDuMois();
			boisson2.setBoissonDuMois(false);
			BoissonManager.getInstance().modifierBoisson(boisson2);
		}else{
			boisson.setBoissonDuMois(false);
		}

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE `boisson` SET `nomBoisson`=?,`descriptionBoisson`=?,`prix`=?,`alcoolise`=?,`boissonDuMoi`=? WHERE `idBoisson`=?");

			stmt.setString(1, boisson.getNomBoisson());
			stmt.setString(2, boisson.getDescriptionBoisson());
			stmt.setDouble(3, boisson.getPrix());
			stmt.setInt(4, 1);
			stmt.setBoolean(5, boisson.getBoissonDuMois());
			stmt.setInt(6, boisson.getIdBoisson());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void passerEnBoissonDuMois(int idBoisson) {

		Boisson boissonDuMois = BoissonManager.getInstance().getBoissonDuMois();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `boisson` SET `boissonDuMoi`=? WHERE `idBoisson`=?");
			stmt.setBoolean(1, false);
			stmt.setInt(2, boissonDuMois.getIdBoisson());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE `boisson` SET `boissonDuMoi`=? WHERE `idBoisson`=?");
			stmt.setBoolean(1, true);
			stmt.setInt(2, idBoisson);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public Boisson getBoisson(int idBoisson) {
		Boisson boisson = new Boisson();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `boisson` WHERE idBoisson=?");
			stmt.setInt(1, idBoisson);
			
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				boisson.setIdBoisson(resultSet.getInt("idBoisson"));
				boisson.setNomBoisson(resultSet.getString("nomBoisson"));
				boisson.setDescriptionBoisson(resultSet.getString("descriptionBoisson"));
				boisson.setPrix(resultSet.getFloat("prix"));
				boisson.setBoissonDuMois(resultSet.getBoolean("boissonDuMoi"));
			}
			connection.close();
			return boisson;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
