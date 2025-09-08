package com.gfour.api.entity;

import java.math.BigDecimal;

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
 * Entidad que representa la tabla data_inter3
 * Contiene información de datos de interrupción versión 3
 */
@Entity
@Table(name = "data_inter3")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(DataInter3PK.class)
public class DataInter3 extends Audit {

    @Id
    @Column(name = "empresa_id", length = 5, nullable = false)
    private String empresaId;

    @Id
    @Column(name = "periodo_star", length = 9, nullable = false)
    private String periodoStar;

    @Id
    @Column(name = "incidencia_id", nullable = false)
    private Integer incidenciaId;

    @Id
    @Column(name = "nodo_incidencia_id", nullable = false)
    private Integer nodoIncidenciaId;

    @Column(name = "tipo_instalacion_id", nullable = false)
    private Integer tipoInstalacionId;

    @Column(name = "utm_x", precision = 9, scale = 3, nullable = false)
    private BigDecimal utmX;

    @Column(name = "utm_y", precision = 10, scale = 3, nullable = false)
    private BigDecimal utmY;
}

/**
 * Clase para la clave primaria compuesta de DataInter3
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
class DataInter3PK extends Audit {
    private String empresaId;
    private String periodoStar;
    private Integer incidenciaId;
    private Integer nodoIncidenciaId;
}
