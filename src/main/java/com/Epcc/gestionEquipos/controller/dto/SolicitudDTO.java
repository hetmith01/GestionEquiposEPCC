package com.Epcc.gestionEquipos.controller.dto;

import com.Epcc.gestionEquipos.entities.Equipo;
import com.Epcc.gestionEquipos.entities.Prestamo;
import com.Epcc.gestionEquipos.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitudDTO {

    private Long id;

    private String docente;

    private String curso;

    private LocalDateTime fechaHoraPrestamoEstipulado;

    private LocalDateTime fechaHoraDevolucionEstipulada;

    private Usuario usuario;

    private Equipo equipo;

    private Prestamo prestamo;

}
