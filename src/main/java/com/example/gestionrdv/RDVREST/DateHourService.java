package com.example.gestionrdv.RDVREST;

import com.example.gestionrdv.RDVREST.DateHour;
import com.example.gestionrdv.RDVREST.DateHourRepository;
import com.example.gestionrdv.RDVREST.IDateHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class DateHourService implements IDateHour {
    @Autowired
    private DateHourRepository DateHourRepository;

    @Override
    public List<DateHour> gelallDateHours(){

        return DateHourRepository.findAll();

    }

    @Override
    public DateHour saveDateHour(DateHour DateHour) {
        return DateHourRepository.save(DateHour);
    }



    @Override
    public DateHour deleteDateHour(int id) {
        Optional<DateHour> DateHourOptional = DateHourRepository.findById(id);

        if (DateHourOptional.isPresent()) {
            DateHour DateHour = DateHourOptional.get();
            DateHourRepository.delete(DateHour);
            return DateHour;
        } else {
            throw new IllegalArgumentException("DateHour with id " + id + " not found.");
        }
    }

    @Override
    public DateHour updateDateHour(DateHour DateHour) {
       /* if (DateHourRepository.existsById(DateHour.getId())) {
            return DateHourRepository.save(DateHour);  // Save the updated DateHour, ID remains unchanged
        } else {
            throw new IllegalArgumentException("DateHour with id " + DateHour.getId() + " not found.");
        }*/

        return DateHour;
    }

    @Override
    public DateHour getDateHourById(int id) {
        Optional<DateHour> DateHourOptional = DateHourRepository.findById(id);
        return DateHourOptional.orElseThrow(() -> new IllegalArgumentException("DateHour with id " + id + " not found."));
    }

}
