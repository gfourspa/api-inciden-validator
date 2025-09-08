package com.gfour.api.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidad que representa un alimentador afectado por una incidencia
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ALIMENTADOR_AFECTADO")
public class AffectedFeeder extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "empresa_id", length = 3)
    private String empresaId;
    
    @NotNull
    @Column(name = "periodo_star", length = 6)
    private String periodoStar;
    
    @NotNull
    @Column(name = "incidencia_id")
    private Integer incidenciaId;
    
    @NotNull
    @Column(name = "interrupcion_id", length = 18)
    private String interrupcionId;
    
    @NotNull
    @Column(name = "alimentador_id", length = 12)
    private String alimentadorId;
    
    @Column(name = "fecha_inicio_afectacion")
    private String fechaInicioAfectacion;
    
    @Column(name = "fecha_fin_afectacion")
    private String fechaFinAfectacion;
    
    @Column(name = "porcentaje_afectacion")
    private Double porcentajeAfectacion;
}
