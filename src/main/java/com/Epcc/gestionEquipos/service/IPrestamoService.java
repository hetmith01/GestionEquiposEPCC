package com.Epcc.gestionEquipos.service;

import com.Epcc.gestionEquipos.entities.Prestamo;

import java.util.List;
import java.util.Optional;

public interface IPrestamoService {

    List<Prestamo> findAll();

    Optional<Prestamo> findById(Long id);

    void save(Prestamo prestamo);

    void deleteById(Long id);
}
