package com.Epcc.gestionEquipos.service.impl;

import com.Epcc.gestionEquipos.entities.Solicitud;
import com.Epcc.gestionEquipos.persistence.ISolicitudDAO;
import com.Epcc.gestionEquipos.service.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements ISolicitudService {

    @Autowired
    private ISolicitudDAO solicitudDAO;

    @Override
    public List<Solicitud> findAll() {
        return (List<Solicitud>) solicitudDAO.findAll();
    }

    @Override
    public Optional<Solicitud> findById(Long id) {
        return solicitudDAO.findById(id);
    }

    @Override
    public void save(Solicitud solicitud) {
        solicitudDAO.save(solicitud);
    }

    @Override
    public void deleteByID(Long id) {
        solicitudDAO.deleteById(id);
    }
}
