package hei.projet.EstaminetDHowardries.entite;

public class Horaire {

	private Integer idHoraire;
	private String intervalle;

	public Horaire(Integer idHoraire, String intervalle) {
		this.idHoraire = idHoraire;
		this.intervalle = intervalle;
	}

	public Horaire() {
	}

	public Integer getIdHoraire() {
		return idHoraire;
	}

	public void setIdHoraire(Integer idHoraire) {
		this.idHoraire = idHoraire;
	}

	public String getIntervalle() {
		return intervalle;
	}

	public void setIntervalle(String intervalle) {
		this.intervalle = intervalle;
	}

}
