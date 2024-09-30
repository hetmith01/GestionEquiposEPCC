package com.Epcc.gestionEquipos.controller.dto;

import com.Epcc.gestionEquipos.entities.Ambiente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MuebleDTO {

    private Long id;

    private String codigoPatrimonial;

    private String nombre;

    private Ambiente ambiente;

}
