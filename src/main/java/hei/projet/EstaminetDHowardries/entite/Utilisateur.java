package hei.projet.EstaminetDHowardries.entite;

public class Utilisateur {
	
	private int idUtilisateur;
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	
	public Utilisateur( String nom, String prenom, String mail,String password){
		this.idUtilisateur=idUtilisateur;
		this.nom=nom;
		this.prenom=prenom;
		this.mail=mail;	
		this.password=password;
	}
	
	public Utilisateur(){
		this.idUtilisateur=idUtilisateur;
		this.nom=nom;
		this.prenom=prenom;
		this.mail=mail;	
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
}
