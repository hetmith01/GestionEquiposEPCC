package com.Epcc.gestionEquipos.persistence;

import com.Epcc.gestionEquipos.entities.Equipo;

import java.util.List;
import java.util.Optional;

public interface IEquipoDAO {
    List<Equipo> findAll();

    Optional<Equipo> findById(Long id);

    void save(Equipo equipo);

    void deleteById(Long id);
}
