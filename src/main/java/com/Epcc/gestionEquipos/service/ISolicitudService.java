package com.Epcc.gestionEquipos.service;

import com.Epcc.gestionEquipos.entities.Solicitud;

import java.util.List;
import java.util.Optional;

public interface ISolicitudService {

    List<Solicitud> findAll();

    Optional<Solicitud> findById(Long id);

    void save(Solicitud solicitud);

    void deleteByID(Long id);
}
