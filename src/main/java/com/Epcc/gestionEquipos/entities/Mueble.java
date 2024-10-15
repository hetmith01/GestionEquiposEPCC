package com.Epcc.gestionEquipos.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "muebles")
public class Mueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_patrimonial")
    private String codigoPatrimonial;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ambiente_id", nullable = false)
    @JsonIgnore
    private Ambiente ambiente;
}
