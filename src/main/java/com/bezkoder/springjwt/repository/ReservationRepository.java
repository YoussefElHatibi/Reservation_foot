package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.enums.ReservationStatut;
import com.bezkoder.springjwt.models.Reservation;
import com.bezkoder.springjwt.models.Terrain;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByDateAndTerrain(Date date, Terrain terrain);
    List<Reservation> findByUser(User user);
    List<Reservation> findAllByStatut(ReservationStatut reservationStatut);
}
