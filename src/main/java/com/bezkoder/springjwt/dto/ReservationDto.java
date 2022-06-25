package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.enums.ReservationStatut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data@AllArgsConstructor@NoArgsConstructor
public class ReservationDto {

private long id;

private String nom;

private String prenom;

private String cin;

private String email;

private String telephone;

private String adresse;

private String date;

private String heure;

private String statut;

private String terrain;

private String user;
}
