package com.example.gestionrdv.RDVREST;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DateHourRepository extends JpaRepository<DateHour, Integer> {
    // Custom query methods can be defined here if needed
}
