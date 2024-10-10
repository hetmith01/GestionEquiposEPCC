package com.Epcc.gestionEquipos.controller;

import com.Epcc.gestionEquipos.controller.dto.MuebleDTO;
import com.Epcc.gestionEquipos.entities.Mueble;
import com.Epcc.gestionEquipos.service.IMuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mueble")
public class MuebleController {

    @Autowired
    private IMuebleService muebleService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Mueble> muebleOptional = muebleService.findById(id);
        if(muebleOptional.isPresent()){
            Mueble mueble = muebleOptional.get();

            MuebleDTO muebleDTO = MuebleDTO.builder()
                    .id(mueble.getId())
                    .codigoPatrimonial(mueble.getCodigoPatrimonial())
                    .nombre(mueble.getNombre())
                    .ambiente(mueble.getAmbiente())
                    .build();
            return ResponseEntity.ok(muebleDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<MuebleDTO> muebleDTOList = muebleService.findAll()
                .stream()
                .map(mueble -> MuebleDTO.builder()
                        .id(mueble.getId())
                        .codigoPatrimonial(mueble.getCodigoPatrimonial())
                        .nombre(mueble.getNombre())
                        .ambiente(mueble.getAmbiente())
                        .build())
                .toList();
        return ResponseEntity.ok(muebleDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MuebleDTO muebleDTO)throws URISyntaxException{
        if(muebleDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        muebleService.save(Mueble.builder()
                .nombre(muebleDTO.getNombre())
                .codigoPatrimonial(muebleDTO.getCodigoPatrimonial())
                .ambiente(muebleDTO.getAmbiente())
                .build());
        return ResponseEntity.created(new URI("/api/mueble/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MuebleDTO muebleDTO){
        Optional<Mueble> muebleOptional = muebleService.findById(id);
        if(muebleOptional.isPresent()){
            Mueble mueble = muebleOptional.get();
            mueble.setNombre(muebleDTO.getNombre());
            mueble.setAmbiente(muebleDTO.getAmbiente());
            mueble.setCodigoPatrimonial(muebleDTO.getCodigoPatrimonial());
            muebleService.save(mueble);
            return ResponseEntity.ok("Registro actualizado!!!");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            muebleService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado!!!");
        }
        return ResponseEntity.badRequest().build();
    }
}


















