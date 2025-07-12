    package com.example.gestionrdv.RDVREST;

    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDate;
    @Getter
    @Setter

    @Entity
    public class RDV {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id_rdv;

        @ManyToOne
        @JoinColumn(name = "id_client", nullable = false)
        private ClientDTO client;

        @ManyToOne
        @JoinColumn(name = "id_coiffure", nullable = false)
        private CoiffureDTO coiffeur;

        @ManyToOne
        @JoinColumn(name = "id_service", nullable = false)
        private ServiceDTO service;

        @Enumerated(EnumType.STRING)
        private Status status;

        // getters et setters
    }
