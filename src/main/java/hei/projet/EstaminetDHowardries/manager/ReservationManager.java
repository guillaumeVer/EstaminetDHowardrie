package hei.projet.EstaminetDHowardries.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


import hei.projet.EstaminetDHowardries.dao.ReservationDao;
import hei.projet.EstaminetDHowardries.entite.Reservation;

public class ReservationManager {

		private static ReservationManager instance;
		
		
		private ReservationDao resDao = new ReservationDao();
		
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
		
		public Reservation getReservation(int idUtilisateur){
			return resDao.getReservation(idUtilisateur);
		}
}
