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
 * Entidad que representa la tabla err_tablas_interrupcion
 * Contiene información sobre errores en tablas de interrupción
 */
@Entity
@Table(name = "err_tablas_interrupcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterruptionTableError extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "chequeo", length = 100)
    private String chequeo;

    @Column(name = "empresa_id", length = 3)
    private String empresaId;

    @Column(name = "periodo_star", length = 20)
    private String periodoStar;

    @Column(name = "tabla_padre", length = 100)
    private String tablaPadre;

    @Column(name = "incidencia_padre", length = 100)
    private String incidenciaPadre;

    @Column(name = "tabla_hija", length = 100)
    private String tablaHija;

    @Column(name = "incidencia_hija")
    private Integer incidenciaHija;

    @Column(name = "cant")
    private Integer cant;
}
