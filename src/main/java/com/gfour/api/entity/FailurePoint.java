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
 * Entidad que representa un punto de falla en el sistema eléctrico
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PUNTO_FALLA")
public class FailurePoint extends Audit {
    
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
    @Column(name = "interrupcion_id", length = 18)
    private String interrupcionId;
    
    @NotNull
    @Column(name = "punto_falla_id", length = 18)
    private String puntoFallaId;
    
    @NotNull
    @Column(name = "equipo_fallado_id", length = 12)
    private String equipoFalladoId;
    
    @Column(name = "coordenada_norte")
    private Double coordenadaNorte;
    
    @Column(name = "coordenada_este")
    private Double coordenadaEste;
    
    @Column(name = "distrito_codigo", length = 6)
    private String distritoCodigo;
}
