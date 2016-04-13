package hei.projet.EsaminetDHowardries.Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hei.projet.EstaminetDHowardries.dao.DataSourceProvider;
import hei.projet.EstaminetDHowardries.dao.HoraireDao;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Table;


public class HoraireDaoTestCase {

	
	private HoraireDao horaireDao = new HoraireDao();

	@Before
	public void initBdd() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM horaire");
		stmt.executeUpdate("INSERT INTO `horaire`(idhoraire, intervalle) VALUES (1,'18h30-19h30')");
		stmt.executeUpdate("INSERT INTO `horaire`(idhoraire, intervalle) VALUES (2,'19h30-20h30')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testerListerHoraire() {
		List<Horaire> lsthoraire = horaireDao.listerHoraire();
		Assert.assertEquals(2, lsthoraire.size());
		//Assert.assertEquals(1, lsthoraire.get(0).getIdHoraire());
		Assert.assertEquals("19h30-20h30", lsthoraire.get(1).getIntervalle());
	
		}

	
	@Test
	public void testergetUnHoraire(){
		Horaire horaire =horaireDao.getUnHoraire(1);
		//Assert.assertEquals(1, horaire.getIdHoraire());
		Assert.assertEquals("18h30-19h30", horaire.getIntervalle());
		
		
		
	}
}
