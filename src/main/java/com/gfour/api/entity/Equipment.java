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
 * Entidad que representa un equipo
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EQUIPO")
public class Equipment extends Audit {
    
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
    @Column(name = "equipo_codigo", length = 12)
    private String equipoCodigo;
    
    @Column(name = "equipo_descripcion", length = 200)
    private String equipoDescripcion;
    
    @Column(name = "tipo_equipo_id")
    private Integer tipoEquipoId;
    
    @Column(name = "nivel_tension")
    private Integer nivelTension;
    
    @Column(name = "alimentador_codigo", length = 12)
    private String alimentadorCodigo;
    
    @Column(name = "zona_codigo", length = 3)
    private String zonaCodigo;
    
    @Column(name = "central_codigo", length = 6)
    private String centralCodigo;
}
