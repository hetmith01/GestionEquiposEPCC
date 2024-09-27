package com.Epcc.gestionEquipos.service;

import com.Epcc.gestionEquipos.entities.Equipo;

import java.util.List;
import java.util.Optional;

public interface IEquipoService {

    List<Equipo> findAll();

    Optional<Equipo> findById(Long id);

    void save(Equipo equipo);

    void deleteById(Long id);
}
