package hei.projet.EsaminetDHowardries.Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hei.projet.EstaminetDHowardries.daoImpl.DataSourceProvider;
import hei.projet.EstaminetDHowardries.daoImpl.TableDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Table;


public class TableDaoTestCase {

	private TableDaoImpl tableDao = new TableDaoImpl();
	
	@Before
	public void initBdd() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM `table`");
		stmt.executeUpdate("INSERT INTO `table`(idTable, nomTable, nbPlace) VALUES (1,'T1',5)");
		stmt.executeUpdate("INSERT INTO `table`(idTable, nomTable, nbPlace) VALUES (2,'T2',10)");
		stmt.close();
		connection.close();
	}

	@Test
	public void testerListerCitation() {
		List<Table> lstTable = tableDao.listerTable();
		Assert.assertEquals(2, lstTable.size());
		Assert.assertEquals("T1", lstTable.get(0).getNomTable());
		Assert.assertEquals(5, lstTable.get(0).getNbPlace());
	
		}
	
	@Test
	public void testergetUneTable(){
		Table table =tableDao.getUneTable(1);
		Assert.assertEquals(1, table.getIdTable());
		Assert.assertEquals("T1", table.getNomTable());
		Assert.assertEquals(5, table.getNbPlace());
		
		
	}
}
