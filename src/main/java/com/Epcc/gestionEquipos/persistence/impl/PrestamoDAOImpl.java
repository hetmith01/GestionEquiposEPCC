package com.Epcc.gestionEquipos.persistence.impl;

import com.Epcc.gestionEquipos.entities.Prestamo;
import com.Epcc.gestionEquipos.persistence.IPrestamoDAO;
import com.Epcc.gestionEquipos.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoDAOImpl implements IPrestamoDAO {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> findAll() {
        return (List<Prestamo>) prestamoRepository.findAll();
    }

    @Override
    public Optional<Prestamo> findById(Long id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public void save(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }

    @Override
    public void deleteById(Long id) {
        prestamoRepository.deleteById(id);
    }
}
