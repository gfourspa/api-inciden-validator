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
 * Entidad que representa el estado de comuna empresa SD
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ESTADO_COMUNA_EMPRESA_SD")
public class CommuneCompanySDStatus extends Audit {
    
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
    @Column(name = "interrupcion_id", length = 18)
    private String interrupcionId;
    
    @Column(name = "bloque_reposicion_id")
    private Integer bloqueReposicionId;
    
    @Column(name = "tipo_interrupcion_id")
    private Integer tipoInterrupcionId;
    
    @Column(name = "comuna_codigo", length = 5)
    private String comunaCodigo;
    
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    
    @Column(name = "fecha_fin")
    private String fechaFin;
    
    @Column(name = "clientes_sin_suministro")
    private Integer clientesSinSuministro;
    
    @Column(name = "energia_no_suministrada")
    private Double energiaNoSuministrada;
}
