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
 * Entidad que representa la tabla tipo_efecto_evento
 * Contiene información sobre los tipos de efectos de eventos
 */
@Entity
@Table(name = "tipo_efecto_evento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventEffectType extends Audit {

    @Id
    @Column(name = "tipo_efecto_evento_id", nullable = false)
    private Integer tipoEfectoEventoId;

    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
}
