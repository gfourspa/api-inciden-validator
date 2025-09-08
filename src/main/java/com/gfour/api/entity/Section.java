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
 * Entidad que representa un tramo del sistema eléctrico
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRAMO")
public class Section extends Audit {
    
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
    @Column(name = "tramo_codigo", length = 12)
    private String tramoCodigo;
    
    @Column(name = "tramo_descripcion", length = 200)
    private String tramoDescripcion;
    
    @Column(name = "tipo_tramo_id")
    private Integer tipoTramoId;
    
    @Column(name = "nivel_tension")
    private Integer nivelTension;
    
    @Column(name = "alimentador_codigo", length = 12)
    private String alimentadorCodigo;
    
    @Column(name = "zona_codigo", length = 3)
    private String zonaCodigo;
    
    @Column(name = "central_codigo", length = 6)
    private String centralCodigo;
    
    @Column(name = "nodo_origen_codigo", length = 12)
    private String nodoOrigenCodigo;
    
    @Column(name = "nodo_destino_codigo", length = 12)
    private String nodoDestinoCodigo;
    
    @Column(name = "longitud")
    private Double longitud;
}
