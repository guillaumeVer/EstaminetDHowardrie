package hei.projet.EstaminetDHowardries.entite;

public class Reservation {

	private int idReservation;
	private Utilisateur utilisateur;
	private Table table;
	private Horaire horaire;
	private String date;
	private String nomReservation;
	private int nbPersonne;

	public Reservation(Utilisateur utilisateur, Table table, Horaire horaire, String date, String nomReservation,
			int nbPersonne) {
		this.utilisateur = utilisateur;
		this.table = table;
		this.horaire = horaire;
		this.date = date;
		this.nomReservation = nomReservation;
		this.nbPersonne = nbPersonne;
	}

	public Reservation(Table table, Horaire horaire, String date, String nomReservation) {
		this.table = table;
		this.horaire = horaire;
		this.date = date;
		this.nomReservation = nomReservation;
	}

	public Reservation() {
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

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

}
