package com.Epcc.gestionEquipos.service;

import com.Epcc.gestionEquipos.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    List<Rol> findAll();

    Optional<Rol> findById(Long id);

    void save(Rol rol);

    void deleteById(Long id);
}
