package hei.projet.EsaminetDHowardries.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hei.projet.EstaminetDHowardries.daoImpl.DataSourceProvider;
import hei.projet.EstaminetDHowardries.daoImpl.HoraireDaoImpl;
import hei.projet.EstaminetDHowardries.daoImpl.ReservationDaoImpl;
import hei.projet.EstaminetDHowardries.daoImpl.TableDaoImpl;
import hei.projet.EstaminetDHowardries.daoImpl.UtilisateurDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Reservation;

public class ReservationTestCase {

	ReservationDaoImpl reservationDao = new ReservationDaoImpl();
	TableDaoImpl tableDao = new TableDaoImpl();
	UtilisateurDaoImpl utilisateurDao = new UtilisateurDaoImpl();
	HoraireDaoImpl horaireDao = new HoraireDaoImpl();

	@Before
	public void initBdd() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM reservation");
		stmt.executeUpdate(
				"INSERT INTO `reservation`(`idReservation`, `idClient`, `idTable`, `idHoraire`, `Date`, `NomReservation`, `NbPersonne`) VALUES (1,1,1,1,'1996-10-10','gg',1)");
		stmt.executeUpdate(
				"INSERT INTO `reservation`(idReservation,idClient,idTable,idHoraire,Date ,`NomReservation`, `NbPersonne`) VALUES (2,2,2,2,'2016-10-10','gui',2)");
		stmt.close();
		connection.close();
	}

	@Test
	public void testerListerReservation() {
		List<Reservation> lstreservation = reservationDao.listerReservation();
		Assert.assertEquals(2, lstreservation.size());
		Assert.assertEquals(1, lstreservation.get(0).getIdReservation());
	
	}

	@Test
	public void testerSupprimerReservation() {
		List<Reservation> lstreservation = reservationDao.listerReservation();
		Assert.assertEquals(2, lstreservation.size());
		Reservation res = new Reservation(null, tableDao.getUneTable(1), horaireDao.getUnHoraire(1), null, "gg",
				5);
		reservationDao.ajouterReservation(res);
		List<Reservation> lstreservation1 = reservationDao.listerReservation();
		Assert.assertEquals(3, lstreservation1.size());

		Reservation resa = reservationDao.getReservationById(1);
		reservationDao.deleteReservation(resa);

		List<Reservation> lstreservation2 = reservationDao.listerReservation();
		Assert.assertEquals(2, lstreservation2.size());
	}

	@Test
	public void testerAjouterReservation() throws Exception {
		Reservation res = new Reservation();
		res.setNomReservation("gg");
		res.setTable(tableDao.getUneTable(1));
		res.setUtilisateur(utilisateurDao.getUnUtilisateur(1));
		res.setHoraire(horaireDao.getUnHoraire(1));
		res.setNbPersonne(5);
		reservationDao.ajouterReservation(res);

		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM `reservation` WHERE `NomReservation` = 'gg'");
		Assert.assertTrue(resultSet.next());
		Assert.assertEquals(1, resultSet.getInt("idTable"));
		Assert.assertEquals(1, resultSet.getInt("idHoraire"));
		stmt.close();
		connection.close();
	}

	@Test
	public void testergetReservationById() {
		Reservation res = reservationDao.getReservationById(2);
		Assert.assertEquals(2, res.getNbPersonne());
		Assert.assertEquals("gui", res.getNomReservation());
		Assert.assertEquals("2016-10-10", res.getDate());

	}
}
