package com.Epcc.gestionEquipos.controller;


import com.Epcc.gestionEquipos.controller.dto.AmbienteDTO;
import com.Epcc.gestionEquipos.entities.Ambiente;
import com.Epcc.gestionEquipos.service.IAmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ambiente")
public class AmbienteController {

    @Autowired
    private IAmbienteService ambienteService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Ambiente> ambienteOptional = ambienteService.findById(id);

        if(ambienteOptional.isPresent()){
            Ambiente ambiente = ambienteOptional.get();

            AmbienteDTO ambienteDTO = AmbienteDTO.builder()
                    .id(ambiente.getId())
                    .nombre(ambiente.getNombre())
                    .mueblesList(ambiente.getMueblesList())
                    .equipoList(ambiente.getEquipoList())
                    .build();
            return ResponseEntity.ok(ambienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

}
