package com.Epcc.gestionEquipos.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String cui;


    @Column(name = "tell_cell")
    private String telefonoCelular;

    private String direccion;

    private String correo;

    private String contrasenia;

}
