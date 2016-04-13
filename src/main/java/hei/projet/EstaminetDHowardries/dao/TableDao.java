package hei.projet.EstaminetDHowardries.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Table;

public class TableDao {

	public List<Table> listerTable(){
		List<Table> listeTable=new ArrayList<Table>();
		 
		try{
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement(); 
				
		    ResultSet results = stmt.executeQuery("SELECT * FROM `table`"); 
			    while (results.next()) {
			    	Table table=new Table(results.getInt("idTable"),results.getString("nomTable"), results.getInt("nbPlace"));
			    	listeTable.add(table);
			            
			    } 
			    connection.close();         
		}
		catch (SQLException e) { 
			e.printStackTrace(); 
		}
		return listeTable;
		}
	
	public Table getUneTable(int idTable){
		Table table=new Table();
		try{
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement(); 
				
		    ResultSet results = stmt.executeQuery("SELECT * FROM `table` WHERE idTable ="+idTable); 
		    
			    while (results.next()) {
			    	table.setIdTable(idTable);
			    	table.setNomTable(results.getString("nomTable"));
			    	table.setNbPlace(results.getInt("nbPlace"));
			            
			    } 
			    connection.close();         
		}
		catch (SQLException e) { 
			e.printStackTrace(); 
		}
		return table;
		}
	}
