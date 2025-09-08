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
 * Entidad que representa un nodo del sistema eléctrico
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NODO")
public class Node extends Audit {
    
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
    @Column(name = "nodo_codigo", length = 12)
    private String nodoCodigo;
    
    @Column(name = "nodo_descripcion", length = 200)
    private String nodoDescripcion;
    
    @Column(name = "tipo_nodo_id")
    private Integer tipoNodoId;
    
    @Column(name = "nivel_tension")
    private Integer nivelTension;
    
    @Column(name = "alimentador_codigo", length = 12)
    private String alimentadorCodigo;
    
    @Column(name = "zona_codigo", length = 3)
    private String zonaCodigo;
    
    @Column(name = "central_codigo", length = 6)
    private String centralCodigo;
    
    @Column(name = "coordenada_norte")
    private Double coordenadaNorte;
    
    @Column(name = "coordenada_este")
    private Double coordenadaEste;
    
    @Column(name = "distrito_codigo", length = 6)
    private String distritoCodigo;
}
