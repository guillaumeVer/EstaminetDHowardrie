package hei.projet.EstaminetDHowardries.entite;

public class Table {
	
	private int idTable;
	private String nomTable;
	private int nbPlace;
	
	public Table(int idTable, String nomTable, int nbPlace){
		this.idTable=idTable;
		this.nomTable=nomTable;
		this.nbPlace=nbPlace;
	}
	public Table(){
		this.idTable=idTable;
		this.nomTable=nomTable;
		this.nbPlace=nbPlace;
	}

	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public String getNomTable() {
		return nomTable;
	}

	public void setNomTable(String nomTable) {
		this.nomTable = nomTable;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	
	
}
