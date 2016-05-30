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
	public void testergetUnUtilisateurbyMail() {
		Utilisateur user = utilisateurDao.getUnUtilisateurbyNom("Gg");
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
	public void testercreatUtilisateur(){
		List<Utilisateur> lstuser0 = utilisateurDao.listerUtilisateur();
		Assert.assertEquals(1, lstuser0.size());
		Utilisateur user = new Utilisateur(null, "nom1","prenom1", "mail@hei.fr", "password");
		utilisateurDao.creatUtilisateur(user);
		List<Utilisateur> lstuser = utilisateurDao.listerUtilisateur();
		Assert.assertEquals(2, lstuser.size());
	}
	
	@Test
	public void testerdeleteUser(){
		Utilisateur user = new Utilisateur(null,"nom1","prenom1", "mail@hei.fr", "password");
		utilisateurDao.creatUtilisateur(user);
		List<Utilisateur> lstuser = utilisateurDao.listerUtilisateur();
		Assert.assertEquals(2, lstuser.size());
		Utilisateur utilisateur = utilisateurDao.getUnUtilisateurbyNom("nom1");
		utilisateurDao.deleteUser(utilisateur);
		List<Utilisateur> lstuser2 = utilisateurDao.listerUtilisateur();
		Assert.assertEquals(1, lstuser2.size());
	}
	
	@Test
	public void testerUpdateUser(){
		Utilisateur user = new Utilisateur(null,"nom1","prenom1", "mail@hei.fr", "password");
		utilisateurDao.creatUtilisateur(user);
		Utilisateur utilisateur = utilisateurDao.getUnUtilisateurbyNom("nom1");
		Assert.assertEquals("prenom1",utilisateur.getPrenom());
		utilisateur.setPrenom("coucou");
		utilisateurDao.updateUser(utilisateur);
		Assert.assertEquals("coucou",utilisateurDao.getUnUtilisateurbyNom("nom1").getPrenom());
	}
	
	@Test
	public void testergetAdministrateur() {
		Utilisateur user = utilisateurDao.getAdministrateur("verjotg@gmail.com");
		Assert.assertEquals("admin", user.getPrenom());
		Assert.assertEquals("verjotg@gmail.com", user.getMail());
	}

}
