package com.Epcc.gestionEquipos.controller;


import com.Epcc.gestionEquipos.controller.dto.AmbienteDTO;
import com.Epcc.gestionEquipos.entities.Ambiente;
import com.Epcc.gestionEquipos.service.IAmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
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
                    .codigoPatrimonial(ambiente.getCodigoPatrimonial())
                    .nombre(ambiente.getNombre())
                    .mueblesList(ambiente.getMueblesList())
                    .equipoList(ambiente.getEquipoList())
                    .build();
            return ResponseEntity.ok(ambienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<AmbienteDTO> ambienteDTOList = ambienteService.findAll()
                .stream()
                .map(ambiente ->  AmbienteDTO.builder()
                        .id(ambiente.getId())
                        .codigoPatrimonial(ambiente.getCodigoPatrimonial())
                        .nombre(ambiente.getNombre())
                        .mueblesList(ambiente.getMueblesList())
                        .equipoList(ambiente.getEquipoList())
                        .build())
                .toList();
        return ResponseEntity.ok(ambienteDTOList);
    }

    @PostMapping("/save")
    public  ResponseEntity<?> save(@RequestBody AmbienteDTO ambienteDTO) throws URISyntaxException{
        if(ambienteDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        ambienteService.save(Ambiente.builder()
                .nombre(ambienteDTO.getNombre())
                .codigoPatrimonial(ambienteDTO.getCodigoPatrimonial())
                .build());

        return ResponseEntity.created(new URI("/api/ambiente/save")).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAmbiente(@PathVariable Long id, @RequestBody AmbienteDTO ambienteDTO){
        Optional<Ambiente> ambienteOptional = ambienteService.findById(id);

        if(ambienteOptional.isPresent()){
            Ambiente ambiente = ambienteOptional.get();
            ambiente.setNombre(ambienteDTO.getNombre());
            ambiente.setCodigoPatrimonial(ambienteDTO.getCodigoPatrimonial());
            ambienteService.save(ambiente);
            return  ResponseEntity.ok("Registro actualizado!!!");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            ambienteService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado!!!");
        }
        return  ResponseEntity.badRequest().build();
    }




}











