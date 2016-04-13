package hei.projet.EstaminetDHowardries.entite;

import java.sql.Date;

public class Reservation {

	private int idReservation;
	private Utilisateur utilisateur;
	private Table table;
	private Horaire horaire;
	private String date;
	private String nomReservation;
	

	public Reservation(Utilisateur utilisateur, Table table, Horaire horaire, String date, String nomReservation){
		this.idReservation=idReservation;
		this.utilisateur=utilisateur;
		this.table=table;
		this.horaire=horaire;
		this.date=date;
		this.nomReservation=nomReservation;
	}
	
	public Reservation(Table table, Horaire horaire, String date, String nomReservation){
		this.idReservation=idReservation;
		this.utilisateur=utilisateur;
		this.table=table;
		this.horaire=horaire;
		this.date=date;
		this.nomReservation=nomReservation;
	}
	
	public Reservation(){
		this.idReservation=idReservation;
		this.utilisateur=utilisateur;
		this.table=table;
		this.horaire=horaire;
		this.date=date;
		this.nomReservation=nomReservation;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getNomReservation() {
		return nomReservation;
	}
	
	public void setNomReservation(String nomReservation) {
		this.nomReservation = nomReservation;
	}


	
	
}
