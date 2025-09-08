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
 * Entidad que representa una incidencia en el sistema eléctrico
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "INCIDENCIA")
public class Incidence extends Audit {
    
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
    
    @Column(name = "fecha_incidencia")
    private String fechaIncidencia;
    
    @Column(name = "tipo_incidencia_id")
    private Integer tipoIncidenciaId;
    
    @Column(name = "origen_incidencia_id")
    private Integer origenIncidenciaId;
    
    @Column(name = "causa_incidencia_id")
    private Integer causaIncidenciaId;
    
    @Column(name = "estado_incidencia_id")
    private Integer estadoIncidenciaId;
    
    @Column(name = "descripcion_incidencia", length = 500)
    private String descripcionIncidencia;
}
