package hei.projet.EstaminetDHowardries.entite;

public class Boisson {

	int idBoisson;
	String nomBoisson;
	String descriptionBoisson;
	Boolean alcoolise;
	Boolean boissonDuMoi;
	Double prix;
	
	public Boisson(int idBoisson, String nomBoisson, String descriptionBoisson, Boolean alcoolise, Boolean boissonDuMoi, Double prix){
		this.idBoisson=idBoisson;
		this.nomBoisson=nomBoisson;
		this.descriptionBoisson=descriptionBoisson;
		this.alcoolise=alcoolise;
		this.boissonDuMoi=boissonDuMoi;
		this.prix=prix;
	}
	
	public Boisson(){
		this.idBoisson=idBoisson;
		this.nomBoisson=nomBoisson;
		this.descriptionBoisson=descriptionBoisson;
		this.alcoolise=alcoolise;
		this.boissonDuMoi=boissonDuMoi;
		this.prix=prix;
	}

	public int getIdBoisson() {
		return idBoisson;
	}

	public void setIdBoisson(int idBoisson) {
		this.idBoisson = idBoisson;
	}

	public String getNomBoisson() {
		return nomBoisson;
	}

	public void setNomBoisson(String nomBoisson) {
		this.nomBoisson = nomBoisson;
	}

	public String getDescriptionBoisson() {
		return descriptionBoisson;
	}

	public void setDescriptionBoisson(String descriptionBoisson) {
		this.descriptionBoisson = descriptionBoisson;
	}

	public Boolean getAlcoolise() {
		return alcoolise;
	}

	public void setAlcoolise(Boolean alcoolise) {
		this.alcoolise = alcoolise;
	}

	public Boolean getBoissonDuMoi() {
		return boissonDuMoi;
	}

	public void setBoissonDuMoi(Boolean boissonDuMoi) {
		this.boissonDuMoi = boissonDuMoi;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	
}
