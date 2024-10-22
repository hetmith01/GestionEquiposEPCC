package com.Epcc.gestionEquipos.service.impl;

import com.Epcc.gestionEquipos.entities.Prestamo;
import com.Epcc.gestionEquipos.persistence.IPrestamoDAO;
import com.Epcc.gestionEquipos.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements IPrestamoService {

    @Autowired
    private IPrestamoDAO prestamoDAO;

    @Override
    public List<Prestamo> findAll() {
        return prestamoDAO.findAll();
    }

    @Override
    public Optional<Prestamo> findById(Long id) {
        return prestamoDAO.findById(id);
    }

    @Override
    public void save(Prestamo prestamo) {
        prestamoDAO.save(prestamo);
    }

    @Override
    public void deleteById(Long id) {
        prestamoDAO.deleteById(id);
    }
}
