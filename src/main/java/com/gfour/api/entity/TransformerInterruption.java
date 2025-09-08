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
 * Entidad que representa la interrupción de un transformador
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRANSFORMADOR_INTERRUPCION")
public class TransformerInterruption extends Audit {
    
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
    @Column(name = "bloque_reposicion_id")
    private Integer bloqueReposicionId;
    
    @NotNull
    @Column(name = "transformador_id", length = 8)
    private String transformadorId;
    
    @Column(name = "fecha_inicio_interrupcion")
    private String fechaInicioInterrupcion;
    
    @Column(name = "fecha_fin_interrupcion")
    private String fechaFinInterrupcion;
    
    @Column(name = "potencia_interrumpida")
    private Double potenciaInterrumpida;
}
