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
 * Entidad que representa la tabla err_carga_inc
 * Contiene información sobre errores de carga de incidencias
 */
@Entity
@Table(name = "err_carga_inc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceLoadError extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "error", length = 10)
    private String error;

    @Column(name = "tabla", length = 255)
    private String tabla;

    @Column(name = "incidencia", length = 50)
    private String incidencia;

    @Column(name = "tabla_padre", length = 255)
    private String tablaPadre;

    @Column(name = "id_padre", length = 250)
    private String idPadre;

    @Column(name = "tipo", length = 100)
    private String tipo;
}
