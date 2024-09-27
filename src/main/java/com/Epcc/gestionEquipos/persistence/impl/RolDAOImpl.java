package com.Epcc.gestionEquipos.persistence.impl;

import com.Epcc.gestionEquipos.entities.Rol;
import com.Epcc.gestionEquipos.persistence.IRolDAO;
import com.Epcc.gestionEquipos.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class RolDAOImpl implements IRolDAO {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public Optional<Rol> frindById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
}
