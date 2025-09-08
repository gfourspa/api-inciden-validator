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
 * Entidad que representa la tabla tipo_conexion_nodo
 * Contiene información sobre los tipos de conexión de nodos
 */
@Entity
@Table(name = "tipo_conexion_nodo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NodeConnectionType extends Audit {

    @Id
    @Column(name = "tipo_conexion_nodo_id", nullable = false)
    private Integer tipoConexionNodoId;

    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
}
