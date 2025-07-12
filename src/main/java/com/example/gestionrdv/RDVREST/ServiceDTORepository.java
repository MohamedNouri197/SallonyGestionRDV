package com.example.gestionrdv.RDVREST;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ServiceDTORepository extends JpaRepository<ServiceDTO, Integer> {

}
// This interface extends JpaRepository, which provides CRUD operations for ServiceDTO entities.