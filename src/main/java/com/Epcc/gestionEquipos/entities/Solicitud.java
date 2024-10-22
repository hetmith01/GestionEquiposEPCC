package com.Epcc.gestionEquipos.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String docente;

    private String curso;

    @Column(name = "fecha_hora_prestamo_estipolado")
    private LocalDateTime fechaHoraPrestamoEstipulado;

    @Column(name = "fecha_hora_devolucion_estipolada")
    private LocalDateTime fechaHoraDevolucionEstipulada;

    private String estado; //enviado, en curso, terminado o inconcluso

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    @JsonIgnore
    private Equipo equipo;


    @OneToOne(mappedBy = "solicitud")
    @JsonIgnore
    private Prestamo prestamo;


}
