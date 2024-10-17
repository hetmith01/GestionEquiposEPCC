package com.Epcc.gestionEquipos.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHoraPrestamo;

    private  LocalDateTime fechaHoraDevolucion;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id")
    private Solicitud solicitud;


}