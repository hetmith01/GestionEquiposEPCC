package com.Epcc.gestionEquipos.service.impl;


import com.Epcc.gestionEquipos.entities.Equipo;
import com.Epcc.gestionEquipos.persistence.IEquipoDAO;
import com.Epcc.gestionEquipos.service.IEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements IEquipoService {

    @Autowired
    private IEquipoDAO equipoDAO;

    @Override
    public List<Equipo> findAll() {
        return (List<Equipo>) equipoDAO.findAll();
    }

    @Override
    public Optional<Equipo> findById(Long id) {
        return equipoDAO.findById(id);
    }

    @Override
    public void save(Equipo equipo) {
        equipoDAO.save(equipo);
    }

    @Override
    public void deleteById(Long id) {
        equipoDAO.deleteById(id);
    }
}
