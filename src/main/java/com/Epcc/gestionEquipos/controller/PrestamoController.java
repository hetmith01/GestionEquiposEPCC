package com.Epcc.gestionEquipos.controller;


import com.Epcc.gestionEquipos.controller.dto.PrestamoDTO;
import com.Epcc.gestionEquipos.entities.Prestamo;
import com.Epcc.gestionEquipos.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {

    @Autowired
    private IPrestamoService prestamoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Prestamo> prestamoOptional = prestamoService.findById(id);

        if(prestamoOptional.isPresent()){
            Prestamo prestamo = prestamoOptional.get();

            PrestamoDTO prestamoDTO = PrestamoDTO.builder()
                    .id(prestamo.getId())
                    .estado(prestamo.getEstado())
                    .fechaHoraPrestamo(prestamo.getFechaHoraPrestamo())
                    .fechaHoraDevolucion(prestamo.getFechaHoraDevolucion())
                    .solicitud(prestamo.getSolicitud())
                    .build();
            return ResponseEntity.ok(prestamoDTO);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<PrestamoDTO> prestamoDTOList = prestamoService.findAll()
                .stream()
                .map(prestamo -> PrestamoDTO.builder()
                        .id(prestamo.getId())
                        .estado(prestamo.getEstado())
                        .fechaHoraPrestamo(prestamo.getFechaHoraPrestamo())
                        .fechaHoraDevolucion(prestamo.getFechaHoraDevolucion())
                        .solicitud(prestamo.getSolicitud())
                        .build())
                .toList();
        return ResponseEntity.ok(prestamoDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PrestamoDTO prestamoDTO) throws URISyntaxException{
        if(prestamoDTO.getSolicitud()==null){
            return ResponseEntity.badRequest().build();
        }

        prestamoService.save(Prestamo.builder()
                .estado(prestamoDTO.getEstado())
                .fechaHoraPrestamo(prestamoDTO.getFechaHoraPrestamo())
                .fechaHoraDevolucion(prestamoDTO.getFechaHoraDevolucion())
                .solicitud(prestamoDTO.getSolicitud())
                .build());
        return ResponseEntity.created(new URI("/api/prestamo/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PrestamoDTO prestamoDTO){
        Optional<Prestamo> prestamoOptional = prestamoService.findById(id);

        if(prestamoOptional.isPresent()){
            Prestamo prestamo = prestamoOptional.get();
            prestamo.setFechaHoraPrestamo(prestamoDTO.getFechaHoraPrestamo());
            prestamo.setFechaHoraDevolucion(prestamoDTO.getFechaHoraDevolucion());
            prestamo.setEstado(prestamoDTO.getEstado());
            prestamo.setSolicitud(prestamoDTO.getSolicitud());
            prestamoService.save(prestamo);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if( id != null){
            prestamoService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado.");
        }
        return ResponseEntity.badRequest().build();
    }
}









