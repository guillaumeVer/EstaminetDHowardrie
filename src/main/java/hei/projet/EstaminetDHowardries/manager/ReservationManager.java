package hei.projet.EstaminetDHowardries.manager;

import java.util.List;
import java.util.Date;
import hei.projet.EstaminetDHowardries.daoImpl.ReservationDaoImpl;
import hei.projet.EstaminetDHowardries.entite.Horaire;
import hei.projet.EstaminetDHowardries.entite.Reservation;

public class ReservationManager {

	private static ReservationManager instance;

	private ReservationDaoImpl resDao = new ReservationDaoImpl();

	public static ReservationManager getInstance() {
		if (instance == null) {
			instance = new ReservationManager();
		}
		return instance;
	}

	public List<Reservation> listerReservation() {
		return resDao.listerReservation();
	}

	public void ajouterReservation(Reservation reservation) {
		resDao.ajouterReservation(reservation);
	}

	public Reservation getReservationById(int idReservation) {
		return resDao.getReservationById(idReservation);
	}

	public List<Reservation> listerReservationParCLient(int idClient) {
		return resDao.listerReservationParClient(idClient);
	}

	public List<Reservation> listerReservationParDateHoraire(Date date, Horaire horaire) {
		return resDao.listerReservationParDateHoraire(date, horaire);
	}

	public void SupprimerReservation(Reservation resa) {
		resDao.deleteReservation(resa);

	}
}
