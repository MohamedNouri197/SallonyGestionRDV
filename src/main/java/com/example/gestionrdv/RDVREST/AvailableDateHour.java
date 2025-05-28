package com.example.gestionrdv.RDVREST;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Entity

public class AvailableDateHour {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_coiffeur;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)

    @JoinColumn(name = "available_date_hour_id")
    private List<DateHour> ListDateHours;

    public AvailableDateHour() {
    }

    public List<DateHour> getListDateHours() {
        return ListDateHours;
    }
    public void setListDateHours(List<DateHour> listDateHours) {
        ListDateHours = listDateHours;
    }

    public int getId_coiffeur() {
        return id_coiffeur;
    }
    public void setId_coiffeur(int id_coiffeur) {
        this.id_coiffeur = id_coiffeur;
    }



}
