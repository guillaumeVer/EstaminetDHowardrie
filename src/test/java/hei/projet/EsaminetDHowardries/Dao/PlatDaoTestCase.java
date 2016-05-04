package hei.projet.EsaminetDHowardries.Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hei.projet.EstaminetDHowardries.dao.DataSourceProvider;
import hei.projet.EstaminetDHowardries.entite.Plat;
import hei.projet.EstaminetDHowardries.manager.PlatManager;


public class PlatDaoTestCase {


	@Before
	public void initBdd() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM `plat`");
		stmt.executeUpdate("INSERT INTO `plat` (`idPlat`, `nomPlat`, `descriptionPlat`, `prix`, `platDuJour`) VALUES(1, 'Welsch', '', 12.5, 1)");
		stmt.executeUpdate("INSERT INTO `plat` (`idPlat`, `nomPlat`, `descriptionPlat`, `prix`, `platDuJour`) VALUES(2, 'Pavé De Boeuf', '', 10, 0)");
		stmt.executeUpdate("INSERT INTO `plat` (`idPlat`, `nomPlat`, `descriptionPlat`, `prix`, `platDuJour`) VALUES(3, 'Salade César', '', 9.6, 0)");
				stmt.close();
		connection.close();
	}
	
	@Test
	public void testerListerPlat() {
		List<Plat> lstPlat = PlatManager.getInstance().listerPlat();
		Assert.assertEquals(3, lstPlat.size());
		Assert.assertEquals(1, lstPlat.get(0).getIdPlat());
		Assert.assertEquals("Pavé De Boeuf", lstPlat.get(1).getNomPlat());
	
		}
}
