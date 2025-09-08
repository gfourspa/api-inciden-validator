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
 * Entidad que representa un punto de suministro de incidencia
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PUNTO_SUMINISTRO_INCIDENCIA")
public class IncidenceSupplyPoint extends Audit {
    
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
    @Column(name = "punto_suministro_id")
    private Integer puntoSuministroId;
    
    @Column(name = "tipo_suministro_id")
    private Integer tipoSuministroId;
    
    @Column(name = "capacidad_suministro")
    private Double capacidadSuministro;
    
    @Column(name = "tension_suministro")
    private Double tensionSuministro;
    
    @Column(name = "estado_suministro_id")
    private Integer estadoSuministroId;
}
