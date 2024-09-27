package com.Epcc.gestionEquipos.service.impl;


import com.Epcc.gestionEquipos.entities.Mueble;
import com.Epcc.gestionEquipos.persistence.IMuebleDAO;
import com.Epcc.gestionEquipos.service.IMuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuebleServiceImpl implements IMuebleService {

    @Autowired
    private IMuebleDAO muebleDAO;

    @Override
    public List<Mueble> findAll() {
        return (List<Mueble>) muebleDAO.findAll();
    }

    @Override
    public Optional<Mueble> findById(Long id) {
        return muebleDAO.findById(id);
    }

    @Override
    public void save(Mueble mueble) {
        muebleDAO.save(mueble);
    }

    @Override
    public void deleteById(Long id) {
        muebleDAO.deleteById(id);
    }
}
