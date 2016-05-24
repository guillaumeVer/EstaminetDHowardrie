package hei.projet.EstaminetDHowardries.dao;

import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Utilisateur;

public interface UtilisateurDao {

	// Creation d'un utilisateur
	public void creatUtilisateur(Utilisateur utilisateur);
	
	// Creation d'un administrateur
	public void creatAdministrateur(Utilisateur utilisateur);

	// Listage des utilisateur autre que administrateur
	public List<Utilisateur> listerUtilisateur();

	// recuperation d'un utilisateur par l'id
	public Utilisateur getUnUtilisateur(int idUtilisateur);

	// recuperation d'un utilisateur pas son son nom
	public Utilisateur getUnUtilisateurbyNom(String nom);

	// suppression d'un utilisateur
	public void deleteUser(Utilisateur user);

	// recuperation de l'administrateur
	public Utilisateur getAdministrateur(String email);

	// Modification de l'utilisateur
	public Utilisateur updateUser(Utilisateur user);

	// modification administrateur
	public Utilisateur updateAdministrateur(Utilisateur user);
	
	//recuperer un utilisateur via mail
	public Utilisateur getUnUtilisateurbyMail(String mail);

	
}
