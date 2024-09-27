package com.Epcc.gestionEquipos.service;

import com.Epcc.gestionEquipos.entities.Ambiente;

import java.util.List;
import java.util.Optional;

public interface IAmbienteService {

    List<Ambiente> findAll();

    Optional<Ambiente> findById(Long id);

    void save(Ambiente ambiente);

    void deleteById(Long id);
}
