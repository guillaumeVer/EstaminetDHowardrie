package hei.projet.EstaminetDHowardries.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;

public class ReservationDao {

	public void ajouterReservation(Reservation reservation) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO `reservation`(`idClient`, `idTable`, `idHoraire`, `Date`,`NomReservation`,`NbPersonne`) VALUES (?,?,?,?,?,?)");
			List<Reservation> lstReservation = listerReservation();

			Utilisateur user = reservation.getUtilisateur();
			if(user!=null){
				stmt.setInt(1, reservation.getUtilisateur().getIdUtilisateur());
			}else{
				stmt.setInt(1,0);
			}
			stmt.setInt(2, reservation.getTable().getIdTable());
			stmt.setInt(3, reservation.getHoraire().getIdHoraire());
			stmt.setString(4,reservation.getDate());
			stmt.setString(5, reservation.getNomReservation());
			stmt.setInt(6, reservation.getNbPersonne());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Reservation getReservation(int idUtilisateur) {
		Reservation reservation = new Reservation();
		TableDao tableDao = new TableDao();
		HoraireDao horaireDao = new HoraireDao();
		UtilisateurDao userDao=new UtilisateurDao();
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM reservation WHERE idClient = ?");
			stmt.setInt(1,idUtilisateur);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				reservation.setIdReservation(resultSet.getInt("idReservation"));
				
				int iduser = resultSet.getInt("idClient");
				if(iduser==0){
					reservation.setUtilisateur(null);
				}else{
					reservation.setUtilisateur(userDao.getUnUtilisateur(resultSet.getInt("idClient")));
				}
				
				reservation.setTable(tableDao.getUneTable(resultSet.getInt("idTable")));
				reservation.setHoraire(horaireDao.getUnHoraire(resultSet.getInt("idHoraire")));
				reservation.setDate(resultSet.getDate("date").toString());
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
	
	public List<Reservation> listerReservation() {
		List<Reservation> listereservation=new ArrayList<Reservation>();
		
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement(); 	
		    ResultSet results = stmt.executeQuery("SELECT * FROM reservation"); 
			
			while (results.next()) {
				Reservation reservation =new Reservation();
				TableDao tableDao = new TableDao();
				HoraireDao horaireDao = new HoraireDao();
				UtilisateurDao userDao=new UtilisateurDao();
				
				reservation.setIdReservation(results.getInt("idReservation"));
			
				int iduser = results.getInt("idClient");
				if(iduser==0){
					reservation.setUtilisateur(null);
				}else{
					reservation.setUtilisateur(userDao.getUnUtilisateur(results.getInt("idClient")));
				}
				
				reservation.setTable(tableDao.getUneTable(results.getInt("idTable")));
				reservation.setHoraire(horaireDao.getUnHoraire(results.getInt("idHoraire")));
				reservation.setDate(results.getDate("date").toString());
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
	
	public List<Reservation> listerReservationParClient(int idUtilisateur) {
		List<Reservation> listereservation=new ArrayList<Reservation>();
		
		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM reservation WHERE idClient = ?");
			stmt.setInt(1,idUtilisateur);
			ResultSet results = stmt.executeQuery();
			
			while (results.next()) {
				Reservation reservation =new Reservation();
				TableDao tableDao = new TableDao();
				HoraireDao horaireDao = new HoraireDao();
				UtilisateurDao userDao=new UtilisateurDao();
				
				reservation.setIdReservation(results.getInt("idReservation"));
			
				int iduser = results.getInt("idClient");
				if(iduser==0){
					reservation.setUtilisateur(null);
				}else{
					reservation.setUtilisateur(userDao.getUnUtilisateur(results.getInt("idClient")));
				}
				
				reservation.setTable(tableDao.getUneTable(results.getInt("idTable")));
				reservation.setHoraire(horaireDao.getUnHoraire(results.getInt("idHoraire")));
				reservation.setDate(results.getDate("date").toString());
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
}
