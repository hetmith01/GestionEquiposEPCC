package com.Epcc.gestionEquipos.persistence;

import com.Epcc.gestionEquipos.entities.Solicitud;

import java.util.List;
import java.util.Optional;

public interface ISolicitudDAO {

    List<Solicitud> findAll();

    Optional<Solicitud> findById(Long id);

    void save(Solicitud solicitud);

    void deleteById(Long id);
}
