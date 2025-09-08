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
 * Entidad que representa una fuente de energía de red
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FUENTE_ENERGIA_RED")
public class NetworkEnergySource extends Audit {
    
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
    @Column(name = "fuente_energia_red_id")
    private Integer fuenteEnergiaRedId;
    
    @Column(name = "nodo_incidencia_id")
    private Integer nodoIncidenciaId;
    
    @Column(name = "tipo_fuente_id")
    private Integer tipoFuenteId;
    
    @Column(name = "potencia_disponible")
    private Double potenciaDisponible;
    
    @Column(name = "tension_nominal")
    private Double tensionNominal;
}
