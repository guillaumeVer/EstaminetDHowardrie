package hei.projet.EstaminetDHowardries.entite;

public class Avis {

	int idAvis;
	String commentaire;
	int note;

	public Avis(String commentaire, int note) {
		this.commentaire = commentaire;
		this.note = note;
	}

	public Avis() {
	}

	public int getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(int idAvis) {
		this.idAvis = idAvis;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

}
