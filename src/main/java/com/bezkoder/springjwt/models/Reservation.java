package com.bezkoder.springjwt.models;

import com.bezkoder.springjwt.enums.ReservationStatut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String prenom;

    private String cin;

    private String email;

    private String telephone;

    private String adresse;

    private Date date;

    private String heure;

    private ReservationStatut statut;

    @ManyToOne
    @JoinColumn(name="terrainId")
    private Terrain terrain;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;
}
