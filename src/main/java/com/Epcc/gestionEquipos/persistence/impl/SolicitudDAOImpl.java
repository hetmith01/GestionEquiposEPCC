package com.Epcc.gestionEquipos.persistence.impl;

import com.Epcc.gestionEquipos.entities.Solicitud;
import com.Epcc.gestionEquipos.persistence.ISolicitudDAO;
import com.Epcc.gestionEquipos.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SolicitudDAOImpl implements ISolicitudDAO {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> findAll() {
        return (List<Solicitud>) solicitudRepository.findAll();
    }

    @Override
    public Optional<Solicitud> findById(Long id) {
        return solicitudRepository.findById(id);
    }

    @Override
    public void save(Solicitud solicitud) {
        solicitudRepository.save(solicitud);
    }

    @Override
    public void deleteById(Long id) {
        solicitudRepository.deleteById(id);
    }
}
