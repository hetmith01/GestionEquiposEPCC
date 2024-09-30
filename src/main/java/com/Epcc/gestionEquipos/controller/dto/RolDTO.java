package com.Epcc.gestionEquipos.controller.dto;

import com.Epcc.gestionEquipos.entities.Rol;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolDTO {

    private Long id;

    private Rol.NombreRol nombreRol;
}
