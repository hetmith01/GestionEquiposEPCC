package com.Epcc.gestionEquipos.controller;


import com.Epcc.gestionEquipos.controller.dto.SolicitudDTO;
import com.Epcc.gestionEquipos.entities.Solicitud;
import com.Epcc.gestionEquipos.service.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/solicitud")
public class SolicitudController {

    @Autowired
    private ISolicitudService solicitudService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Solicitud> solicitudOptional = solicitudService.findById(id);

        if(solicitudOptional.isPresent()){
            Solicitud solicitud = solicitudOptional.get();

            SolicitudDTO solicitudDTO = SolicitudDTO.builder()
                    .id(solicitud.getId())
                    .docente(solicitud.getDocente())
                    .curso(solicitud.getCurso())
                    .fechaHoraPrestamoEstipulado(solicitud.getFechaHoraPrestamoEstipulado())
                    .fechaHoraDevolucionEstipulada(solicitud.getFechaHoraDevolucionEstipulada())
                    .usuario(solicitud.getUsuario())
                    .equipo(solicitud.getEquipo())
                    .prestamo(solicitud.getPrestamo())
                    .build();
            return ResponseEntity.ok(solicitudDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<SolicitudDTO> solicitudDTOList = solicitudService.findAll()
                .stream()
                .map(solicitud -> SolicitudDTO.builder()
                        .id(solicitud.getId())
                        .docente(solicitud.getDocente())
                        .curso(solicitud.getCurso())
                        .fechaHoraPrestamoEstipulado(solicitud.getFechaHoraPrestamoEstipulado())
                        .fechaHoraDevolucionEstipulada(solicitud.getFechaHoraDevolucionEstipulada())
                        .usuario(solicitud.getUsuario())
                        .equipo(solicitud.getEquipo())
                        .prestamo(solicitud.getPrestamo())
                        .build())
                .toList();
        return ResponseEntity.ok(solicitudDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SolicitudDTO solicitudDTO) throws URISyntaxException {
        if(solicitudDTO.getUsuario()==null){
            return ResponseEntity.badRequest().build();
        }

        solicitudService.save(Solicitud.builder()
                .docente(solicitudDTO.getDocente())
                .curso(solicitudDTO.getCurso())
                .fechaHoraDevolucionEstipulada(solicitudDTO.getFechaHoraDevolucionEstipulada())
                .fechaHoraPrestamoEstipulado(solicitudDTO.getFechaHoraPrestamoEstipulado())
                .usuario(solicitudDTO.getUsuario())
                .equipo(solicitudDTO.getEquipo())
                .prestamo(solicitudDTO.getPrestamo())
                .build());
        return ResponseEntity.created(new URI("/api/solicitud/save")).build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SolicitudDTO solicitudDTO){
        Optional<Solicitud> solicitudOptional = solicitudService.findById(id);

        if(solicitudOptional.isPresent()){
            Solicitud solicitud = solicitudOptional.get();
            solicitud.setCurso(solicitudDTO.getCurso());
            solicitud.setEquipo(solicitudDTO.getEquipo());
            solicitud.setDocente(solicitudDTO.getDocente());
            solicitud.setUsuario(solicitudDTO.getUsuario());
            solicitud.setPrestamo(solicitudDTO.getPrestamo());
            solicitud.setFechaHoraDevolucionEstipulada(solicitudDTO.getFechaHoraDevolucionEstipulada());
            solicitud.setFechaHoraPrestamoEstipulado(solicitudDTO.getFechaHoraPrestamoEstipulado());
            return ResponseEntity.ok("Registro ctualizado!!!");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            solicitudService.deleteByID(id);
            return ResponseEntity.ok("Registro eliminado!!!");
        }
        return ResponseEntity.badRequest().build();
    }

}










