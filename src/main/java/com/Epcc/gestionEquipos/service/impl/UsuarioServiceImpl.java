package com.Epcc.gestionEquipos.service.impl;

import com.Epcc.gestionEquipos.entities.Usuario;
import com.Epcc.gestionEquipos.persistence.IUsuarioDAO;
import com.Epcc.gestionEquipos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDAO.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioDAO.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioDAO.deleteById(id);
    }
}
