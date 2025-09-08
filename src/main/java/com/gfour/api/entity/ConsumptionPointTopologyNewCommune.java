package com.gfour.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla punto_consumo_topologianewcomun
 * Contiene información sobre la topología de puntos de consumo nueva común
 */
@Entity
@Table(name = "punto_consumo_topologia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(ConsumptionPointTopologyNewCommunePK.class)
public class ConsumptionPointTopologyNewCommune extends Audit {

    @Id
    @Column(name = "empresa_id", length = 3, nullable = false)
    private String empresaId;

    @Id
    @Column(name = "periodo_star", length = 6, nullable = false)
    private String periodoStar;

    @Id
    @Column(name = "incidencia_id", nullable = false)
    private Integer incidenciaId;

    @Id
    @Column(name = "punto_consumo_id", nullable = false)
    private Integer puntoConsumoId;

    @Column(name = "tipo_tension_id", nullable = false)
    private Integer tipoTensionId;

    @Column(name = "transformador_id", nullable = false)
    private Integer transformadorId;

    @Column(name = "tipo_ruralidad_id", nullable = false)
    private Integer tipoRuralidadId;

    @Column(name = "nodo_incidencia_id", nullable = false)
    private Long nodoIncidenciaId;

    @Column(name = "tipo_empalme_id", nullable = false)
    private Integer tipoEmpalmeId;

    @Column(name = "punto_suministro_id", length = 30, nullable = false)
    private String puntoSuministroId;

    @Column(name = "comuna_id", nullable = false)
    private Integer comunaId;

    @Column(name = "activo_inicial")
    private Short activoInicial;

    @Column(name = "activo_final")
    private Short activoFinal;

    @Column(name = "energizado_inicial", nullable = false)
    private Short energizadoInicial;

    @Column(name = "energizado_final", nullable = false)
    private Short energizadoFinal;

    @Column(name = "numero_fases", nullable = false)
    private Integer numeroFases;
}

/**
 * Clase para la clave primaria compuesta de ConsumptionPointTopologyNewCommune
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class ConsumptionPointTopologyNewCommunePK extends Audit {
    private String empresaId;
    private String periodoStar;
    private Integer incidenciaId;
    private Integer puntoConsumoId;
}
