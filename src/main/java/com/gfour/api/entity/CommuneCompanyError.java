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
 * Entidad que representa la tabla err_comuna_empresa
 * Contiene información sobre errores de comuna empresa
 */
@Entity
@Table(name = "err_comuna_empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommuneCompanyError extends Audit {

    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "tipotabla", length = 100)
    private String tipoTabla;

    @Column(name = "tabla", length = 80)
    private String tabla;

    @Column(name = "interrupcion_id", length = 80)
    private String interrupcionId;

    @Column(name = "incidencia_id", length = 80)
    private String incidenciaId;

    @Column(name = "tabla_hija", length = 80)
    private String tablaHija;
}
