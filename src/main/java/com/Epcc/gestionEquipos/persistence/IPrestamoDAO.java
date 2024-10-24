package com.Epcc.gestionEquipos.persistence;

import com.Epcc.gestionEquipos.entities.Prestamo;

import java.util.List;
import java.util.Optional;

public interface IPrestamoDAO {

    List<Prestamo> findAll();

    Optional<Prestamo> findById(Long id);

    void save(Prestamo prestamo);

    void deleteById(Long id);
}
