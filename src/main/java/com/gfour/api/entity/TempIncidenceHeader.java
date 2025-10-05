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
 * Entidad que representa la tabla tmp_incidencia_cabecera
 * Contiene información temporal sobre cabeceras de incidencias
 */
@Entity
@Table(name = "tmp_incidencia_cabecera")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TempIncidenceHeader extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "nodo_incidencia_id")
    private Integer nodoIncidenciaId;
}
