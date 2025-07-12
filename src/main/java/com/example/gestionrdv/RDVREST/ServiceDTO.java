package com.example.gestionrdv.RDVREST;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_service;
    private String nom_service;

    public ServiceDTO(int id_service) {
        this.id_service = id_service;
    }
}
