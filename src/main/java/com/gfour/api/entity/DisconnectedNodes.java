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
 * Entidad que representa la tabla nodos_desconectados
 * Contiene información sobre nodos desconectados
 */
@Entity
@Table(name = "nodos_desconectados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisconnectedNodes extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "incidencia_id")
    private Integer incidenciaId;

    @Column(name = "nodo_incidencia_id")
    private Long nodoIncidenciaId;

    @Column(name = "observacion", length = 250)
    private String observacion;

    @Column(name = "alimentador_id")
    private Integer alimentadorId;

    @Column(name = "tabla_dato", length = 100)
    private String tablaDato;

    @Column(name = "tabla_padre", length = 100)
    private String tablaPadre;
}
