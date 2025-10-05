package com.gfour.api.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla estado_comuna_empresa_sd
 * Contiene información sobre el estado de comuna empresa SD
 */
@Entity
@Table(name = "estado_comuna_empresa_sd")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommuneCompanySDState extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "periodo_star", length = 6)
    private String periodoStar;

    @Column(name = "empresa_id", length = 3)
    private String empresaId;

    @Column(name = "comuna_id")
    private Integer comunaId;

    @Column(name = "interrupcion_id", length = 18)
    private String interrupcionId;

    @Column(name = "bloque_reposicion_id")
    private Integer bloqueReposicionId;

    @Column(name = "estado_par_ce_id")
    private Integer estadoParCeId;

    @Column(name = "fc_inicio_estado", length = 50)
    private String fcInicioEstado;

    @Column(name = "fc_termino_estado", length = 50)
    private String fcTerminoEstado;

    @Column(name = "tipo_interrupcion_id")
    private Integer tipoInterrupcionId;

    @Column(name = "tipo_estado_sd_id")
    private Integer tipoEstadoSdId;

    @Column(name = "tasa_reposicion", precision = 8, scale = 4)
    private BigDecimal tasaReposicion;
}
