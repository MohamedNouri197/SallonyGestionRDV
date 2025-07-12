package com.example.gestionrdv.RDVREST;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/RDVs")
public class RDVRestController {

    @Autowired
    private RDVService RDVService;
    @Autowired
    private DateHourService dateHourService;

    @Autowired
    private CoiffureDTORepository coiffureDTORepository;

    @Autowired
    private AvailableDateHourRepository availableDateHourRepository;


    @Autowired
    private ServiceDTORepository serviceDTORepository;

    @Autowired
    private ClientDTORepository clientDTORepository;



    private String title = "Hello from RDV2AL6";

    @GetMapping("/hello")
    public ResponseEntity<String> getTitle() {
        return ResponseEntity.ok(title);
    }


    @GetMapping
    public ResponseEntity<List<RDV>> getAllRDVs() {
        return ResponseEntity.ok(RDVService.gelallRDVs());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getRDVById(@PathVariable int id) {
        try {
            RDV RDV = RDVService.getRDVById(id);
            return ResponseEntity.ok(RDV);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @PostMapping("/createRDV/{id_client}/{id_coiffure}/{id_service}")
    public ResponseEntity<RDV> createRDV(

            @PathVariable("id_client") int id_client,
            @PathVariable("id_coiffure") int id_coiffure,
            @PathVariable("id_service") int id_service) {
          RDV rdv = new RDV();
        ClientDTO client = clientDTORepository.findById(id_client)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID " + id_client + " not found"));
        CoiffureDTO coiffeur = coiffureDTORepository.findById(id_coiffure)
                .orElseThrow(() -> new IllegalArgumentException("Coiffeur with ID " + id_coiffure + " not found"));
        ServiceDTO service = serviceDTORepository.findById(id_service)
                .orElseThrow(() -> new IllegalArgumentException("Service with ID " + id_service + " not found"));

        rdv.setClient(client);
        rdv.setCoiffeur(coiffeur);
        rdv.setService(service);

        RDV created = RDVService.saveRDV(rdv);
        return ResponseEntity.status(201).body(created);
    }
    @PutMapping
    public RDV updateRDV(@RequestBody RDV RDV) {
        return RDVService.updateRDV(RDV);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRDV(@PathVariable int id) {
        try {
            RDV deleted = RDVService.deleteRDV(id);
            return ResponseEntity.ok(deleted);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<DateHour> createDateHour(@RequestBody DateHour datehour) {
        DateHour created = dateHourService.saveDateHour(datehour);
        return ResponseEntity.status(201).body(created);
    }

    @PostMapping("/affectionAvailableDateHour")
    public ResponseEntity<String> affectDateHourToCoiffeur(@RequestParam int id_coiffeur, @RequestParam int id_date_hour) {
        try {
            RDVService.AffectDateHourToAvailableDateHour(id_coiffeur, id_date_hour);
            return ResponseEntity.ok("DateHour affecté avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/createCoiffure")
    public ResponseEntity<CoiffureDTO> createCoiffure(@RequestBody CoiffureDTO coiffureDTO) {
        CoiffureDTO created = coiffureDTORepository.save(coiffureDTO);
        return ResponseEntity.status(201).body(created);
    }
    @GetMapping("/getListAvailableDateHour")
    public ResponseEntity<List<AvailableDateHour>> getListAvailableDateHour() {
        List<AvailableDateHour> availableDateHours = availableDateHourRepository.findAll();
        return ResponseEntity.ok(availableDateHours);
    }
    @PostMapping("/addClient")
    public ResponseEntity<String> addClient( @RequestBody ClientDTO nom_client) {
        try {
            RDVService.addClient( nom_client);
            return ResponseEntity.ok("Client ajouté avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/addService")

    public  ResponseEntity<String> addService(@RequestBody ServiceDTO serviceDTO) {
        try {
            serviceDTORepository.save(serviceDTO);
            return ResponseEntity.ok("Service ajouté avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}





