package com.Epcc.gestionEquipos.persistence;

import com.Epcc.gestionEquipos.entities.Mueble;

import java.util.List;
import java.util.Optional;

public interface IMuebleDAO {

    List<Mueble> findAll();

    Optional<Mueble> findById(Long id);

    void save(Mueble mueble);

    void deleteById(Long id);
}
