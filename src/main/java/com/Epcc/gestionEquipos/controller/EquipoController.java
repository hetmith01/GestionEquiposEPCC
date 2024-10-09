package com.Epcc.gestionEquipos.controller;


import com.Epcc.gestionEquipos.controller.dto.EquipoDTO;
import com.Epcc.gestionEquipos.entities.Equipo;
import com.Epcc.gestionEquipos.service.IEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class EquipoController {

    @Autowired
    private IEquipoService equipoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Equipo> equipoOptional = equipoService.findById(id);

        if(equipoOptional.isPresent()){
            Equipo equipo = equipoOptional.get();

            EquipoDTO equipoDTO = EquipoDTO.builder()
                    .id(equipo.getId())
                    .nombre(equipo.getNombre())
                    .codigoPatrimonial(equipo.getCodigoPatrimonial())
                    .tipo(equipo.getTipo())
                    .operabilidad(equipo.getOperabilidad())
                    .ambiente(equipo.getAmbiente())
                    .build();
            return ResponseEntity.ok(equipoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("findAll")
    public  ResponseEntity<?> findAll(){
        List<EquipoDTO> equipoDTOList = equipoService.findAll()
                .stream()
                .map(equipo -> EquipoDTO.builder()
                        .id(equipo.getId())
                        .nombre(equipo.getNombre())
                        .codigoPatrimonial(equipo.getCodigoPatrimonial())
                        .tipo(equipo.getTipo())
                        .operabilidad(equipo.getOperabilidad())
                        .ambiente(equipo.getAmbiente())
                        .build())
                .toList();
        return ResponseEntity.ok(equipoDTOList);
    }

    @PostMapping("/save")
    public  ResponseEntity<?> save(@RequestBody EquipoDTO equipoDTO) throws URISyntaxException{
        if(equipoDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        equipoService.save(Equipo.builder()
                .nombre(equipoDTO.getNombre())
                .codigoPatrimonial(equipoDTO.getCodigoPatrimonial())
                .tipo(equipoDTO.getTipo())
                .operabilidad(equipoDTO.getOperabilidad())
                .ambiente(equipoDTO.getAmbiente())
                .build());
        return ResponseEntity.created(new URI("/api/equipo/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EquipoDTO equipoDTO){
        Optional<Equipo> equipoOptional =equipoService.findById(id);
        if(equipoOptional.isPresent()){
            Equipo equipo = equipoOptional.get();
            equipo.setAmbiente(equipoDTO.getAmbiente());
            equipo.setNombre(equipoDTO.getNombre());
            equipo.setTipo(equipoDTO.getTipo());
            equipo.setOperabilidad(equipoDTO.getOperabilidad());
            equipo.setCodigoPatrimonial(equipoDTO.getCodigoPatrimonial());
            return ResponseEntity.ok("Registro actualizado!!!");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            equipoService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }


}



















