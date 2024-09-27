package com.Epcc.gestionEquipos.persistence;

import com.Epcc.gestionEquipos.entities.Ambiente;

import java.util.List;
import java.util.Optional;

public interface IAmbienteDAO {

    List<Ambiente> findAll();

    Optional<Ambiente> findById(long id);

    void save(Ambiente ambiente);

    void deleteById(Long id);
}
