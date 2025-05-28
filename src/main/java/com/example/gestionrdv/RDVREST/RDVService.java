package com.example.gestionrdv.RDVREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class RDVService implements IRDV {
    @Autowired
    private RDVRepository RDVRepository;

    @Autowired
    private DateHourRepository  dateHourRepository;

   @Autowired
    private  AvailableDateHourRepository availableDateHourRepository;




    @Override
    public List<RDV> gelallRDVs(){

        return RDVRepository.findAll();

    }

    @Override
    public RDV saveRDV(RDV RDV) {
        return RDVRepository.save(RDV);
    }



    @Override
    public RDV deleteRDV(int id) {
        Optional<RDV> RDVOptional = RDVRepository.findById(id);

        if (RDVOptional.isPresent()) {
            RDV RDV = RDVOptional.get();
            RDVRepository.delete(RDV);
            return RDV;
        } else {
            throw new IllegalArgumentException("RDV with id " + id + " not found.");
        }
    }

    @Override
    public RDV updateRDV(RDV rdv) {
       /* if (RDVRepository.existsById(rdv.getId())) {
            return RDVRepository.save(rdv);  // Save the updated RDV, ID remains unchanged
        } else {
            throw new IllegalArgumentException("RDV with id " + rdv.getId() + " not found.");
        }*/

        return rdv;
    }

    @Override
    public RDV getRDVById(int id) {
        Optional<RDV> RDVOptional = RDVRepository.findById(id);
        return RDVOptional.orElseThrow(() -> new IllegalArgumentException("RDV with id " + id + " not found."));
    }


    public void AffectDateHourToAvailableDateHour( int id_coiffeur, int id_date_hour) {
        AvailableDateHour  availableDateHour=new AvailableDateHour();
        availableDateHour.setId_coiffeur(id_coiffeur);
      List<DateHour>  dateHour= (List<DateHour>) dateHourRepository.findById(id_date_hour).get();
      availableDateHour.setListDateHours(dateHour);
        availableDateHourRepository.save(availableDateHour);
    }

}
