package com.Epcc.gestionEquipos.controller.dto;

import com.Epcc.gestionEquipos.entities.Ambiente;
import com.Epcc.gestionEquipos.entities.Solicitud;
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
public class EquipoDTO {

    private Long id;

    private String nombre;

    private String codigoPatrimonial;

    private String tipo;

    private Boolean operabilidad;

    private Ambiente ambiente;

    private List<Solicitud> solicitudList = new ArrayList<>();

}
