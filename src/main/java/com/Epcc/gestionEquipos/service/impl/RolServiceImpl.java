package com.Epcc.gestionEquipos.service.impl;


import com.Epcc.gestionEquipos.entities.Rol;
import com.Epcc.gestionEquipos.persistence.IRolDAO;
import com.Epcc.gestionEquipos.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolDAO rolDAO;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolDAO.findAll();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolDAO.frindById(id);
    }

    @Override
    public void save(Rol rol) {
        rolDAO.save(rol);
    }

    @Override
    public void deleteById(Long id) {
        rolDAO.deleteById(id);
    }
}
