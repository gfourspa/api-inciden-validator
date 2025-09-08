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
 * Entidad que representa la tabla tipo_evento_red
 * Contiene información sobre los tipos de eventos de red
 */
@Entity
@Table(name = "tipo_evento_red")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NetworkEventType extends Audit {

    @Id
    @Column(name = "tipo_evento_id", nullable = false)
    private Integer tipoEventoId;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;
}
