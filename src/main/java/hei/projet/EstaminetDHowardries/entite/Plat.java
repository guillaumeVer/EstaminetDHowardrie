package hei.projet.EstaminetDHowardries.entite;

public class Plat {

	int idPlat;
	String nomPlat;
	Float prixPlat;
	String descriptionPlat;
	Boolean platDuJour;

	public Plat(int idPlat, Float prixPlat, String nomPlat, String descriptionPlat, Boolean platDuJour) {
		this.idPlat = idPlat;
		this.prixPlat = prixPlat;
		this.nomPlat = nomPlat;
		this.descriptionPlat = descriptionPlat;
		this.platDuJour = platDuJour;
	}

	public Plat(Float prixPlat, String nomPlat, String descriptionPlat, Boolean platDuJour) {
		this.prixPlat = prixPlat;
		this.nomPlat = nomPlat;
		this.descriptionPlat = descriptionPlat;
		this.platDuJour = platDuJour;
	}

	public Plat() {
	}

	public int getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(int idPlat) {
		this.idPlat = idPlat;
	}

	public String getNomPlat() {
		return nomPlat;
	}

	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}

	public Float getPrixPlat() {
		return prixPlat;
	}

	public void setPrixPlat(Float prixPlat) {
		this.prixPlat = prixPlat;
	}

	public String getDescriptionPlat() {
		return descriptionPlat;
	}

	public void setDescriptionPlat(String descriptionPlat) {
		this.descriptionPlat = descriptionPlat;
	}

	public Boolean getPlatDuJour() {
		return platDuJour;
	}

	public void setPlatDuJour(Boolean platDuJour) {
		this.platDuJour = platDuJour;
	}

}
