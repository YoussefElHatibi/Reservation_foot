package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.ReservationDto;
import com.bezkoder.springjwt.enums.ReservationStatut;
import com.bezkoder.springjwt.models.Reservation;
import com.bezkoder.springjwt.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Reservation getById(@PathVariable Long id){
        return reservationService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody Reservation reservation){
        return reservationService.create(reservation);
    }

    @PutMapping("/update")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Reservation updateById(@RequestBody Reservation updatedReservation){
        return reservationService.update(updatedReservation);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteById(@PathVariable  Long id){
        return reservationService.deleteById(id);
    }

    @GetMapping("/heures")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> heuresDisponniblesByDateAndTerrain(@RequestParam(name = "date") String date,@RequestParam(name = "terrainId")Long terrainId) throws ParseException {
        return reservationService.heuresDisponiblesByDateAndTerrain(date,terrainId);
    }

    @GetMapping("/all/{idUser}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationDto> getAllByIdUser(@PathVariable Long idUser) throws ParseException {
        return reservationService.getAllByIdUser(idUser);
    }

    @GetMapping("/all/byStatut")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationDto> getAllByStatut(@RequestParam("statut") ReservationStatut reservationStatut) throws ParseException {
        return reservationService.getAllByStatut(reservationStatut);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Reservation updateStatutById(@PathVariable Long id,@RequestParam("statut") ReservationStatut statut){
        return reservationService.updateStatutById(id,statut);
    }

}
