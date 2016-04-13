package hei.projet.EsaminetDHowardries.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import hei.projet.EstaminetDHowardries.dao.DataSourceProvider;
import hei.projet.EstaminetDHowardries.dao.HoraireDao;
import hei.projet.EstaminetDHowardries.dao.ReservationDao;
import hei.projet.EstaminetDHowardries.dao.TableDao;
import hei.projet.EstaminetDHowardries.dao.UtilisateurDao;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;

public class ReservationTestCase {
	
	ReservationDao reservationDao= new ReservationDao();
	TableDao tableDao = new TableDao();
	UtilisateurDao utilisateurDao= new UtilisateurDao();
	HoraireDao horaireDao=new HoraireDao();
	
	@Before
	public void initBdd() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM reservation");
		stmt.executeUpdate("INSERT INTO `reservation`(idReservation,idClient,idTable,idHoraire,Date) VALUES (1,1,1,1,'1996-10-10')");
		stmt.executeUpdate("INSERT INTO `reservation`(idReservation,idClient,idTable,idHoraire,Date) VALUES (2,2,2,2,'2016-10-10')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testerListerReservation() {
		List<Reservation> lstreservation = reservationDao.listerReservation();
		Assert.assertEquals(2, lstreservation.size());
		Assert.assertEquals(1, lstreservation.get(0).getIdReservation());
		Assert.assertEquals(0, lstreservation.get(1).getUtilisateur().getIdUtilisateur());
	
		}
	
	
	
	@Test
	public void testerAjouterReservation() throws Exception{
		Reservation res = new Reservation();
			res.setDate("2017-09-06");
			res.setTable(tableDao.getUneTable(1));
			res.setUtilisateur(utilisateurDao.getUnUtilisateur(1));
			res.setHoraire(horaireDao.getUnHoraire(1));
			
			reservationDao.ajouterReservation(res);
			
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM `reservation` WHERE `idReservation` = 3");
		Assert.assertTrue(resultSet.next());
		Assert.assertEquals(1, resultSet.getInt("idTable"));
		Assert.assertEquals(1, resultSet.getInt("idHoraire"));
		Assert.assertFalse(resultSet.next());
		stmt.close();
		connection.close();
	}
	
	
}
