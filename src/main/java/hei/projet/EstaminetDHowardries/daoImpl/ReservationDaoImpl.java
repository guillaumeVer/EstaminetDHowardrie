package hei.projet.EstaminetDHowardries.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import hei.projet.EstaminetDHowardries.dao.ReservationDao;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;

public class ReservationDaoImpl implements ReservationDao {

	public void ajouterReservation(Reservation reservation) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO `reservation`(`idClient`, `idTable`, `idHoraire`, `Date`,`NomReservation`,`NbPersonne`) VALUES (?,?,?,?,?,?)");

			Utilisateur user = reservation.getUtilisateur();
			if (user != null) {
				stmt.setInt(1, reservation.getUtilisateur().getIdUtilisateur());
			} else {
				stmt.setInt(1, 0);
			}
			stmt.setInt(2, reservation.getTable().getIdTable());
			stmt.setInt(3, reservation.getHoraire().getIdHoraire());
			stmt.setDate(4, new Date(reservation.getDate().getTime()));
			stmt.setString(5, reservation.getNomReservation());
			stmt.setInt(6, reservation.getNbPersonne());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Reservation> listerReservation() {
		List<Reservation> listereservation = new ArrayList<Reservation>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM reservation ORDER BY Date");

			while (results.next()) {
				Reservation reservation = new Reservation();
				TableDaoImpl tableDao = new TableDaoImpl();
				HoraireDaoImpl horaireDao = new HoraireDaoImpl();
				UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();

				reservation.setIdReservation(results.getInt("idReservation"));

				int iduser = results.getInt("idClient");
				if (iduser == 0) {
					reservation.setUtilisateur(null);
				} else {
					reservation.setUtilisateur(userDao.getUnUtilisateur(results.getInt("idClient")));
				}

				reservation.setTable(tableDao.getUneTable(results.getInt("idTable")));
				reservation.setHoraire(horaireDao.getUnHoraire(results.getInt("idHoraire")));
				reservation.setDate(results.getDate("Date"));
				reservation.setNomReservation(results.getString("NomReservation"));
				reservation.setNbPersonne(results.getInt("NbPersonne"));

				listereservation.add(reservation);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listereservation;
	}

	public List<Reservation> listerReservationParClient(int idClient) {
		List<Reservation> listereservation = new ArrayList<Reservation>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `reservation` WHERE `idClient`=?");
			stmt.setInt(1, idClient);
			ResultSet results = stmt.executeQuery();

			while (results.next()) {
				Reservation reservation = new Reservation();
				TableDaoImpl tableDao = new TableDaoImpl();
				HoraireDaoImpl horaireDao = new HoraireDaoImpl();
				UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();

				reservation.setIdReservation(results.getInt("idReservation"));

				reservation.setUtilisateur(userDao.getUnUtilisateur(results.getInt("idClient")));

				reservation.setTable(tableDao.getUneTable(results.getInt("idTable")));
				reservation.setHoraire(horaireDao.getUnHoraire(results.getInt("idHoraire")));
				reservation.setDate(results.getDate("Date"));
				reservation.setNomReservation(results.getString("NomReservation"));
				reservation.setNbPersonne(results.getInt("NbPersonne"));

				listereservation.add(reservation);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listereservation;
	}

	public List<Reservation> listerReservationParDateHoraire(java.util.Date date, Horaire horaire) {
		List<Reservation> listereservation = new ArrayList<Reservation>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("SELECT * FROM reservation WHERE (`idHoraire` = ? AND `Date` = ?)");
			stmt.setInt(1, horaire.getIdHoraire());
			stmt.setDate(2, new Date(date.getTime()));
			ResultSet results = stmt.executeQuery();

			while (results.next()) {
				Reservation reservation = new Reservation();
				TableDaoImpl tableDao = new TableDaoImpl();
				HoraireDaoImpl horaireDao = new HoraireDaoImpl();
				UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();

				reservation.setIdReservation(results.getInt("idReservation"));

				int iduser = results.getInt("idClient");
				if (iduser == 0) {
					reservation.setUtilisateur(null);
				} else {
					reservation.setUtilisateur(userDao.getUnUtilisateur(results.getInt("idClient")));
				}

				reservation.setTable(tableDao.getUneTable(results.getInt("idTable")));
				reservation.setHoraire(horaireDao.getUnHoraire(results.getInt("idHoraire")));
				reservation.setDate(results.getDate("date"));
				reservation.setNomReservation(results.getString("NomReservation"));
				reservation.setNbPersonne(results.getInt("NbPersonne"));

				listereservation.add(reservation);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listereservation;
	}

	// suppression d'une reservation
	public void deleteReservation(Reservation reservation) {

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM `reservation` WHERE `idReservation`=?");

			stmt.setInt(1, reservation.getIdReservation());

			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Reservation getReservationById(int idReservation) {
		Reservation reservation = new Reservation();
		TableDaoImpl tableDao = new TableDaoImpl();
		HoraireDaoImpl horaireDao = new HoraireDaoImpl();
		UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM reservation WHERE idReservation = ?");
			stmt.setInt(1, idReservation);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				reservation.setIdReservation(resultSet.getInt("idReservation"));

				int iduser = resultSet.getInt("idClient");
				if (iduser == 0) {
					reservation.setUtilisateur(null);
				} else {
					reservation.setUtilisateur(userDao.getUnUtilisateur(resultSet.getInt("idClient")));
				}

				reservation.setTable(tableDao.getUneTable(resultSet.getInt("idTable")));
				reservation.setHoraire(horaireDao.getUnHoraire(resultSet.getInt("idHoraire")));
				reservation.setDate(resultSet.getDate("date"));
				reservation.setNomReservation(resultSet.getString("NomReservation"));
				reservation.setNbPersonne(resultSet.getInt("NbPersonne"));

			}
			connection.close();
			return reservation;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
