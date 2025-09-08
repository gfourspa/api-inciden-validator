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
 * Entidad que representa la tabla tipo_nodo
 * Contiene información sobre los tipos de nodos
 */
@Entity
@Table(name = "tipo_nodo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NodeType extends Audit {

    @Id
    @Column(name = "tipo_nodo_id", nullable = false)
    private Integer tipoNodoId;

    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
}
