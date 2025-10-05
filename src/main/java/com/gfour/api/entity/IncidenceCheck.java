package com.gfour.api.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla chequeo_incidencia
 * Contiene información sobre chequeos de incidencias entre tablas padre e hija
 */
@Entity
@Table(name = "chequeo_incidencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceCheck extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "tablapadre", length = 50)
    private String tablaPadre;

    @Column(name = "incidencia_id_padre", length = 50)
    private String incidenciaIdPadre;

    @Column(name = "tablahija", length = 50)
    private String tablaHija;

    @Column(name = "incidencia_id_hija", length = 50)
    private String incidenciaIdHija;
}
