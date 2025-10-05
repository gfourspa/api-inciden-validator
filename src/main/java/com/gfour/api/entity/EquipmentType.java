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
 * Entidad que representa la tabla tipo_equipo
 * Contiene información sobre los tipos de equipos
 */
@Entity
@Table(name = "tipo_equipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentType extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "tipo_equipo_id", length = 50)
    private String tipoEquipoId;

    @Column(name = "descripcion", length = 50)
    private String descripcion;
}
