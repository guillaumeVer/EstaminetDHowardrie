package hei.projet.EsaminetDHowardries.Dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hei.projet.EstaminetDHowardries.daoImpl.DataSourceProvider;
import hei.projet.EstaminetDHowardries.daoImpl.UtilisateurDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;



public class UtilisateurDaoTestCase {

	UtilisateurDaoImpl utilisateurDao = new UtilisateurDaoImpl();
	@Before
	public void initBdd() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM utilisateur");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`IdUtilisateur`, `Nom`, `Prenom`, `Mail`, `password`,`Administrateur`) VALUES (1,'Gg','vg','guillaume.verjot@hei.fr','gg',0)");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`IdUtilisateur`, `Nom`, `Prenom`, `Mail`, `password`,`Administrateur`) VALUES (2,'admin','admin','verjotg@gmail.com','admin',1)");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testergetUnUtilisateurbyMail(){
		Utilisateur user=utilisateurDao.getUnUtilisateurbyNom("Gg");
		Assert.assertEquals("vg", user.getPrenom());
		Assert.assertEquals("guillaume.verjot@hei.fr", user.getMail());
	}
	
	@Test
	public void testerListerUtilisateur() {
		List<Utilisateur> lstuser = utilisateurDao.listerUtilisateur();
		Assert.assertEquals(1, lstuser.size());
		Assert.assertEquals("gg", lstuser.get(0).getPassword());
		Assert.assertEquals("guillaume.verjot@hei.fr", lstuser.get(0).getMail());
	
		}
	
	@Test
	public void testergetAdministrateur(){
		Utilisateur user=utilisateurDao.getAdministrateur();
		Assert.assertEquals("admin", user.getPrenom());
		Assert.assertEquals("verjotg@gmail.com", user.getMail());
	}

}
