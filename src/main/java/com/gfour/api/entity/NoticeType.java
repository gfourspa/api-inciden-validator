package com.gfour.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla tipo_aviso
 * Contiene información sobre los tipos de avisos
 */
@Entity
@Table(name = "tipo_aviso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeType extends Audit {

    @Id
    @Column(name = "tipo_aviso_id", nullable = false)
    private Integer tipoAvisoId;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;
}
