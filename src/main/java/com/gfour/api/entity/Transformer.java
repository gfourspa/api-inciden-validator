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
 * Entidad que representa un transformador
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRANSFORMADOR")
public class Transformer extends Audit {
    
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
    @Column(name = "central_codigo", length = 6)
    private String centralCodigo;
    
    @NotNull
    @Column(name = "transformador_codigo", length = 8)
    private String transformadorCodigo;
    
    @Column(name = "transformador_descripcion", length = 200)
    private String transformadorDescripcion;
    
    @Column(name = "tipo_transformador_id")
    private Integer tipoTransformadorId;
    
    @Column(name = "propietario_transformador_id")
    private Integer propietarioTransformadorId;
    
    @Column(name = "potencia_nominal")
    private Double potenciaNominal;
    
    @Column(name = "zona_codigo", length = 3)
    private String zonaCodigo;
}
