package com.gfour.api.entity;

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
 * Entidad que representa la tabla conectividad
 * Contiene información sobre la conectividad entre nodos de incidencia
 */
@Entity
@Table(name = "conectividad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Connectivity extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "id_tramo", length = 100)
    private String idTramo;

    @Column(name = "incidencia_id", length = 100)
    private String incidenciaId;

    @Column(name = "nodo_incidencia_id_1", length = 100)
    private String nodoIncidenciaId1;

    @Column(name = "nodo_incidencia_id_2", length = 100)
    private String nodoIncidenciaId2;

    @Column(name = "conectividad", length = 100)
    private String conectividad;
}
