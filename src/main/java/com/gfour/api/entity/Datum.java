package com.gfour.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla datum
 * Contiene información sobre los tipos de datum
 */
@Entity
@Table(name = "datum")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Datum extends Audit {

    @Column(name = "datum_id", nullable = false)
    private Integer datumId;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
}
