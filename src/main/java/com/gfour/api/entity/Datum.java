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

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "datum_id", nullable = false)
    private Integer datumId;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;
}
