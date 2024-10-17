package com.Epcc.gestionEquipos.controller.dto;

import com.Epcc.gestionEquipos.entities.Solicitud;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrestamoDTO {

    private Long id;

    private LocalDateTime fechaHoraPrestamo;

    private  LocalDateTime fechaHoraDevolucion;

    private Solicitud solicitud;
}
