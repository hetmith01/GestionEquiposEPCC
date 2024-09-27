package com.Epcc.gestionEquipos.repository;

import com.Epcc.gestionEquipos.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
