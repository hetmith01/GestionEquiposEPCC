package com.Epcc.gestionEquipos.controller.dto;

import com.Epcc.gestionEquipos.entities.Solicitud;
import jakarta.persistence.Column;
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
public class UsuarioDTO {


    private Long id;

    private String nombre;

    private String apellido;

    private String cui;

    private String telefonoCelular;

    private String direccion;

    private String correo;

    private String contrasenia;

    private List<Solicitud> solicitudList = new ArrayList<>();
}
