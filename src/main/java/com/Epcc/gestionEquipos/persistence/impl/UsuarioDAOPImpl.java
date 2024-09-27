package com.Epcc.gestionEquipos.persistence.impl;

import com.Epcc.gestionEquipos.entities.Usuario;
import com.Epcc.gestionEquipos.persistence.IUsuarioDAO;
import com.Epcc.gestionEquipos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UsuarioDAOPImpl implements IUsuarioDAO {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
