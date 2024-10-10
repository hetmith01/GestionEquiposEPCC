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
@Table(name = "ambientes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_patrimonial")
    private String codigoPatrimonial;

    private String nombre;


    @OneToMany(mappedBy = "ambiente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Mueble> mueblesList = new ArrayList<>();


    @OneToMany(mappedBy = "ambiente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Equipo> equipoList = new ArrayList<>();
}
