package hei.projet.EstaminetDHowardries.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Boisson;
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
	
	
	public Plat getPlatDuJour() {
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
	
	public List<Plat> listerPlat() {
		List<Plat> listePlat=new ArrayList<Plat>();
		
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement(); 	
		    ResultSet results = stmt.executeQuery("SELECT * FROM plat"); 
			
			while (results.next()) {
				Plat plat =new Plat();
				
				plat.setIdPlat(results.getInt("idPlat"));
				plat.setNomPlat(results.getString("nomPlat"));
				plat.setDescriptionPlat(results.getString("descriptionPlat"));
				plat.setPlatDuJour(results.getBoolean("platDuJour"));
				plat.setPrixPlat(results.getDouble("prixPlat"));
				
				
				listePlat.add(plat);
				
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listePlat;
	}
	
	public void deletePlat(int idPlat){
	try {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement(
				"DELETE FROM `plat` WHERE `idPlat`=?");
		stmt.setInt(1, idPlat);
		
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
}
