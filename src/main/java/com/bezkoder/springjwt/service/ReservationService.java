package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.dto.ReservationDto;
import com.bezkoder.springjwt.enums.ReservationStatut;
import com.bezkoder.springjwt.models.Reservation;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.Terrain;
import com.bezkoder.springjwt.repository.ReservationRepository;
import com.bezkoder.springjwt.repository.TerrainRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    TerrainRepository terrainRepository;
    
    @Autowired
    UserRepository userRepository;

    public Reservation getById(Long id){
        return reservationRepository.findById(id).get();
    }

    public Reservation create(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation updatedReservation){
        return reservationRepository.save(updatedReservation);
    }

    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    public String deleteById(Long id){
        reservationRepository.deleteById(id);
        return "Reservation supprimée avec succès !";
    }

    public List<String> heuresDisponiblesByDateAndTerrain(String stringDate,long terrainId) throws ParseException {
        List<String> result = new ArrayList<>();
        Terrain terrain = terrainRepository.findById(terrainId).get();
        Date date = DateUtils.stringDateToDate(stringDate);
        List<Reservation> reservations = reservationRepository.findByDateAndTerrain(date,terrain);
        for (Reservation reservation : reservations){
            result.add(reservation.getHeure());
        }
        return result;
    }
    
    public List<ReservationDto> getAllByIdUser(Long idUser) throws ParseException {
        List<ReservationDto> result = new ArrayList<>();
        User user = userRepository.findById(idUser).get();
        List<Reservation> reservationList = reservationRepository.findByUser(user);
        for (Reservation e : reservationList){
            result.add(new ReservationDto(
                    e.getId(),  e.getNom() , e.getPrenom() , e.getCin() , e.getEmail() , e.getTelephone() , e.getAdresse() ,
                    DateUtils.dateToString(e.getDate()) , e.getHeure() , e.getStatut()==ReservationStatut.EN_ATTENTE_DE_VALIDATION?"En attente de validation":(e.getStatut()==ReservationStatut.VALIDÉE?"Validée" : "Refusée") , e.getTerrain().getLibelle() , e.getUser().getUsername()
            ));
        }
        return result;
    }
    
    public List<ReservationDto> getAllByStatut(ReservationStatut reservationStatut) throws ParseException {
        List<ReservationDto> result = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findAllByStatut(reservationStatut);
        for (Reservation e : reservationList){
            result.add(new ReservationDto(
                    e.getId(),  e.getNom() , e.getPrenom() , e.getCin() , e.getEmail() , e.getTelephone() , e.getAdresse() ,
                    DateUtils.dateToString(e.getDate()) , e.getHeure() , e.getStatut()==ReservationStatut.EN_ATTENTE_DE_VALIDATION?"En attente de validation":(e.getStatut()==ReservationStatut.VALIDÉE?"Validée" : "Refusée") , e.getTerrain().getLibelle() , e.getUser().getUsername()
            ));
        }
        return result;
    }
    
    public Reservation updateStatutById(Long id,ReservationStatut reservationStatut){
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setStatut(reservationStatut);
        return reservationRepository.save(reservation);
    }



}
