package com.example.gestionrdv.RDVREST;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CoiffureDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_coiffure;
    public int getId_coiffure() {
        return Id_coiffure;
    }
    public void setId_coiffure(int id_coiffure) {
        Id_coiffure = id_coiffure;
    }


}
