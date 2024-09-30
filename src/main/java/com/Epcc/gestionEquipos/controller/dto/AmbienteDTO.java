package com.Epcc.gestionEquipos.controller.dto;

import com.Epcc.gestionEquipos.entities.Equipo;
import com.Epcc.gestionEquipos.entities.Mueble;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmbienteDTO {

    private Long id;

    private String codigoPatrimonial;

    private String nombre;

    private List<Mueble> mueblesList = new ArrayList<>();

    private List<Equipo> equipoList = new ArrayList<>();
}
