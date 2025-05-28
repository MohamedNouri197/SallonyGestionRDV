package com.example.gestionrdv.RDVREST;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RDVRepository extends JpaRepository<RDV, Integer> {
    // Custom query methods can be defined here if needed
}
