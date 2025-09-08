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
 * Entidad que representa la topología de un equipo
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EQUIPO_TOPOLOGIA")
public class EquipmentTopology extends Audit {
    
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
    @Column(name = "equipo_id", length = 12)
    private String equipoId;
    
    @Column(name = "nodo_origen_id", length = 12)
    private String nodoOrigenId;
    
    @Column(name = "nodo_destino_id", length = 12)
    private String nodoDestinoId;
    
    @Column(name = "estado_equipo_id")
    private Integer estadoEquipoId;
    
    @Column(name = "impedancia_equipo")
    private Double impedanciaEquipo;
}
