package com.Epcc.gestionEquipos.controller;


import com.Epcc.gestionEquipos.controller.dto.UsuarioDTO;
import com.Epcc.gestionEquipos.entities.Usuario;
import com.Epcc.gestionEquipos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
   private IUsuarioService usuarioService;



    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);

        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();

            UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                    .id(usuario.getId())
                    .nombre(usuario.getNombre())
                    .apellido(usuario.getApellido())
                    .cui(usuario.getCui())
                    .telefonoCelular(usuario.getTelefonoCelular())
                    .direccion(usuario.getDireccion())
                    .correo(usuario.getCorreo())
                    .build();
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/findAll")
    public  ResponseEntity<?> findAll(){
        List<UsuarioDTO> usuarioDTOList = usuarioService.findAll()
                .stream()
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .cui(usuario.getCui())
                        .telefonoCelular(usuario.getTelefonoCelular())
                        .direccion(usuario.getDireccion())
                        .correo(usuario.getCorreo())
                        .build())
                .toList();
        return ResponseEntity.ok(usuarioDTOList);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException{
        if(usuarioDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        usuarioService.save(Usuario.builder()
                        .nombre(usuarioDTO.getNombre())
                        .apellido(usuarioDTO.getApellido())
                        .cui(usuarioDTO.getCui())
                        .telefonoCelular(usuarioDTO.getTelefonoCelular())
                        .direccion(usuarioDTO.getDireccion())
                        .correo(usuarioDTO.getCorreo())
                        .build());
        return ResponseEntity.created(new URI("/api/usuario/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setCui(usuarioDTO.getCui());
            usuario.setCorreo(usuarioDTO.getCorreo());
            usuario.setDireccion(usuarioDTO.getDireccion());
            usuario.setTelefonoCelular(usuarioDTO.getTelefonoCelular());
            usuarioService.save(usuario);
            return ResponseEntity.ok("Registro actualizado!!!");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            usuarioService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado!!!");
        }
        return ResponseEntity.badRequest().build();
    }

}












