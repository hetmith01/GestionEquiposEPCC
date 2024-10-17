package com.Epcc.gestionEquipos.controller;


import com.Epcc.gestionEquipos.controller.dto.SolicitudDTO;
import com.Epcc.gestionEquipos.entities.Solicitud;
import com.Epcc.gestionEquipos.service.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
/*
private Long id;
    private String docente;
    private String curso;
    private LocalDateTime fechaHoraPrestamoEstipulado;
    private LocalDateTime fechaHoraDevolucionEstipulada;
    private Usuario usuario;
    private Equipo equipo;
    private Prestamo prestamo;

*/

