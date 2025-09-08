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
 * Entidad que representa la tabla periodo_informacion
 * Contiene información sobre los periodos de información por empresa
 */
@Entity
@Table(name = "periodo_informacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(InformationPeriodPK.class)
public class InformationPeriod extends Audit {

    @Id
    @Column(name = "empresa_id", length = 3, nullable = false)
    private String empresaId;

    @Id
    @Column(name = "periodo_star", length = 6, nullable = false)
    private String periodoStar;

    @Column(name = "mes_informa", length = 6, nullable = false)
    private String mesInforma;
}

/**
 * Clase para la clave primaria compuesta de InformationPeriod
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class InformationPeriodPK extends Audit {
    private String empresaId;
    private String periodoStar;
}
