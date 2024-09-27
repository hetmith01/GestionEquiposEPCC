package com.Epcc.gestionEquipos.service.impl;

import com.Epcc.gestionEquipos.entities.Ambiente;
import com.Epcc.gestionEquipos.persistence.IAmbienteDAO;
import com.Epcc.gestionEquipos.service.IAmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmbienteServiceImpl implements IAmbienteService {

    @Autowired
    private IAmbienteDAO ambienteDAO;

    @Override
    public List<Ambiente> findAll() {
        return (List<Ambiente>) ambienteDAO.findAll();
    }

    @Override
    public Optional<Ambiente> findById(Long id) {
        return ambienteDAO.findById(id);
    }

    @Override
    public void save(Ambiente ambiente) {
        ambienteDAO.save(ambiente);
    }

    @Override
    public void deleteById(Long id) {
        ambienteDAO.deleteById(id);
    }
}
