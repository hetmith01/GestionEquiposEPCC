package com.Epcc.gestionEquipos.persistence.impl;

import com.Epcc.gestionEquipos.entities.Ambiente;
import com.Epcc.gestionEquipos.persistence.IAmbienteDAO;
import com.Epcc.gestionEquipos.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class AmbienteDAOImpl implements IAmbienteDAO {

    @Autowired
    private AmbienteRepository ambienteRepository;

    @Override
    public List<Ambiente> findAll() {
        return (List<Ambiente>) ambienteRepository.findAll();
    }

    @Override
    public Optional<Ambiente> findById(long id) {
        return ambienteRepository.findById(id);
    }

    @Override
    public void save(Ambiente ambiente) {
        ambienteRepository.save(ambiente);
    }

    @Override
    public void deleteById(Long id) {
        ambienteRepository.deleteById(id);
    }
}
