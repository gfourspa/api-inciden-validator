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
 * Entidad que representa la tabla equipo_instalacion_servicio
 * Contiene información sobre equipos de instalación y servicios
 */
@Entity
@Table(name = "equipo_instalacion_servicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentInstallationService extends Audit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "po_facility_type", nullable = false)
    private Integer poFacilityType;

    @Column(name = "po_facility_name", length = 48)
    private String poFacilityName;

    @Column(name = "tipo_equipo_id")
    private Integer tipoEquipoId;

    @Column(name = "tipo_equipo_desc", length = 60)
    private String tipoEquipoDesc;

    @Column(name = "tipo_instalacion_id", nullable = false)
    private Integer tipoInstalacionId;

    @Column(name = "tipo_instalacion_desc", length = 60)
    private String tipoInstalacionDesc;

    @Column(name = "tipo_servicio_id")
    private Integer tipoServicioId;

    @Column(name = "tipo_servicio_sec", length = 60)
    private String tipoServicioSec;
}
