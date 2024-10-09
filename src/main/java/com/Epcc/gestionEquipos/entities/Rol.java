package com.Epcc.gestionEquipos.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Rol {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NombreRol nombreRol;

    public enum NombreRol{
        ESTUDIANTE,
        ADMINISTRADOR
    }

}

