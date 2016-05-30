package hei.projet.EstaminetDHowardries.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.dao.UtilisateurDao;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;
import hei.projet.EstaminetDHowardries.manager.UtilisateurManager;

public class UtilisateurDaoImpl implements UtilisateurDao {

	// Creation d'un utilisateur
	public void creatUtilisateur(Utilisateur utilisateur) {

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO utilisateur(Nom, Prenom, Mail,password,`Administrateur`) VALUES (?,?,?,?,0)");

			stmt.setString(1, utilisateur.getNom());
			stmt.setString(2, utilisateur.getPrenom());
			stmt.setString(3, utilisateur.getMail());
			stmt.setString(4, utilisateur.getPassword());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Creation d'un administrateur
	public void creatAdministrateur(Utilisateur utilisateur) {

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO utilisateur(Nom, Prenom, Mail,password,`Administrateur`) VALUES (?,?,?,?,1)");

			stmt.setString(1, utilisateur.getNom());
			stmt.setString(2, utilisateur.getPrenom());
			stmt.setString(3, utilisateur.getMail());
			stmt.setString(4, utilisateur.getPassword());
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Listage des utilisateur autre que administrateur
	public List<Utilisateur> listerUtilisateur() {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();

			ResultSet results = stmt.executeQuery("SELECT * FROM `utilisateur` WHERE NOT Administrateur");
			while (results.next()) {
				Utilisateur user = new Utilisateur(results.getInt("idUtilisateur"), results.getString("Nom"),
						results.getString("Prenom"), results.getString("Mail"), results.getString("password"));
				user.setIdUtilisateur(results.getInt("IdUtilisateur"));

				listeUtilisateur.add(user);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateur;
	}

	// recuperation d'un utilisateur par l'id
	public Utilisateur getUnUtilisateur(int idUtilisateur) {

		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `utilisateur` WHERE idUtilisateur = ?");
			stmt.setInt(1, idUtilisateur);

			ResultSet results = stmt.executeQuery();

			if (results.next()) {

				Utilisateur user = new Utilisateur(idUtilisateur, results.getString("Nom"), results.getString("Prenom"),
						results.getString("Mail"), results.getString("Password"));

				return user;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// recuperation d'un utilisateur pas son son nom
	public Utilisateur getUnUtilisateurbyNom(String nom) {
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT `IdUtilisateur`, `Nom`, `Prenom`, `password`, `Mail` FROM `utilisateur` WHERE `Nom`=?");

			stmt.setString(1, nom);
			ResultSet results = stmt.executeQuery();

			if (results.next()) {

				Utilisateur user = new Utilisateur(results.getInt("idUtilisateur"), results.getString("Nom"),
						results.getString("Prenom"), results.getString("Mail"), results.getString("Password"));

				return user;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Utilisateur getUnUtilisateurbyMail(String email) {
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT `IdUtilisateur`, `Nom`, `Prenom`, `password`, `Mail` FROM `utilisateur` WHERE `Mail`=?");

			stmt.setString(1, email);
			ResultSet results = stmt.executeQuery();

			if (results.next()) {

				Utilisateur user = new Utilisateur(results.getInt("idUtilisateur"), results.getString("Nom"),
						results.getString("Prenom"), results.getString("Mail"), results.getString("Password"));

				return user;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// suppression d'un utilisateur
	public void deleteUser(Utilisateur user) {

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM `utilisateur` WHERE IdUtilisateur=?");

			stmt.setInt(1, user.getIdUtilisateur());

			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// recuperation de l'administrateur
	public Utilisateur getAdministrateur(String email) {
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM `utilisateur` WHERE Administrateur && Mail=?");

			stmt.setString(1, email);
			ResultSet results = stmt.executeQuery();

			if (results.next()) {

				Utilisateur user = new Utilisateur(results.getInt("idUtilisateur"), results.getString("Nom"),
						results.getString("Prenom"), results.getString("Mail"), results.getString("Password"));

				return user;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Modification de l'utilisateur
	public Utilisateur updateUser(Utilisateur user) {

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE `utilisateur` SET `IdUtilisateur`=?,`Nom`=?,`Prenom`=?,`password`=?,`Mail`=?,`Administrateur`=? WHERE IdUtilisateur=?");

			stmt.setInt(1, user.getIdUtilisateur());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getMail());
			stmt.setBoolean(6, false);
			stmt.setInt(7, user.getIdUtilisateur());
			stmt.executeUpdate();

			Utilisateur newuser = UtilisateurManager.getInstance().getUnUtilisateur(user.getIdUtilisateur());
			connection.close();
			return newuser;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// modification administrateur
	public Utilisateur updateAdministrateur(Utilisateur user) {

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE `utilisateur` SET `IdUtilisateur`=?,`Nom`=?,`Prenom`=?,`password`=?,`Mail`=?,`Administrateur`=? WHERE IdUtilisateur=?");

			stmt.setInt(1, user.getIdUtilisateur());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getMail());
			stmt.setBoolean(6, true);
			stmt.setInt(7, user.getIdUtilisateur());
			stmt.executeUpdate();

			Utilisateur newuser = UtilisateurManager.getInstance().getUnUtilisateur(user.getIdUtilisateur());
			connection.close();
			return newuser;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
