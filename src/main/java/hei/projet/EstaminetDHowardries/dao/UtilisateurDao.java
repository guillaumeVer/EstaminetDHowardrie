package hei.projet.EstaminetDHowardries.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Table;
import hei.projet.EstaminetDHowardries.entite.Utilisateur;

public class UtilisateurDao {

	public Utilisateur getUnUtilisateur(int idUtilisateur){
		Utilisateur user=new Utilisateur();
		try{
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement(); 
				
		    ResultSet results = stmt.executeQuery("SELECT * FROM `utilisateur` WHERE idUtilisateur ="+idUtilisateur); 
		    
			    while (results.next()) {
			    	user.setIdUtilisateur(idUtilisateur);
			    	user.setNom(results.getString("Nom"));
			    	user.setPrenom(results.getString("Prenom"));
			    	user.setMail(results.getString("Mail"));
			    	
			            
			    } 
			    connection.close();         
		}
		catch (SQLException e) { 
			e.printStackTrace(); 
		}
		return user;
		}
	
	public void creatUtilisateur(Utilisateur utilisateur){
		List<Utilisateur> lstUser= listerUtilisateur();
		try{
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO utilisateur(Nom, Prenom, Mail,password) VALUES (?,?,?,?)");
		
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
	
	public List<Utilisateur> listerUtilisateur(){
		List<Utilisateur> listeUtilisateur=new ArrayList<Utilisateur>();
		 
		try{
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement(); 
				
		    ResultSet results = stmt.executeQuery("SELECT * FROM `utilisateur`"); 
			    while (results.next()) {
			    	Utilisateur user = new Utilisateur(results.getString("Nom"),results.getString("Prenom"),results.getString("Mail"),results.getString("password"));
			    	user.setIdUtilisateur(results.getInt("IdUtilisateur")); 
			    	
			    	listeUtilisateur.add(user);
			    }
			   
			    connection.close();         
		}
		catch (SQLException e) { 
			e.printStackTrace(); 
		}
		return listeUtilisateur;
		}
	
	public Utilisateur getUnUtilisateurbyNom(String nom){
		Utilisateur user=new Utilisateur();
		try{
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT `IdUtilisateur`, `Nom`, `Prenom`, `password`, `Mail` FROM `utilisateur` WHERE `Nom`=?");
		
			stmt.setString(1, nom);
			ResultSet results = stmt.executeQuery();

			    while (results.next()) {
			    	user.setIdUtilisateur(results.getInt("IdUtilisateur"));
			    	user.setNom(results.getString("Nom"));
			    	user.setPrenom(results.getString("Prenom"));
			    	user.setMail(results.getString("Mail"));
			    	user.setPassword(results.getString("password"));
			    	
			            
			    } 
			    connection.close();         
		}
		catch (SQLException e) { 
			e.printStackTrace(); 
		}
		return user;
		}
	
	public void deleteUser(Utilisateur user){
		
		try{
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement(
					"DELETE FROM `utilisateur` WHERE IdUtilisateur=?");
		
			stmt.setInt(1, user.getIdUtilisateur());
		
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

