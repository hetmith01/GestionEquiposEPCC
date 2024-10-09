package com.Epcc.gestionEquipos.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "")
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_patrimonial")
    private String codigoPatrimonial;

    private String nombre;

    private String tipo; //si el equipo es de uso general, uso por alumnos en determinadpos cursos, uso administrativo

    private Boolean operabilidad;

    @ManyToOne
    @JoinColumn(name = "ambiente_id", nullable = false)
    @JsonIgnore
    private Ambiente ambiente;


}
