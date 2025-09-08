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
 * Entidad que representa la tabla aviso
 * Contiene información sobre los avisos relacionados con interrupciones
 */
@Entity
@Table(name = "aviso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(NoticeDetailPK.class)
public class NoticeDetail extends Audit {

    @Id
    @Column(name = "empresa_id", length = 3, nullable = false)
    private String empresaId;

    @Id
    @Column(name = "periodo_star", length = 6, nullable = false)
    private String periodoStar;

    @Id
    @Column(name = "interrupcion_id", length = 18, nullable = false)
    private String interrupcionId;

    @Id
    @Column(name = "aviso_id", nullable = false)
    private Integer avisoId;

    @Column(name = "tipo_aviso_id", nullable = false)
    private Integer tipoAvisoId;

    @Column(name = "punto_suministro_id", length = 30)
    private String puntoSuministroId;

    @Column(name = "descripcion_aviso", length = 200, nullable = false)
    private String descripcionAviso;

    @Column(name = "presentacion_id", length = 25)
    private String presentacionId;
}

/**
 * Clase para la clave primaria compuesta de NoticeDetail
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class NoticeDetailPK extends Audit {
    private String empresaId;
    private String periodoStar;
    private String interrupcionId;
    private Integer avisoId;
}
