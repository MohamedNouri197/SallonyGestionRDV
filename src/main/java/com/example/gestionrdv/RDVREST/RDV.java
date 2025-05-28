package com.example.gestionrdv.RDVREST;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rdv;
    private int id_client;
    private int id_coiffeur;
    private int id_service;


    @Enumerated(EnumType.STRING)
    private Status status;





}