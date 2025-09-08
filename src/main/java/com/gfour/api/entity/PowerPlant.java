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
 * Entidad que representa una central eléctrica
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CENTRAL")
public class PowerPlant extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "empresa_id", length = 3)
    private String empresaId;
    
    @NotNull
    @Column(name = "central_codigo", length = 6)
    private String centralCodigo;
    
    @Column(name = "central_descripcion", length = 200)
    private String centralDescripcion;
    
    @Column(name = "tipo_central_id")
    private Integer tipoCentralId;
    
    @Column(name = "nivel_tension")
    private Integer nivelTension;
    
    @Column(name = "zona_codigo", length = 3)
    private String zonaCodigo;
    
    @Column(name = "coordenada_norte")
    private Double coordenadaNorte;
    
    @Column(name = "coordenada_este")
    private Double coordenadaEste;
    
    @Column(name = "distrito_codigo", length = 6)
    private String distritoCodigo;
}
