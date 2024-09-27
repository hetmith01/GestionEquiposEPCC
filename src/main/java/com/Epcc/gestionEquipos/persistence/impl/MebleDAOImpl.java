package com.Epcc.gestionEquipos.persistence.impl;

import com.Epcc.gestionEquipos.entities.Mueble;
import com.Epcc.gestionEquipos.persistence.IMuebleDAO;
import com.Epcc.gestionEquipos.repository.MuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class MebleDAOImpl implements IMuebleDAO {

    @Autowired
    private MuebleRepository muebleRepository;

    @Override
    public List<Mueble> findAll() {
        return (List<Mueble>) muebleRepository.findAll();
    }

    @Override
    public Optional<Mueble> findById(Long id) {
        return muebleRepository.findById(id);
    }

    @Override
    public void save(Mueble mueble) {
        muebleRepository.save(mueble);
    }

    @Override
    public void deleteById(Long id) {
        muebleRepository.deleteById(id);
    }
}
