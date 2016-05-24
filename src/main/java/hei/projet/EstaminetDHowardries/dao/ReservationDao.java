package hei.projet.EstaminetDHowardries.dao;

import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;

public interface ReservationDao {

	public void ajouterReservation(Reservation reservation);

	public List<Reservation> listerReservation();

	public List<Reservation> listerReservationParClient(int idClient);

	public List<Reservation> listerReservationParDateHoraire(String date, Horaire horaire);

	public void deleteReservation(Reservation reservation);

	public Reservation getReservationById(int idReservation);
}
