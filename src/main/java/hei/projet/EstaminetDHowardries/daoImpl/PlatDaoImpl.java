package hei.projet.EstaminetDHowardries.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.dao.PlatDao;
import hei.projet.EstaminetDHowardries.entite.Plat;
import hei.projet.EstaminetDHowardries.manager.PlatManager;

public class PlatDaoImpl implements PlatDao {

	public void ajouterPlat(Plat plat) {
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO `plat`( `nomPlat`, `descriptionPlat`, `prix`, `platDuJour`) VALUES (?,?,?,?)");
			stmt.setString(1, plat.getNomPlat());
			stmt.setString(2, plat.getDescriptionPlat());
			stmt.setFloat(3, plat.getPrixPlat());
			stmt.setBoolean(4, false);
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Plat getPlatDuJour() {
		Plat plat = new Plat();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `plat` WHERE platDuJour");
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				plat.setIdPlat(resultSet.getInt("idPlat"));
				plat.setNomPlat(resultSet.getString("nomPlat"));
				plat.setDescriptionPlat(resultSet.getString("descriptionPlat"));
				plat.setPlatDuJour(resultSet.getBoolean("platDuJour"));
				plat.setPrixPlat(resultSet.getFloat("prix"));
			}
			connection.close();
			return plat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Plat> listerPlat() {
		List<Plat> listePlat = new ArrayList<Plat>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM plat");

			while (results.next()) {
				Plat plat = new Plat();

				plat.setIdPlat(results.getInt("idPlat"));
				plat.setNomPlat(results.getString("nomPlat"));
				plat.setDescriptionPlat(results.getString("descriptionPlat"));
				plat.setPlatDuJour(results.getBoolean("platDuJour"));
				plat.setPrixPlat(results.getFloat("prix"));

				listePlat.add(plat);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listePlat;
	}

	public void deletePlat(int idPlat) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM `plat` WHERE `idPlat`=?");
			stmt.setInt(1, idPlat);

			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Plat getPlat(int idPlat) {
		Plat plat = new Plat();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `plat` WHERE idPlat=?");
			stmt.setInt(1, idPlat);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				plat.setIdPlat(resultSet.getInt("idPlat"));
				plat.setNomPlat(resultSet.getString("nomPlat"));
				plat.setDescriptionPlat(resultSet.getString("descriptionPlat"));
				plat.setPlatDuJour(resultSet.getBoolean("platDuJour"));
				plat.setPrixPlat(resultSet.getFloat("prix"));
			}
			connection.close();
			return plat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modifierPlat(Plat plat) {
		if(plat.getPlatDuJour()==null){
			plat.setPlatDuJour(false);
		}
		if (plat.getPlatDuJour() == true) {
			Plat plat2 = PlatManager.getInstance().getPlatDuJour();
			plat2.setPlatDuJour(false);
			PlatManager.getInstance().modifierPlat(plat2);
		}else{
			plat.setPlatDuJour(false);
		}
		
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE `plat` SET `nomPlat`=?,`descriptionPlat`=?,`prix`=?,`platDuJour`=? WHERE `idPlat`=?");
			stmt.setInt(5, plat.getIdPlat());
			stmt.setString(1, plat.getNomPlat());
			stmt.setString(2, plat.getDescriptionPlat());
			stmt.setBoolean(4, plat.getPlatDuJour());
			stmt.setFloat(3, plat.getPrixPlat());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void passerEnPlatDuJour(int idPlat) {
		Plat platDuJour = PlatManager.getInstance().getPlatDuJour();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE `plat` SET `platDuJour`=? WHERE `idPlat`=?");
			stmt.setBoolean(1, false);
			stmt.setInt(2, platDuJour.getIdPlat());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE `plat` SET `platDuJour`=? WHERE `idPlat`=?");
			stmt.setBoolean(1, true);
			stmt.setInt(2, idPlat);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
