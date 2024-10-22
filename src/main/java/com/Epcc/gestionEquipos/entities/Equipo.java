package com.Epcc.gestionEquipos.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_patrimonial")
    private String codigoPatrimonial;

    private String nombre;

    private String tipo; //si el equipo es de uso general, uso por alumnos en determinadpos cursos, uso administrativo

    private Boolean operabilidad;

    private String descripcion; // piezas del equipo, algun defecto o falta

    @ManyToOne
    @JoinColumn(name = "ambiente_id", nullable = false)
    @JsonIgnore
    private Ambiente ambiente;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Solicitud> solicitudList = new ArrayList<>();

}
