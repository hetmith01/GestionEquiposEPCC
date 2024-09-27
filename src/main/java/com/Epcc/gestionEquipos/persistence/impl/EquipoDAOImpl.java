package com.Epcc.gestionEquipos.persistence.impl;

import com.Epcc.gestionEquipos.entities.Equipo;
import com.Epcc.gestionEquipos.persistence.IEquipoDAO;
import com.Epcc.gestionEquipos.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class EquipoDAOImpl implements IEquipoDAO {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public List<Equipo> findAll() {
        return (List<Equipo>) equipoRepository.findAll();
    }

    @Override
    public Optional<Equipo> findById(Long id) {
        return equipoRepository.findById(id);
    }

    @Override
    public void save(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    @Override
    public void deleteById(Long id) {
        equipoRepository.deleteById(id);
    }
}
