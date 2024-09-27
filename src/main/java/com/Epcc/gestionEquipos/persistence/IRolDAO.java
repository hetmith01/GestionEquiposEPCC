package com.Epcc.gestionEquipos.persistence;

import com.Epcc.gestionEquipos.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolDAO {

    List<Rol> findAll();

    Optional<Rol> frindById(Long id);

    void save(Rol rol);

    void deleteById(Long id);
}
