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
 * Entidad que representa una subestación de incidencia
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SUBESTACION_INCIDENCIA")
public class IncidenceSubstation extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "empresa_id", length = 3)
    private String empresaId;
    
    @NotNull
    @Column(name = "periodo_star", length = 6)
    private String periodoStar;
    
    @NotNull
    @Column(name = "incidencia_id")
    private Integer incidenciaId;
    
    @NotNull
    @Column(name = "subestacion_incidencia_id")
    private Integer subestacionIncidenciaId;
    
    @Column(name = "subestacion_codigo", length = 8)
    private String subestacionCodigo;
    
    @Column(name = "tipo_subestacion_id")
    private Integer tipoSubestacionId;
    
    @Column(name = "nivel_tension")
    private Integer nivelTension;
    
    @Column(name = "capacidad_subestacion")
    private Double capacidadSubestacion;
}
