package com.gfour.api.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidad que representa un tipo de incidencia
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TIPO_INCIDENCIA")
public class IncidenceType extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "tipo_incidencia_id")
    private Integer tipoIncidenciaId;
    
    @Column(name = "tipo_incidencia_descripcion", length = 200)
    private String tipoIncidenciaDescripcion;
    
    @Column(name = "tipo_incidencia_abreviacion", length = 10)
    private String tipoIncidenciaAbreviacion;
}
